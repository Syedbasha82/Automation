describe('Multiplication Test', function() {
    var calculatorPage = require('../pages/CalculatorPage.js');
    var excel = require('../../helper/excelread.js');
    var using = require('jasmine-data-provider');
    var data = require('../../data/testdata.json');
    var log4js = require('log4js');
    var logger = log4js.getLogger();
  var firstvalue = excel.getValue('../jasmine_POM/tests/MulplicationTest.js', 'FirstValue');
  var secondvalue = excel.getValue('../jasmine_POM/tests/MulplicationTest.js', 'SecondValue');
  var url = excel.getValue('../jasmine_POM/tests/MultiplicationTest.js', 'url');
  var expectedAdditionValue = excel.getValue('../jasmine_POM/tests/MulplicationTest.js', 'expectedAdditionValue');

    beforeEach(function() {
        logger.info("  ");
        logger.info("*****************************************************************************************");
    });

    afterEach(function() {
        logger.info("*****************************************************************************************");
    });

    var mySpec = it('Multiplication of two values', function() {
        logger.info("Starting the Spec: " + mySpec.getFullName());
        calculatorPage.load(url);
        calculatorPage.multiplication(firstvalue,secondvalue);
        calculatorPage.expectValue(expectedAdditionValue.toString());
        logger.info("Ending the Spec: " + mySpec.getFullName());
    });


});
