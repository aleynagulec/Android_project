package com.aleynagulec.egitimdeneme;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView resim_yolu;
    TextView resimText;
    Button btnSol,btnSag;
    int sayac=0;

    String getKategoriNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resim_yolu = findViewById(R.id.resim_yolu);
        btnSol = findViewById(R.id.solButon);
        btnSag = findViewById(R.id.sagbuton);
        resimText = findViewById(R.id.textView);
        getKategoriNo=getIntent().getStringExtra("kategorino");
        DatabaseHelper myDbHelper = new DatabaseHelper(MainActivity.this, "egitim2");
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
        Toast.makeText(MainActivity.this, "successfully Imported", Toast.LENGTH_SHORT).show();


        final List<eylemler> eylems = myDbHelper.verileriCek("eylemler",getKategoriNo);

        for (int i = 0; i < eylems.size(); i++) {
            Log.i("hata", "eylem_no ----> " + eylems.get(i).getEylem_no());
            Log.i("hata", "k_no    -----> " + eylems.get(i).getK_no());
            Log.i("hata", "eylem_adi ---> " + eylems.get(i).getEylem_adi());
            Log.i("hata", "eylem_resim--> " + eylems.get(i).getEylem_resim());
            int imageId = getResources().getIdentifier(eylems.get(i).getEylem_resim(), "drawable", getPackageName());
            Log.i("hata", "onCreate: id " + imageId);
            // Drawable drawable = ContextCompat.getDrawable(this, imageId);
            //resim_yolu.setImageDrawable(drawable);
        }
        int imageId = getResources().getIdentifier(eylems.get(0).getEylem_resim(), "drawable", getPackageName());
        Drawable drawable = ContextCompat.getDrawable(this, imageId);
        resim_yolu.setImageDrawable(drawable);
        resimText.setText(eylems.get(0).getEylem_adi());

        btnSag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sayac == 0) {
                    sayac++;
                } else {
                    int imageId = getResources().getIdentifier(eylems.get(sayac).getEylem_resim(), "drawable", getPackageName());
                    Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), imageId);
                    resim_yolu.setImageDrawable(drawable);
                    resimText.setText(eylems.get(sayac).getEylem_adi());

                    sayac--;
                }
            }
        });
        btnSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac++;
                if (sayac >= eylems.size()) {
                    sayac--;
                } else {
                    int imageId = getResources().getIdentifier(eylems.get(sayac).getEylem_resim(), "drawable", getPackageName());
                    Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), imageId);
                    resim_yolu.setImageDrawable(drawable);
                    resimText.setText(eylems.get(sayac).getEylem_adi());

                }
            }
        });
    }
    public void anasayfadon(View view){
        Intent intent= new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }

}

