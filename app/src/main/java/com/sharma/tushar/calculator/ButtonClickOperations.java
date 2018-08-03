package com.sharma.tushar.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ButtonClickOperations {

    //necessary for calculation
    //do not touch
    private static boolean stop = false;
    private static TextView displayNumber;

    private ButtonClickOperations() {}


    public static void setNormalOperations(View currView) {

        final View view = currView;
        displayNumber = view.findViewById(R.id.display);

        Button btn;

        //For button one
        btn= view.findViewById(R.id.one);
        btn.setOnClickListener(new ClickListener(R.id.one, view));

        //For button two
        btn= view.findViewById(R.id.two);
        btn.setOnClickListener(new ClickListener(R.id.two, view));

        //For button three
        btn= view.findViewById(R.id.three);
        btn.setOnClickListener(new ClickListener(R.id.three, view));

        //For button four
        btn= view.findViewById(R.id.four);
        btn.setOnClickListener(new ClickListener(R.id.four, view));

        //For button five
        btn= view.findViewById(R.id.five);
        btn.setOnClickListener(new ClickListener(R.id.five, view));

        //For button six
        btn= view.findViewById(R.id.six);
        btn.setOnClickListener(new ClickListener(R.id.six, view));

        //For button seven
        btn= view.findViewById(R.id.seven);
        btn.setOnClickListener(new ClickListener(R.id.seven, view));

        //For button eight
        btn= view.findViewById(R.id.eight);
        btn.setOnClickListener(new ClickListener(R.id.eight, view));

        //For button nine
        btn= view.findViewById(R.id.nine);
        btn.setOnClickListener(new ClickListener(R.id.nine, view));

        //For zero
        btn= view.findViewById(R.id.zero);
        btn.setOnClickListener(new ClickListener(R.id.zero, view));

        //For Multiply
        btn= view.findViewById(R.id.multiply);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    displayNumber.append("x");
                    stop = false;
                }
            }
        });

        //For divide
        btn= view.findViewById(R.id.divide);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    displayNumber.append("/");
                    stop = false;
                }
            }
        });

        //For add
        btn= view.findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    displayNumber.append("+");
                    stop = false;
                }
            }
        });

        //For subtract
        btn= view.findViewById(R.id.subtract);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.charAt(t.length()-1)!='-' && t.charAt(t.length()-1)!='+' && t.charAt(t.length()-1)!='x' && t.charAt(t.length()-1)!='/') {
                    displayNumber.append("-");
                    stop = false;
                }
            }
        });


        //For Decimal
        btn= view.findViewById(R.id.decimal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.charAt(t.length()-1)=='-' || t.charAt(t.length()-1)=='+' || t.charAt(t.length()-1)=='x' || t.charAt(t.length()-1)=='/')
                    displayNumber.append("0.");
                else if (t.charAt(t.length()-1) != '.' && !stop){
                    displayNumber.append(".");
                    stop = true;
                }
            }
        });

        //For Delete
        btn= view.findViewById(R.id.delete);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = view.findViewById(R.id.display);
                String t = displayNumber.getText().toString();
                if(t.endsWith(".")){
                    stop = false;
                }
                if (t.length() == 1)
                    displayNumber.setText("0");
                else
                    displayNumber.setText(t.substring(0,t.length()-1));
            }
        });

        //For delete long press button
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v){
                displayNumber = view.findViewById(R.id.display);
                displayNumber.setText("0");
                stop = false;
                return true;
            }
        });

        //For Equal
        btn= view.findViewById(R.id.equal);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                equal(view);
            }
        });
    }

    private static final void equal(View view) {
        String t = displayNumber.getText().toString();
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
                displayNumber.setText(total + "");
                stop = false;
            }else {
                displayNumber.setText(dub + "");
            }
        } catch (Exception e) {
            displayNumber.setText("Invalid");
            stop = false;
        }
    }

}
