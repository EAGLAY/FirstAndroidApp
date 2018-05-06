package com.example.skiddportal.exercise01;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    TextView tv,tv2;
    Button btn1;
    Button btn2;
    SeekBar skbr, skbr2, skbr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv2 = (TextView) findViewById(R.id.colprev);
        tv = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.btn_ok);
        btn2 = (Button) findViewById(R.id.btn_cancel);
        /*skbr =(SeekBar) findViewById(R.id.seekBar);
        skbr2 =(SeekBar) findViewById(R.id.seekBar2);
        skbr3 =(SeekBar) findViewById(R.id.seekBar3);
        */
        tv.setBackgroundColor(Color.rgb(255, 255, 255));
        tv.setText("The selected color value is (R,G,B)");
        press();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(getApplicationContext(),"Close by pressing one of the buttons!",Toast.LENGTH_SHORT).show();
    }

    public void press(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(myIntent);
                finish();
                Toast.makeText(getApplicationContext(),"About activity was closed using OK.", Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(myIntent);
                finish();
                Toast.makeText(getApplicationContext(),"About activity was closed using CANCEL.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
