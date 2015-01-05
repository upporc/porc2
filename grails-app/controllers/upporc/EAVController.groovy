package upporc

import groovy.sql.Sql

class EAVController {
    static dataSource_postgres

    def index() {
        //redirect(controller: "EAV", action:"eav")
    }

    def eav(){
        def v1Name = params.var1.toUpperCase()
        //http://stackoverflow.com/questions/11152172/grails-forms-url-mapping

        //groovy sql
        //http://groovy.codehaus.org/gapi/groovy/sql/Sql.html

        //postgresql extension installation
        //http://stackoverflow.com/questions/9025515/how-do-i-import-modules-or-install-extensions-in-postgresql-9-1-9-2-9-3-9-4

        def sql = Sql.newInstance(dataSource_postgres)
        sql.execute("drop table if exists attributes")
        sql.execute("create table if not exists attributes (test_type varchar(20))")
        sql.execute("insert into attributes values (?)",v1Name)   //params.var1 worked

        String drp = "drop table if exists grails" + v1Name
        sql.execute(drp)
        String crt = "create table grails" +  v1Name + " as SELECT * FROM CROSSTAB('SELECT pt_id, attribute, values FROM pts3 ORDER BY 1', " +
                "'SELECT TEST_TYPE FROM attributes') as (id varchar(5), " + v1Name + " varchar(20) )" +
                " where " + v1Name + " is not null"
        sql.execute(crt)

        String finaleav = "SELECT * FROM CROSSTAB('SELECT pt_id, attribute, values FROM pts3 ORDER BY 1', " +
                "'SELECT TEST_TYPE FROM attributes') as (id varchar(5), v1Name  varchar(20) ) where " +
                "v1Name is not null"
        def rs = sql.rows(finaleav)
        [rs:rs,varname:v1Name]
        //render "this is working"
    }

    def merge(){

        def v1 = params.v1.toUpperCase()
        def v2 = params.v2.toUpperCase()

        def sql = Sql.newInstance(dataSource_postgres)
        //sql.execute("drop table if exists ids")
        //String s1 = "create table ids as select id FROM grails" + v1 + " union select id from grails" + v2
       // sql.execute(s1)
        String stmt = "select a.id, b." + v1 + " as v1, c." +v2 + " as v2 " +
                " FROM (select id from grails"+ v1 + " union select id from grails"+v2 +") a " +
                "left join grails" + v1 + " b on a.id=b.id left join grails" + v2 + " c on a.id =c.id"



        def rs = sql.rows(stmt)
        [rs:rs, vname1:v1,vname2:v2]
        //http://stackoverflow.com/questions/4624214/gsp-parameter-passing-from-controller
        //render "this is working"

}
}
