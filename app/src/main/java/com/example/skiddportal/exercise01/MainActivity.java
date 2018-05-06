
package com.example.skiddportal.exercise01;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SensorEventListener{


    private static SeekBar skbr;
    private static EditText edtxt;
    private static SeekBar skbr2;
    private static EditText edtxt2;
    private static SeekBar skbr3;
    private static EditText edtxt3;

    private static final String TAG = "MainActivity";
    private SensorManager sMgr;
    private Sensor accelerometer;


    RelativeLayout bgc;
    TextView cp;
    CheckBox cb;
    Button knopf;
    RadioButton rbtn1;
    RadioButton rbtn2;
    RadioButton rbtn3;
    RadioButton rbtn4;
    MenuItem abt;


    RadioGroup radio_Group;
    RadioButton radio_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //
        doSomethingRed();
        doSomethingGreen();
        doSomethingBlue();
        //compare();
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information: Wipe to the right to dismiss ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d(TAG, "onCreate: Activating Sensor");
        sMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sMgr.registerListener(MainActivity.this, accelerometer, sMgr.SENSOR_DELAY_NORMAL);



        radio_Group = (RadioGroup) findViewById(R.id.radio_gruppe);
        knopf =(Button) findViewById(R.id.button);
        cb = (CheckBox) findViewById(R.id.checkBox);
        cp = (TextView) findViewById(R.id.colprev);
        rbtn1 = (RadioButton) findViewById(R.id.rb1);
        rbtn2 = (RadioButton) findViewById(R.id.rb2);
        rbtn3 = (RadioButton) findViewById(R.id.rb3);
        rbtn4 = (RadioButton) findViewById(R.id.rb4);
        //abt = (MenuItem) findViewById(R.id.about);

        /*abt.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent_adu = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent_adu);
                return true;
            }
        });*/
    }
    //

    //
    public void doSomethingRed() {
        skbr = (SeekBar) findViewById(R.id.seekBar);
        edtxt = (EditText) findViewById(R.id.editText);
        edtxt.setText(""+skbr.getProgress());
        bgc = (RelativeLayout) findViewById(R.id.color);

        skbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                edtxt.setText(""+progress);

                //bgc.setBackgroundColor(0xff000000+skbr.getProgress()*0x10000);
                //cp_red.setBackgroundColor(0xff000000+skbr.getProgress()*0x10000);
                //bgc.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                cp.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                cp.setTextColor(Color.rgb(skbr.getProgress()-255, skbr2.getProgress()-255, skbr3.getProgress()-255));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        edtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = edtxt.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt.setText(""+num);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String val = edtxt.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt.setText(""+num);
                }
            }
        });
    }

   public void doSomethingGreen() {

        skbr2 = (SeekBar) findViewById(R.id.seekBar2);
        edtxt2 = (EditText) findViewById(R.id.editText2);
        edtxt2.setText(""+skbr2.getProgress());
        bgc = (RelativeLayout) findViewById(R.id.color);

        skbr2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                edtxt2.setText(""+progress);
                /*bgc.setBackgroundColor(0xff000000+skbr2.getProgress()*0x100);
                cp_green.setBackgroundColor(0xff000000+skbr2.getProgress()*0x100);*/
                //bgc.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                //cp_red.setBackgroundColor(0xff000000+skbr.getProgress()*0x1);
                cp.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                cp.setTextColor(Color.rgb(skbr.getProgress()-255, skbr2.getProgress()-255, skbr.getProgress()-255));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        edtxt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = edtxt2.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr2.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt2.setText(""+num);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                String val = edtxt2.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr2.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt2.setText(""+num);
                }
            }
        });
    }

    public void doSomethingBlue() {

        skbr3 = (SeekBar) findViewById(R.id.seekBar3);
        edtxt3 = (EditText) findViewById(R.id.editText3);
        //edtxt3.setText(""+skbr3.getProgress());
        bgc = (RelativeLayout) findViewById(R.id.color);

        edtxt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val = edtxt3.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr3.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt3.setText(""+num);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                String val = edtxt.getText().toString();
                int convertVal = Integer.parseInt(val);
                skbr.setProgress(convertVal);
                int num = 0;
                if(convertVal > 255){
                    edtxt3.setText(""+num);
                }
            }
        });

        skbr3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                edtxt3.setText(""+progress);
                //int idgetter = radio_Group.getCheckedRadioButtonId();
                //radio_Button = findViewById(idgetter);
                //radio_Button.setTextColor(0xff000000+skbr.getProgress()*0x10000);
                //bgc.setBackgroundColor(0xff000000+skbr.getProgress()*0x1);
                //bgc.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                //cp_red.setBackgroundColor(0xff000000+skbr.getProgress()*0x1);

                cp.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                cp.setTextColor(Color.rgb(skbr.getProgress()-255, skbr2.getProgress()-255, skbr3.getProgress()-255));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
public void check(View v){
        knopf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FloatingActionButton myfab=(FloatingActionButton) findViewById(R.id.fab);
                int idgetter = radio_Group.getCheckedRadioButtonId();
                radio_Button = findViewById(idgetter);

                switch (radio_Button.getId()){
                    case R.id.rb1:
                        bgc.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        break;
                    case R.id.rb2:
                        rbtn1.setTextColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        rbtn2.setTextColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        rbtn3.setTextColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        rbtn4.setTextColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        cb.setTextColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        break;
                    case R.id.rb3:
                        knopf.setBackgroundColor(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress()));
                        break;
                    case R.id.rb4:
                        myfab.setBackgroundTintList(ColorStateList.valueOf(Color.rgb(skbr.getProgress(),skbr2.getProgress(),skbr3.getProgress())));
                }
            }
        });
    }
    /*public void compare (){
        int sk1, sk2, sk3;
        sk1 = skbr.getProgress();
        sk2 = skbr2.getProgress();
        sk3 = skbr.getProgress();
        if(sk1 == sk2){
            cp.setTextColor(0xFF192FB9);
        }
    }*/
    /*private void knopf_pressed(){
        knopf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idgetter = radio_Group.getCheckedRadioButtonId();
                radio_Button = findViewById(idgetter);
                radio_Button.setTextColor(0xff000000+skbr.getProgress()*0x10000);
                bgc.setBackgroundColor(0xff000000+skbr.getProgress()*0x10000);
                cp_red.setBackgroundColor(0xff000000+skbr.getProgress()*0x10000);
            }
        });
    }*/
    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        int prog = 0;
        skbr.setProgress(prog++);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if(id == R.id.about){
            Intent intent_adu = new Intent(this, AboutActivity.class);
            startActivity(intent_adu);
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
