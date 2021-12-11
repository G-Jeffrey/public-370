package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        EditText partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        Button buttonCompute = (Button) findViewById(R.id.buttonCompute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = 0, partySize = 0;
                try{
                    total = Integer.parseInt(checkAmountValue.getText().toString());
                    partySize = Integer.parseInt(partySizeValue.getText().toString());
                    if(total<=0 || partySize <=0) throw new Exception("Party size and total cost cannot be less than or equal to 0");
                    if(partySize>total) throw new Exception("Party size is greater than total cost");
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Please enter a valid value for party size and cost of meal", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    String[] s = e.toString().split(":");
                    Toast.makeText(MainActivity.this, s[1], Toast.LENGTH_SHORT).show();
                }

                EditText fifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
                EditText twentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
                EditText twentyfivePercentTipValue = (EditText) findViewById(R.id.twentyfivePercentTipValue);
                fifteenPercentTipValue.setText(String.valueOf((int)Math.round((total*0.15)/partySize)));
                twentyPercentTipValue.setText(String.valueOf((int)Math.round((total*0.20)/partySize)));
                twentyfivePercentTipValue.setText(String.valueOf((int)Math.round((total*0.25)/partySize)));
                EditText fifteenPercentTotalValue = (EditText) findViewById(R.id.fifteenPercentTotalValue);
                EditText twentyPercentTotalValue = (EditText) findViewById(R.id.twentyPercentTotalValue);
                EditText twentyfivePercentTotalValue = (EditText) findViewById(R.id.twentyfivePercentTotalValue);
                fifteenPercentTotalValue.setText(String.valueOf((int)Math.round(total + (total*0.15)/partySize)));
                twentyPercentTotalValue.setText(String.valueOf((int)Math.round(total + (total*0.2)/partySize)));
                twentyfivePercentTotalValue.setText(String.valueOf((int)Math.round(total + (total*0.25)/partySize)));
            }
        });
    }
}