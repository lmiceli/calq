package com.pacho.android.calq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayView = (TextView) findViewById(R.id.displayView);
        calculator = new Calculator();
        updateDisplayView(calculator.getDisplayValue());
    }

    public void numberPressed(View v) {
        Log.d("some tag", "number pressed called");
        int number = Integer.parseInt((String) v.getTag());
        calculator.numberPressed(number);
        updateDisplayView(calculator.getDisplayValue());
    }

    public void operationPressed(View v) {
        Log.d("some tag", "operation pressed called");
        //        TODO check error case
        calculator.operationPressed((String) v.getTag());
        updateDisplayView(calculator.getDisplayValue());
    }

    public void equalsPressed(View v) {
        calculator.equalsPressed();
        updateDisplayView(calculator.getDisplayValue());
    }

    public void cPressed(View v) {
        calculator.cPressed();
        updateDisplayView(calculator.getDisplayValue());
    }

    public void commaPressed(View v) {
        calculator.commaPressed();
        updateDisplayView(calculator.getDisplayValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateDisplayView(String display) {
        displayView.setText(String.valueOf(display));
    }

}
