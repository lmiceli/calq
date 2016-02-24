package com.pacho.android.calq;

import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pacho on 23/02/2016.
 */
public class CalculatorTest {

//test
    @Test
    public void sum_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);

        calc.equalsPressed();

        assertEquals("4.0", calc.getDisplayValue());
    }


//    TODO more corner cases
//    TODO repeated equals apply last operation many times

    @Test
    public void twoDigitNumber_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);

        calc.equalsPressed();

        assertEquals("22.0", calc.getDisplayValue());
    }

    @Test
    public void twoDigitSum_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.numberPressed(2);

        calc.equalsPressed();

        assertEquals("44.0", calc.getDisplayValue());
    }

    @Test
    public void consecutiveOperation_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("/");
        calc.numberPressed(5);

        calc.equalsPressed();

        assertEquals("8.8", calc.getDisplayValue());
    }

    @Test
    public void twoDifferentComputations_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.numberPressed(2);

        calc.equalsPressed();

        assertEquals("44.0", calc.getDisplayValue());

        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.numberPressed(2);

        calc.equalsPressed();

        assertEquals("44.0", calc.getDisplayValue());

    }

    @Test
    public void operation_AfterEquals() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.equalsPressed();

        assertEquals("22.0", calc.getDisplayValue());

        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.equalsPressed();

        assertEquals("24.0", calc.getDisplayValue());

    }


    @Test
    public void decimalFirst_NoDecimalInSecond() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.commaPressed();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.equalsPressed();

        assertEquals("24.22", calc.getDisplayValue());

    }

    @Test
    public void decimal_FollowedByOtherOperation() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.commaPressed();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.equalsPressed();

        assertEquals("22.22", calc.getDisplayValue());

        calc.operationPressed("+");
        calc.numberPressed(2);
        calc.equalsPressed();

        assertEquals("24.22", calc.getDisplayValue());

    }

    @Test
    public void decimal_isCorrect() throws Exception {

        Calculator calc = new Calculator();
        calc.numberPressed(2);
        calc.numberPressed(2);
        calc.commaPressed();
        calc.numberPressed(2);
        calc.numberPressed(2);

        assertEquals("22.22", calc.getDisplayValue());
    }

}
