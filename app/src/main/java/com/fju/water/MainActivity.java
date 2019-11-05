package com.fju.water;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edmonth;
    private EditText ednext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void enter(View view){
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
        }else if (monthh <= 0){
            if(nextt>=1 && nextt <= 10){
                total2 = nextt*7.35f;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok",null)
                        .show();
            }else if(nextt>=11 && nextt <= 30){
                total2 = nextt*9.45f-42;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok",null)
                        .show();
            }else if(nextt>=31 && nextt <= 50) {
                total2 = nextt * 11.55f - 168;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok", null)
                        .show();
            }else if(nextt>=51 ) {
                total2 = nextt * 12.075f - 220.5f;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用" )
                        .setMessage("費用："+total2)
                        .setPositiveButton("ok", null)
                        .show();
            }
        }

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
