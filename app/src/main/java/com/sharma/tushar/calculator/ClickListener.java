package com.sharma.tushar.calculator;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickListener implements View.OnClickListener {

    private TextView displayNumber;
    private int buttonRes;

    ClickListener(int buttonRes) {
        this.buttonRes = buttonRes;
    }

    @Override
    public void onClick(View view) {
        displayNumber = (TextView) view.findViewById(R.id.display);
        Button clickedButtonText = (Button) view.findViewById(buttonRes);
        String t = clickedButtonText.getText().toString().trim();
        if(t.equals("0") || t.equals("Invalid")) {
            displayNumber.setText(t);
        }else {
            displayNumber.append(t + "");
        }
    }
}
