package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_FEE = -1;
    private TextView fees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Float fee = intent.getFloatExtra(getString(R.string.extra_fee), DEFAULT_FEE);//將原本預設值-1令一個常數來用，更方便觀看
        Log.d(TAG, fee +"");//為了避免log裡字打錯及快速，所以令一個常數來用
        fees = findViewById(R.id.fee);
        int c = (int)(fee+0.5f);//四捨五入且去掉小數位，將浮點數強制轉型為整數
        int a = (int)(fee*10);//若要取到小數第一位，先*10再/10
        float b = (float)a/10;
        fees.setText(b+"");

    }
}
