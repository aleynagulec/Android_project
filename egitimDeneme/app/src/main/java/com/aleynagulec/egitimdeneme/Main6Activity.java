package com.aleynagulec.egitimdeneme;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main6Activity extends AppCompatActivity {

    private SoundPool sp;
    private int ses1;
    private int ses2;
    private int ses3;
    private int ses4;
    private int ses5;
    private int ses6;
    private int ses7;
    private int ses8;
    private int ses9;
    private int ses00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        ses1 = sp.load(getApplicationContext(),R.raw.ses1,1);
        ses2 = sp.load(getApplicationContext(),R.raw.ses2,1);
        ses3 = sp.load(getApplicationContext(),R.raw.ses3,1);
        ses4 = sp.load(getApplicationContext(),R.raw.ses4,1);
        ses5 = sp.load(getApplicationContext(),R.raw.ses5,1);
        ses6 = sp.load(getApplicationContext(),R.raw.ses6,1);
        ses7 = sp.load(getApplicationContext(),R.raw.ses7,1);
        ses8 = sp.load(getApplicationContext(),R.raw.ses8,1);
        ses9 = sp.load(getApplicationContext(),R.raw.ses9,1);
        ses00 = sp.load(getApplicationContext(),R.raw.ses00,1);
    }

    public void ses1(View view){
        sp.play(ses1,1.0f,1.0f,0,0,10f);
    }
    public void ses2(View view){
        sp.play(ses2,1.0f,1.0f,0,0,10f);
    }
    public void ses3(View view){
        sp.play(ses3,1.0f,1.0f,0,0,10f);
    }
    public void ses4(View view){
        sp.play(ses4,1.0f,1.0f,0,0,10f);
    }
    public void ses5(View view){
        sp.play(ses5,1.0f,1.0f,0,0,10f);
    }
    public void ses6(View view){
        sp.play(ses6,1.0f,1.0f,0,0,10f);
    }
    public void ses7(View view){
        sp.play(ses7,1.0f,1.0f,0,0,10f);
    }
    public void ses8(View view){
        sp.play(ses8,1.0f,1.0f,0,0,10f);
    }
    public void ses9(View view){
        sp.play(ses9,1.0f,1.0f,0,0,10f);
    }
    public void ses00(View view) {
        sp.play(ses00, 1.0f, 1.0f, 0, 0, 10f);
    }
}
