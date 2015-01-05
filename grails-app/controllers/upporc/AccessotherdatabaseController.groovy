package upporc


import java.sql.Connection
import java.sql.DriverManager
import javax.sql.DataSource
import groovy.sql.Sql



class AccessotherdatabaseController {

    static dataSource_mysql //added in DataSource.groovy - dataSource and environments sections
    static dataSource_postgres

    def index() {
        def sql = Sql.newInstance(dataSource_mysql)
        def records = sql.rows("select * from person")
        [records:records]
        //render records
    }

    def postgres() {
        def sql = Sql.newInstance(dataSource_postgres)
        def records = sql.rows("select * from pts3")
        //render records

        [records: records]
    }


}