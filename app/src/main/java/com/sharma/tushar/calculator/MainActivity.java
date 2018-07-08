package com.sharma.tushar.calculator;

/**
 * This Calculator converts every expression in textView to a String value.
 * Every button prints that symbol on the screen.
 * Numbers and their respective symbols are stored in different ArrayLists and
 * that expression is solved based on symbol preference
 * that is multiplication and division are solved first.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    boolean stop = false;
    static String number=new String("0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.display);
        txt.setText(number);
        txt.setMovementMethod(new ScrollingMovementMethod());

        Button btn=(Button) findViewById(R.id.delete);

        //For delete button
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView t = (TextView) findViewById(R.id.display);
                t.setText("0");
                stop = false;
                return true;
            }
        });

        //For button one
        btn=(Button) findViewById(R.id.one);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("1");
                }else {
                    text.append(1 + "");
                }
            }
        });

        //For button two
        btn=(Button) findViewById(R.id.two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("2");
                }else {
                    text.append(2 + "");
                }
            }
        });

        //For button three
        btn=(Button) findViewById(R.id.three);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("3");
                }else {
                    text.append(3 + "");
                }
            }
        });

        //For button four
        btn=(Button) findViewById(R.id.four);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("4");
                }else {
                    text.append(4 + "");
                }
            }
        });

        //For button five
        btn=(Button) findViewById(R.id.five);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("5");
                }else {
                    text.append(5 + "");
                }
            }
        });

        //For button six
        btn=(Button) findViewById(R.id.six);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("6");
                }else {
                    text.append(6 + "");
                }
            }
        });

        //For button seven
        btn=(Button) findViewById(R.id.seven);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("7");
                }else {
                    text.append(7 + "");
                }
            }
        });

        //For button eight
        btn=(Button) findViewById(R.id.eight);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("8");
                }else {
                    text.append(8 + "");
                }
            }
        });

        //For button nine
        btn=(Button) findViewById(R.id.nine);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("0") || t.equals("Invalid")) {
                    text.setText("9");
                }else {
                    text.append(9 + "");
                }
            }
        });

        //For zero
        btn=(Button) findViewById(R.id.zero);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.equals("Invalid")){
                    text.setText("0");
                }else
                    text.append(0 + "");
            }
        });

        //For Multiply
        btn=(Button) findViewById(R.id.multiply);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    text.append("x");
                    stop = false;
                }
            }
        });

        //For divide
        btn=(Button) findViewById(R.id.divide);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    text.append("/");
                    stop = false;
                }
            }
        });

        //For add
        btn=(Button) findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    text.append("+");
                    stop = false;
                }
            }
        });

        //For subtract
        btn=(Button) findViewById(R.id.subtract);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    text.append("-");
                    stop = false;
                }
            }
        });


        //For Decimal
        btn=(Button) findViewById(R.id.decimal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.charAt(t.length()-1)=='-' || t.charAt(t.length()-1)=='+' || t.charAt(t.length()-1)=='x' || t.charAt(t.length()-1)=='/')
                    text.append("0.");
                else if (t.charAt(t.length()-1) != '.' && !stop){
                    text.append(".");
                    stop = true;
                }
            }
        });

        //For Delete
        btn=(Button) findViewById(R.id.delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.display);
                String t = text.getText().toString();
                if(t.endsWith(".")){
                    stop = false;
                }
                if (t.length() == 1)
                    text.setText("0");
                else
                    text.setText(t.substring(0,t.length()-1));
            }
        });

        //For Equal
        btn=(Button) findViewById(R.id.equal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equal();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView text = (TextView) findViewById(R.id.display);
        number = text.getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView text = (TextView) findViewById(R.id.display);
        text.setText(number);
    }

    public void equal() {
        TextView text = (TextView) findViewById(R.id.display);
        String t = text.getText().toString();
        ArrayList<Double> num = new ArrayList<Double>();
        ArrayList<Character> operator = new ArrayList<Character>();
        int strt = 0, i = 0;
        boolean wait = false;
        try {
            // fill ArrayLists num and operators
            // output: operators contain add and subtract
            //          num contains numbers to add and subtract;
            for (i = 1; i < t.length(); i++) {
                if (t.charAt(i) == '+' || t.charAt(i) == '-' || t.charAt(i) == '/' || t.charAt(i) == 'x') {
                    //This if statement evaluates multiplication and division
                    if (wait) {
                        int numSize = num.size() - 1;
                        int operatorSize = operator.size() - 1;
                        double number = num.remove(numSize);
                        switch (operator.remove(operatorSize)) {
                            case '*':
                                num.add(number * Double.parseDouble(t.substring(strt, i)));
                                break;
                            case '/':
                                num.add(number / Double.parseDouble(t.substring(strt, i)));
                        }
                        wait = false;
                        strt = i + 1;
                    } else {
                        num.add(Double.parseDouble(t.substring(strt, i)));
                        strt = i + 1;
                    }
                    if (t.charAt(i) == 'x') {
                        operator.add('*');
                        wait = true;
                    } else if (t.charAt(i) == '/') {
                        operator.add('/');
                        wait = true;
                    } else {
                        operator.add(t.charAt(i));
                    }
                }
            }
            int numSize = num.size();
            int operatorSize = operator.size();
            //To handle edge case i.e. last multiplication
            if (wait) {
                double number = num.remove(numSize - 1);
                switch (operator.remove(operatorSize - 1)) {
                    case '*':
                        num.add(number * Double.parseDouble(t.substring(strt, i)));
                        break;
                    case '/':
                        num.add(number / Double.parseDouble(t.substring(strt, i)));
                        break;
                }
            } else {
                num.add(Double.parseDouble(t.substring(strt, i)));
                numSize++;
            }

            //Pop elements one by one and add or subtract them
            while (numSize > 1) {
                switch (operator.remove(0)) {
                    case '+':
                        num.add(0, num.remove(0) + num.remove(0));
                        numSize--;
                        break;
                    case '-':
                        num.add(0, num.remove(0) - num.remove(0));
                        numSize--;
                }
            }

            //If number can be displayed in integer format then remove trailing zeros
            //for example: 2.0 is displayed as 2
            double dub = num.get(0);
            int total = (int) (dub);
            if ((double) total == dub) {
                text.setText(total + "");
                stop = false;
            }else {
                text.setText(dub + "");
            }
        } catch (Exception e) {
            text.setText("Invalid");
            stop = false;
        }
    }

}