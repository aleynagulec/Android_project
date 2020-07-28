package com.aleynagulec.egitimdeneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {


    ArrayList<String> kategoriler=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        kategoriler.add("1");
        kategoriler.add("2");
        kategoriler.add("3");
        kategoriler.add("4");
        kategoriler.add("5");
        kategoriler.add("6");
        DatabaseHelper myDbHelper = new DatabaseHelper(Main2Activity.this, "egitim2");
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
        Toast.makeText(Main2Activity.this, "successfully Imported", Toast.LENGTH_SHORT).show();
    }

    public void butonbas(View view){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("kategorino",kategoriler.get(3));
            startActivity(intent);
    }

    public void buton2bas(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("kategorino",kategoriler.get(5));
        startActivity(intent);
    }

    public void buton3bas(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("kategorino",kategoriler.get(4));
        startActivity(intent);

    }

    public void buton4bas(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("kategorino",kategoriler.get(0));
        startActivity(intent);
    }

    public void buton5bas(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("kategorino",kategoriler.get(2));
        startActivity(intent);
    }

    public void buton8bas(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("kategorino",kategoriler.get(1));
        startActivity(intent);
    }
}
