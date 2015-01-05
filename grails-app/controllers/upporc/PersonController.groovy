package upporc


import grails.converters.JSON
import grails.converters.XML


class PersonController {
    def index() {
        def persons = Person.list()
        //render "checking"
        [persons:persons]
    }


    def form() {
    }  /*pass to form.gsp */

    def add() {
        def person = new Person(params)
        person.save()
        //render "Success!"

        redirect(action: "index")

    }

    def list() {
        render (contentType: "application/json"){
            persons =array {
                for (b in Person.list()) {
                    element(firstName: b.firstName, lastName: b.lastName)
                }
            }
        }

        render Person.list() as XML
    }

    def login() {
        render "you logged in"
    }

    def find() {
            if (!session.user)
                redirect(action: 'login')
            return
    }


}