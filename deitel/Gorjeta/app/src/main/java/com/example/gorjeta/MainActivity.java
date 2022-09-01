package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String BILL_TOTAL = "BILL_TOTAL";
    private static final String CUSTOM_PERCENT = "CUSTOM_PERCENT";

    private double currentBillTotal;
    private int currentCustomPorcent;
    private EditText tip10EditText;
    private EditText total10EditText;
    private EditText tip15EditText;
    private EditText total15EditText;
    private EditText billEditText0;
    private EditText tip20EditText;
    private EditText total20EditText;
    private TextView customTipTextView;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            currentBillTotal = 0.00;
            currentCustomPorcent = 18;
        }else{
            currentBillTotal = savedInstanceState.getDouble(BILL_TOTAL);
            currentCustomPorcent = savedInstanceState.getInt(CUSTOM_PERCENT);
        }

        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
        total10EditText = (EditText) findViewById(R.id.total10EditText);
        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
        total15EditText = (EditText) findViewById(R.id.total15EditText);
        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
        total20EditText = (EditText) findViewById(R.id.total20EditText);
        customTipTextView = (TextView) findViewById(R.id.customTipTextView);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditText);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditText);
        billEditText0 = (EditText) findViewById(R.id.billEditText0);
        billEditText0.addTextChangedListener(billEditTextWatcher);
        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
    }

    private void updateStandard(){
        double tenPercentTip = currentBillTotal * .1;
        double tenPercentTotal = currentBillTotal + tenPercentTip;
        tip10EditText.setText(String.format("%.02f", tenPercentTip));
        total10EditText.setText(String.format("%.02f",tenPercentTotal));
        double fifteenPercentTip = currentBillTotal * .15;
        double fifteenPercentTotal = currentBillTotal + fifteenPercentTip;
        tip15EditText.setText(String.format("%.02f", fifteenPercentTip));
        total15EditText.setText(String.format("%.02f",fifteenPercentTotal));
        double twentyPercentTip = currentBillTotal * .2;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;
        tip20EditText.setText(String.format("%.02f", twentyPercentTip));
        total20EditText.setText(String.format("%.02f",twentyPercentTotal));
    }

    private void uptadeCustom(){
        customTipTextView.setText(currentCustomPorcent + "%");
        double customTipAmount = currentBillTotal * currentCustomPorcent * .01;
        double customTotalAmount = currentBillTotal + customTipAmount;
        tipCustomEditText.setText(String.format("%.02f",customTipAmount));
        totalCustomEditText.setText(String.format("%.02f",customTotalAmount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putDouble( BILL_TOTAL, currentBillTotal);
        outState.putInt( CUSTOM_PERCENT, currentCustomPorcent);
    }

    private OnSeekBarChangeListener customSeekBarListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            currentCustomPorcent = seekBar.getProgress();
            uptadeCustom();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private TextWatcher billEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                currentBillTotal = Double.parseDouble(charSequence.toString());
            }catch (NumberFormatException e){
                currentBillTotal = 0.00;
            }
            updateStandard();
            uptadeCustom();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}