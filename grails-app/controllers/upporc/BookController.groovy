package upporc

class BookController {


    def form() {
    }  /*pass to form.gsp */

    def save() {
        def book = new Book(params)
        book.save()
        //render "Success!"

        redirect(controller: "book",action: "index")

    }

    def index() {
        def books = Book.list()
        [books: books]

        /*render "this is book page."*/}

    def template() {
        def books = Book.list()
        render "Book Lists"
        String contents = g.render(template: "bookTemplate", model: [book: books])
        render contents

        render(template: "bookTemplate", model: [book: books])
    }
}
