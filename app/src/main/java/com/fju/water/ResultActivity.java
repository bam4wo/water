package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Float fee = intent.getFloatExtra("FEE", -1);
        Log.d("ResultActivity", fee +"");
        fees = findViewById(R.id.fee);
        int c = (int)(fee+0.5f);//四捨五入且去掉小數位，將浮點數強制轉型為整數
        int a = (int)(fee*10);//若要取到小數第一位，先*10再/10
        float b = (float)a/10;
        fees.setText(b+"");

    }
}
