package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edmonth;
    private EditText ednext;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //可直接將enter(View view)中的程式碼直接貼上來，但Intent intent = new Intent(this, ResultActivity.class);會出錯
                // 因為這裡的this變成指其他東西，所以要改成MainActivity.this
               enter();
            }

        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*public void enter(View view){
        int monthh = Integer.parseInt(edmonth.getText().toString());
        int nextt = Integer.parseInt(ednext.getText().toString());
        float total;
        float total2;
        if(monthh>=1 && monthh <= 10){
            total = monthh*7.35f;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用："+total)
                    .setPositiveButton("ok",null)
                    .show();
        }else if(monthh>=11 && monthh <= 30){
            total = monthh*9.45f-21;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用："+total)
                    .setPositiveButton("ok",null)
                    .show();
        }else if(monthh>=31 && monthh <= 50) {
            total = monthh * 11.55f - 84;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用："+total)
                    .setPositiveButton("ok", null)
                    .show();
        }else if(monthh>=51 ) {
            total = monthh * 12.075f - 110.25f;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用："+total)
                    .setPositiveButton("ok", null)
                    .show();
        }
            if(nextt>=1 && nextt <= 20){
                total2 = nextt*7.35f;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok",null)
                        .show();
            }else if(nextt>=20 && nextt <= 60){
                total2 = nextt*9.45f-42;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok",null)
                        .show();
            }else if(nextt>=61 && nextt <= 100) {
                total2 = nextt * 11.55f - 168;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok", null)
                        .show();
            }else if(nextt>=101 ) {
                total2 = nextt * 12.075f - 220.5f;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用" )
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok", null)
                        .show();
            }

    }*/
    public void enter(){
        String month = edmonth.getText().toString();
        float fee = 0;
        if(!TextUtils.isEmpty(month)){
            float monthD = Float.parseFloat(month);
            if(monthD>=0 && monthD<=10){
                fee = monthD*7.35f;
            }else if(monthD>=11 && monthD<=30){
                fee = monthD*9.45f-21;
            }else if(monthD>=31 && monthD<=50){
                fee = monthD*11.55f-84;
            }else if(monthD>=51){
                fee = monthD*12.075f-110.25f;
            }
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.extra_fee), fee);
            startActivity(intent);
            /*new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用："+fee)
                    .setPositiveButton("ok", null)
                    .show();*/
        }
        /*
        else {
            String next = ednext.getText().toString();
            if (!TextUtils.isEmpty(next)){
                float nextD = Float.parseFloat(next);
                if(nextD>=0 && nextD<=20){
                    fee = nextD*7.35f;
                }else if (nextD>=21 && nextD<=60){
                    fee = nextD*9.45f-42;
                }else if(nextD>=61 && nextD<=100){
                    fee = nextD*11.55f-168;
                }else if(nextD>=101){
                    fee = nextD*12.075f-220.5f;
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+fee)
                        .setPositiveButton("ok", null)
                        .show();
            }
        }

         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
