package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int question1 = 0;
    int question2 = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox oneLolliPop = (CheckBox) findViewById(R.id.whippedCream);
        CheckBox twoLolliPop = (CheckBox) findViewById(R.id.chocolate);
        //Log.v("MainActivity", cName );

        boolean hasOneLolliPop = oneLolliPop.isChecked();
        boolean hasTwoLolliPop = twoLolliPop.isChecked();

        score = question1 + question2;
        if (hasOneLolliPop && hasTwoLolliPop) {
            score++;
        }

        String message = createOrderSummary(hasOneLolliPop, hasTwoLolliPop, score);
        TextView questionOneTextView = (TextView) findViewById(R.id.answer_radio_question_1);
        TextView questionTwoTextView = (TextView) findViewById(R.id.answer_radio_question_2);
        TextView questionOneCheckTextView = (TextView) findViewById(R.id.answer_check_question_1);

        displayMessageCheckBox(hasOneLolliPop, hasTwoLolliPop, questionOneCheckTextView);
        displayMessageRadioQuestion2(question1, questionOneTextView);
        displayMessageRadioQuestion2(question2, questionTwoTextView);
        displayMessage(message);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((android.widget.RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_one:
                if (checked)
                    question1 = 1;// Pirates are the best
                break;
            case R.id.radio_two:
                if (checked)
                    question1 = 0;// Ninjas rule
            {
                break;
            }
            case R.id.radio_three:
                if (checked)
                    question1 = 0;// Pirates are the best
                break;
            case R.id.radio_four:
                if (checked)
                    question1 = 0;// Ninjas rule
            {
                break;
            }
        }

        switch (view.getId()) {
            case R.id.radio2_one:
                if (checked)
                    question2 = 0;// Pirates are the best
                break;
            case R.id.radio2_two:
                if (checked)
                    question2 = 1;// Ninjas rule
                break;
            case R.id.radio2_three:
                if (checked)
                    question2 = 0;// Pirates are the best
                break;
            case R.id.radio2_four:
                if (checked)
                    question2 = 0;// Ninjas rule
            {
                break;
            }
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private String createOrderSummary(boolean addWhippedCream, boolean addChocolate, int score) {
        String priceMessage = "" + addWhippedCream;
        priceMessage += "\n" + addChocolate;
        priceMessage += "\n" + score;

        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.answer_text_view);
        orderSummaryTextView.setText(message);
    }


    private void displayMessageRadioQuestion2(int isCorrect, TextView answer) {

        if (isCorrect == 1) {
        answer.setText("correct");
        }
        else {
            answer.setText("wrong");
        }
    }

    private void displayMessageCheckBox(Boolean A, Boolean B, TextView answer) {

        if (A && B) {
            answer.setText("correct");
        }
        else {
            answer.setText("wrong");
        }
    }


}
