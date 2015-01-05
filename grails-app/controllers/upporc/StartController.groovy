package upporc

class StartController {

    def index() {
        render(view: "../index")


    }

    def exit() {render "Exiting..."}

    /*
    def file = new File(params.fileDir)
    response.setContentType("application/octet-stream")
    response.setHeader("Content-disposition", "attachment;filename=${file.getName()}")

    response.outputStream << file.newInputStream() // Performing a binary stream copy
    */
}