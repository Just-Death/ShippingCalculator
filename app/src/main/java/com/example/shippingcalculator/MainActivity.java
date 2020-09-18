package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView baseCostNum, addedCostNum, totalCostNum;
    private EditText weightInput;
    private double baseCost;
    private double addedCost;
    private double totalCost;
    private int weightInputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseCostNum = findViewById(R.id.baseCostNum);
        addedCostNum = findViewById(R.id.addedCostNum);
        totalCostNum = findViewById(R.id.totalCostNum);
        weightInput = findViewById(R.id.weightInput);

        weightInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (weightInput.getText() == null) {
                    weightInput.setText(String.valueOf(0));
                }
                weightInputNum = Integer.parseInt(weightInput.getText().toString());
                if (weightInputNum >=17){
                    if (weightInputNum > 30) {
                        baseCost = 4.0;
                        baseCostNum.setText(String.valueOf(baseCost));
                    }
                    addedCost = Math.round(((weightInputNum - 16.0) / 4) * 0.5);
                    addedCostNum.setText(String.valueOf(addedCost));
                    totalCostNum.setText(String.valueOf(addedCost+baseCost));
                } else if (weightInputNum <= 16){
                    baseCost = 3.0;
                    baseCostNum.setText(String.valueOf(baseCost));
                    addedCostNum.setText(String.valueOf(0.0));
                    totalCostNum.setText(String.valueOf(baseCost));
                }

                return true;
            }
        });
    }
}
