package com.sharma.tushar.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickListener implements View.OnClickListener {

    private TextView displayNumber;
    private int buttonRes;
    private View rootView;
    ClickListener(int buttonRes, View rootView) {
        this.buttonRes = buttonRes;
        this.rootView = rootView;
    }

    @Override
    public void onClick(View view) {
        displayNumber = rootView.findViewById(R.id.display);
        Button clickedButtonText = view.findViewById(buttonRes);
        String displayText = displayNumber.getText().toString();
        String buttonText = clickedButtonText.getText().toString().trim();
        if(displayText.equals("0") ||
                displayText.equals("Invalid")) {
            displayNumber.setText(buttonText);
        }else {
            displayNumber.append(buttonText + "");
        }
    }
}
