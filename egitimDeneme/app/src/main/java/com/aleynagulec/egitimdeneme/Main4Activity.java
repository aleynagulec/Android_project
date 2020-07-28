package com.aleynagulec.egitimdeneme;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main4Activity extends AppCompatActivity {

    TextView skorText;
    TextView zamanText;
    int score;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //initialize

        zamanText = findViewById(R.id.zamanText);
        skorText = findViewById(R.id.skorText);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hideImages();


        score = 0;

        new CountDownTimer(10000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                zamanText.setText("Zaman: " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                zamanText.setText("Süre Bitti!!");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }


                AlertDialog.Builder alert = new AlertDialog.Builder(Main4Activity.this);

                alert.setTitle("Balıklar kaçıyor!!");
                alert.setMessage("Onları tekrar yakalamaya hazır mısın?");
                alert.setPositiveButton("Evet!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //restart

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("Hayır:(", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main4Activity.this, "Balıklar kaçtı..", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(getApplicationContext(),Main3Activity.class);
                        startActivity(intent);


                    }
                });

                alert.show();

            }
        }.start();

    }

    public void SkorArttir (View view) {

        score++;
        //score = score + 1;

        skorText.setText("Skor: " + score);


    }

    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);

            }
        };


        handler.post(runnable);


    }


}
