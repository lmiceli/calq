package com.pacho.android.calq;

/**
 * Created by Pacho on 22/02/2016.
 * <p/>
 * This class does not do any check on number size
 */
public class Calculator {
    private String displayValue;

//    TODO add tests
    private int BASE = 10;

    private Operation currentOperation;
    private double result;
    private double accumulator;
    private boolean isAccumulatorDecimal;
    private int accumulatorDecimalPosition;
    private double previousResult;

    private enum Operation {
        DISPLAY("DISPLAY"),
        SUM("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        private static Operation findBySymbol(String symbol) {
            switch (symbol) {
                case "+":
                    return SUM;
                case "-":
                    return SUBTRACTION;
                case "*":
                    return MULTIPLICATION;
                default:
                    return DIVISION;
            }
        }

    }
    public Calculator() {
        fullReset();
        displayValue = String.valueOf(result);
    }

    public void cPressed() {
        fullReset();
    }

    private void fullReset() {
        result = 0.0;
        readyForNewOperation();
    }

    public void numberPressed(int number) {

        // we may have saved the result in case a new op is called on it.
        // on pressing a number this result is no longer necessary.
        // this is atm being called many times and doing nothing.
        previousResult = 0.0;

        // the number is growing
        if (!isAccumulatorDecimal) {
            accumulator = (accumulator * BASE) + number;
        }
        else {
            // need to cast to double or the division will be int
            accumulator = accumulator + ((double)number / Math.pow(BASE, ++accumulatorDecimalPosition));
        }
        displayValue = String.valueOf(accumulator);
    }

    public void operationPressed(String symbol) {

        // we may have saved the result in case a new op is called on it.
        if (previousResult > 0) {
            result += previousResult;
            previousResult = 0.0;
        }

        // finish possible previous chain of calculation
        calculate();
        currentOperation = Operation.findBySymbol(symbol);
        displayValue = String.valueOf(result);
        // decimal status is readyForNewOperation as the acumulation would start again
        resetAccumulator();
    }

    public void commaPressed() {
        if (!isAccumulatorDecimal) {
            isAccumulatorDecimal = true;
        }
        // when an operation or equals is called, I decimal status should be readyForNewOperation
    }

    public String getDisplayValue() {
        return displayValue;
    }

    private void calculate() {

        switch (currentOperation) {
            case SUM:
                result += accumulator;
                break;
            case SUBTRACTION:
                result -= accumulator;
                break;
            case MULTIPLICATION:
                result *= accumulator;
                break;
            case DIVISION:
                result /= accumulator;
                break;
            case DISPLAY:
                result += accumulator;
                break;
            default:
                throw new IllegalStateException("Some operation should have applied.");
        }

    }

    public void equalsPressed() {
        calculate();
        displayValue = String.valueOf(result);

        previousResult = result;

        fullReset();
    }

    public void readyForNewOperation() {
        currentOperation = Operation.DISPLAY;
        resetAccumulator();
    }

    public void resetAccumulator() {
        accumulator = 0.0;
        isAccumulatorDecimal = false;
        accumulatorDecimalPosition = 0;
    }

}
