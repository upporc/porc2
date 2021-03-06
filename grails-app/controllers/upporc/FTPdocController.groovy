package upporc


class FTPdocController {

    static allowedMethods = [save: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = 10
        [documentInstanceList: FTPdoc.list(params), documentInstanceTotal: FTPdoc.count()]
    }

    def create() {
    }

    def upload() {
        def file = request.getFile('file')
        if(file.empty) {
            flash.message = "File cannot be empty"
        } else {
            def documentInstance = new FTPdoc()
            documentInstance.filename = file.originalFilename
            documentInstance.fullPath = grailsApplication.config.uploadFolder + documentInstance.filename
            file.transferTo(new File(documentInstance.fullPath))
            documentInstance.save()
        }
        redirect (action:'list')
    }

    def download(long id) {
        FTPdoc documentInstance = FTPdoc.get(id)
        if ( documentInstance == null) {
            flash.message = "FTPdoc not found."
            redirect (action:'list')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")

            def file = new File(documentInstance.fullPath)
            def fileInputStream = new FileInputStream(file)
            def outputStream = response.getOutputStream()

            byte[] buffer = new byte[4096];
            int len;
            while ((len = fileInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }

            outputStream.flush()
            outputStream.close()
            fileInputStream.close()
        }
    }
}
