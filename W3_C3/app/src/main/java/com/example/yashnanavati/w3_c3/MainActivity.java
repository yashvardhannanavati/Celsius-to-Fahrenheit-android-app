package com.example.yashnanavati.w3_c3;

import android.renderscript.Double2;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //private TextView txtViewCelsius;
    private TextView txtViewCelDisp;
    //private TextView txtViewFahrenheit;
    private TextView txtViewFahrenDisp;
    private SeekBar seekBarCelsius;
    private SeekBar seekBarFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarCelsius = (SeekBar)findViewById(R.id.seekBarCelsius);
        seekBarFahrenheit = (SeekBar) findViewById(R.id.seekBarFahrenheit);
        txtViewCelDisp = (TextView) findViewById(R.id.txtViewCelDisp);
        txtViewFahrenDisp = (TextView) findViewById(R.id.txtViewFahrenDisp);

        seekBarCelsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float F;
                double DegF;
                DegF = i*9.0/5.0 + 32;
                F = (float)DegF;
                txtViewCelDisp.setText(String.format(Locale.ENGLISH, "%.2f",i*1d));
                txtViewFahrenDisp.setText(String.format(Locale.ENGLISH, "%.2f",F));
                int enteredProgress = (int)DegF;
                seekBarFahrenheit.setProgress(enteredProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarFahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(seekBar.getProgress() < 32){
                    seekBar.setProgress(32);
                    return;
                }
                float C;
                double DegC;
                DegC = (i-32)*5.0/9.0;
                C = (float)DegC;
                txtViewFahrenDisp.setText(String.format(Locale.ENGLISH, "%.2f", i*1d));
                txtViewCelDisp.setText(String.format(Locale.ENGLISH, "%.2f", C));
                int enteredProgress = (int)DegC;
                seekBarCelsius.setProgress(enteredProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() < 32){
                    seekBar.setProgress(32);
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() < 32){
                    seekBar.setProgress(32);
                }
            }
        });
    }
}
