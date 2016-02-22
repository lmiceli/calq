package com.pacho.android.calq;

import android.widget.TextView;

/**
 * Created by Pacho on 22/02/2016.
 */
public class Calculator {

    //    TODO define and auto apply best practices on indentation
//    TODO manage events properly
//    TODO add tests

    private enum Operation {
        SUM("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        private String symbol;

        Operation(String symbol) {
            this.symbol=symbol;
        }

        private static Operation findBySymbol (String symbol){
            switch (symbol){
                case "+": return SUM;
                case "-": return SUBTRACTION;
                case "*": return MULTIPLICATION;
                default: return DIVISION;
            }
        }
    }

    private double result = 0.0;
    private TextView resultTextView;

    public Calculator(TextView resultTextView) {
        this.resultTextView = resultTextView;
    }

    private Operation currentOperation = Operation.SUM;


    public void numberPressed(int number){
        switch (currentOperation) {
            case DIVISION: result /= number; break;
            case MULTIPLICATION: result *= number; break;
            case SUBTRACTION: result -= number; break;
            default: result += number;
        }

        updateResultView();

//        setContentView(R.layout.layoutName);
//        TextView textView = (TextView) findViewById(R.id.textViewName);
//        textView.setText("text you want to display");

    }

    public void operationPressed(String symbol){
        this.currentOperation = Operation.findBySymbol(symbol);
    }

    private void updateResultView(){
        resultTextView.setText(String.valueOf(result));
    }
}
