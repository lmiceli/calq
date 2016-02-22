package com.pacho.android.calq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

       /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

        calculator = new Calculator(resultTextView);

    }

    public void numberPressed (View view) {
//        Intent intent = new Intent (this, Main2Activity.class);
//        startActivity(intent);

        Log.d("some tag", "number pressed called");
//        TODO check error case
//        TODO this is not working with more than one digit
        Button b = (Button) view;
        String buttonText = b.getText().toString();

        int number = Integer.parseInt(buttonText);
        calculator.numberPressed(number);
    }
    public void operationPressed(View view){
        Log.d("some tag", "operation pressed called");
        //        TODO check error case
        Button b = (Button) view;
        String buttonText = b.getText().toString();
        calculator.operationPressed(buttonText);
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
}
