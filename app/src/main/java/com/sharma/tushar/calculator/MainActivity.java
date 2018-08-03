package com.sharma.tushar.calculator;

/**
 * This Calculator converts every expression in textView to a String value.
 * Every button prints that symbol on the screen.
 * Numbers and their respective symbols are stored in different ArrayLists and
 * that expression is solved based on symbol preference
 * that is multiplication and division are solved first.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TEXT_INPUT = "keyToTextviewContent";

    private TextView displayNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayNumber = findViewById(R.id.display);
        if(savedInstanceState != null &&
                savedInstanceState.getString(TEXT_INPUT) != null) {
            displayNumber.setText(savedInstanceState.getString(TEXT_INPUT));
        }
        displayNumber.setMovementMethod(new ScrollingMovementMethod());
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        ButtonClickOperations.setNormalOperations(viewGroup.getRootView());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_INPUT,displayNumber.getText().toString() );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.show_scientific, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.change_to_scientific) {
            Intent changeToScientificLayout = new Intent();
            return true;
        }
        return onOptionsItemSelected(item);
    }

}