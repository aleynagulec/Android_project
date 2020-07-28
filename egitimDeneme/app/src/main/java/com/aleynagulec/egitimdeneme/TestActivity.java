package com.aleynagulec.egitimdeneme;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class TestActivity extends AppCompatActivity {

    List<Sorular> sorulars;
    ImageView soruResim;
    TextView soruTv;
    Button dgrCevap;
    Button ynlsCevap;
    int sayac = 0;
    int dgrsayi = 0;
    int ynlssayi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        soruResim = findViewById(R.id.soruResim);
        soruTv = findViewById(R.id.soruTv);
        dgrCevap = findViewById(R.id.dgrCevap);
        ynlsCevap = findViewById(R.id.ynlsCevap);

        DatabaseHelper myDbHelper = new DatabaseHelper(TestActivity.this, "sorular3");
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
        sorulars = myDbHelper.sorulariCek("sorular");

        getSoru();
        dgrCevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sorulars.size() > sayac) {

                    if (sorulars.get(sayac).cevap == 1) {
                        //dogru bildi
                        dgrsayi += 1;
                        Toast.makeText(getApplicationContext(), "cevap doğru", Toast.LENGTH_LONG).show();
                    } else {
                        ynlssayi += 1;
                        //yanlış bildi
                        Toast.makeText(getApplicationContext(), "cevap yanlış", Toast.LENGTH_LONG).show();
                    }
                    sayac = sayac + 1;
                    getSoru();

                } else {
                    showDialog();
                }



            }
        });
        ynlsCevap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sorulars.size() > sayac) {
                    if (sorulars.get(sayac).cevap == 0) {
                        //dogru bildi
                        dgrsayi += 1;
                        Toast.makeText(getApplicationContext(), "cevap doğru", Toast.LENGTH_LONG).show();
                    } else {
                        ynlssayi += 1;
                        //yanlış bildi
                        Toast.makeText(getApplicationContext(), "cevap yanlış", Toast.LENGTH_LONG).show();
                    }

                    sayac = sayac + 1;
                    getSoru();

                } else {
                    showDialog();
                }


            }
        });


    }

    public void getSoru() {
        if (sorulars.size() > sayac) {
            soruTv.setText(sorulars.get(sayac).soru);
            int imageId = getResources().getIdentifier(sorulars.get(sayac).getResim(), "drawable", getPackageName());
            Drawable drawable = ContextCompat.getDrawable(this, imageId);
            soruResim.setImageDrawable(drawable);

        }
        else {
            showDialog();
        }
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setTitle("Sonuçlar");
        builder.setMessage("Dogru sayısı: " + dgrsayi + " yanlış sayısı: " + ynlssayi);
        builder.setCancelable(false);
        builder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onBackPressed();

            }
        });


        builder.show();
    }
}
