package com.aleynagulec.egitimdeneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void balikbas(View view){
        Intent intent=new Intent(getApplicationContext(),Main4Activity.class);
        startActivity(intent);
    }
    public void buton6bas(View view){
        Intent intent=new Intent(getApplicationContext(),Main6Activity.class);
        startActivity(intent);
    }
}
