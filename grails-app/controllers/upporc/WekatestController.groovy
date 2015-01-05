package upporc

import grails.converters.* //for xml and json automatic convert
import groovy.sql.Sql

//import org.codehaus.groovy.grails.commons.*
import weka.classifiers.Evaluation
import weka.classifiers.trees.J48
import weka.core.converters.ConverterUtils.DataSource
import weka.core.Range

class WekatestController {

    static dataSource
    Random random = new Random()

    def index() {
        render "blank page"
    }

    def list() {
        def p = WekaTest.get(1)
        render p.name
    }



    def ml() {
        def data = DataSource.read("C:/app/Weka-3-6/data/weather.numeric.arff")
        data.setClassIndex(data.numAttributes() - 1)


        //render j48.binarySplits
        //render j48.confidenceFactor

        def j48 = new J48()
        j48.buildClassifier(data)
        render j48

/*
        Evaluation evaluation = new Evaluation(data)
        //def buffer = new StringBuffer()  // buffer for predictions

        //def buffer = new weka.classifiers.evaluation.output.prediction.XML()
        //buffer.setBuffer(new StringBuffer())

        def buffer = new StringBuffer()

        def attRange = new Range()
        def outputDistribution = false

        evaluation.evaluateModel(j48, data, buffer, attRange, outputDistribution)

        render evaluation.rootMeanSquaredError()
        //render evaluation.confusionMatrix()
        //render evaluation.correct() //total instances
        //render evaluation.avgCost()

*/

    }


}
