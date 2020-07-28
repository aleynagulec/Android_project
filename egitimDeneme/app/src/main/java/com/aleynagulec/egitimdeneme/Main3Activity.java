package com.aleynagulec.egitimdeneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DatabaseHelper myDbHelper = new DatabaseHelper(Main3Activity.this, "egitim2");
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (android.database.SQLException sqle) {
            throw sqle;
        }
        final List<eylemler> eylems = myDbHelper.verileriCek("eylemler","1");
        int a=1;

    }

    public void btn1bas(View view){
        Intent intent= new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
    }
    public void btn2bas(View view){

        Intent intent= new Intent(getApplicationContext(),TestActivity.class);
        startActivity(intent);
    }
    public void btn3bas(View view){
        Intent intent= new Intent(getApplicationContext(),Main5Activity.class);
        startActivity(intent);
    }

    public void butoncizim(View view){
        Intent intent= new Intent(getApplicationContext(),Main7Activity.class);
        startActivity(intent);
    }
}
