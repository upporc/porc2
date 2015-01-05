package upporc

class FTPdoc {

    String filename
    String fullPath
    Date uploadDate = new Date()

    static constraints = {
        filename(blank:false,nullable:false)
        fullPath(blank:false,nullable:false)
    }
}