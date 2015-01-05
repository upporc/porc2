package upporc

import groovy.sql.Sql
import jxl.Workbook
import jxl.write.Label
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook

import org.grails.plugins.csv.CSVMapReader


class FilemanipulationController {
    static dataSource_postgres

    def test() {
        int a = 2
        int b = 3
        render 2 * 3
    }


    def index() {
        def sql = Sql.newInstance(dataSource_postgres)
        sql.execute("insert into pts2 values (?,?,?)",['002','HbA1c',12] )
        //sql.execute("create table pts3 as select distinct pt_id, attribute, values from pts2")
        sql.execute("drop table chk")
        sql.execute('create table chk (id varchar(10), name varchar(20), age varchar(3))' )
        sql.execute(" insert into chk values('001','Xiangyang Ye', '48')  ")
        //render records
        def rs = sql.rows("select a.*,b.attribute, b.values from chk a left join pts3 b on a.id=b.pt_id")
        [rs:rs]

    }

    def download() {
        def sql = Sql.newInstance(dataSource_postgres)
        //def rs = sql.rows("select * from pts3")

        def rs = sql.rows("select a.*,b.pt_id, b.attribute, b.values from chk a left join pts3 b on a.id=b.pt_id")

        //render rs.values

        response.setContentType('application/vnd.ms-excel')
        response.setHeader('Content-Disposition', 'Attachment;Filename="spreadsheet.xls"')
        WritableWorkbook workbook = Workbook.createWorkbook(response.outputStream)
        WritableSheet sheet1 = workbook.createSheet("ExcelTable", 0)

        sheet1.addCell(new Label(0,0, "ID"))
        sheet1.addCell(new Label(1,0, "Attribute"))
        sheet1.addCell(new Label(2,0, "Values"))

        int i = 1
        for (rss in rs) {
            sheet1.addCell(new Label(0, i, rss.pt_id))
            sheet1.addCell(new Label(1, i, rss.attribute))
            sheet1.addCell(new Label(2, i, rss.values))
            i = i + 1
        }

        workbook.write();
        workbook.close();

    }


    def uploadAction() {
        request.getFile( 'filecsv' )
                .inputStream
                .splitEachLine(',') { fields ->
                    def chk2 = new Chk2( id: fields[0].trim(),
                    name: fields[1].trim(),
                    age: fields[2].trim()
                    )

            if (chk2.hasErrors() || chk2.save(flush: true) == null) {
                log.error("Could not import domainObject  ${chk2.errors}")
            }

            log.debug("Importing domainObject  ${chk2.toString()}")
        }

        render "this is working"
    }

    def csvupload() {
        def file = request.getFile('csvfile')
        file.inputStream.toCsvReader().readNext()
        def allLines = file.inputStream.toCsvReader().readAll() //readNext()//

        render allLines


        for (rss in allLines) {
           render rss
        }

        //render "this is working as well"
        //new CSVMapReader(file).each { map ->
        //    new Chk2(map).save() //assumes the keys match the Country properties
        //}

        [alllines:allLines]
    }


}