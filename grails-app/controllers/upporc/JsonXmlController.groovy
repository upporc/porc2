package upporc

import grails.converters.JSON
import grails.converters.XML

class JsonXmlController {
    static dataSource
    Random random = new Random()

    def index() {
        Double ag = random.nextDouble().round(4) * 100
        def dataWeka = new Wekatest(name: "Ye", age: ag)
        dataWeka.save()
        //render dataWeka.age
    }

    def xml() {
        def results = Wekatest.list()
        render(contentType: "text/xml") {
            wekaData {
                for (b in results) {
                    element(name: b.name, age: b.age)
                }
            }
        }
    }

    def xmlauto() {
        render Wekatest.list() as XML
    }

    def json() {
        def results = Wekatest.list()
        render(contentType: "application/json") {
            wekaData = array {
                for (b in results) {
                    element(name: b.name, age: b.age)
                }
            }

            //render wekaData.list() as JSON
        }
    }

    def jsonauto() {
        //def results = Person.list()
        render Wekatest.list() as JSON

    }
}
