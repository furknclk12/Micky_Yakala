package com.furkancolak.mickeyyakala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView zaman;
    TextView skor;
    int sayac;
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
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageArray = new ImageView []{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};//Array oluşturduk

        zaman = findViewById(R.id.zaman);
        skor = findViewById(R.id.skor);
        sayac=0;
        skor.setText("Skor : "+sayac);

        new CountDownTimer(10000,1000){
            public void onTick(long l){

                zaman.setText("Zaman :"+l/1000);
            }

            @Override
            public void onFinish() {
                zaman.setText("Süre bitti");
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);//Görünmez yapıyor
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Yeniden başlasın mı");
                alert.setMessage("Emin misin");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();//Güncel aktivite biter
                        startActivity(intent);//aktivite yeniden başlar
                        Toast.makeText(MainActivity.this, "Oyun başlıyor", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yeni oyun başlatılmıyor", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();
        hıdeImages();
    }
    public void image(View view){
        sayac++;
        skor.setText("Skor"+sayac);

    }
    public void image2(View view){
        sayac++;
        skor.setText("Skor"+sayac);
    }
    public void image3(View view){
        sayac++;
        skor.setText("Skor"+sayac);
    }
    public void image4(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void image5(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void image6(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void image7(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void image8(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void image9(View view){
        skor.setText("Skor"+sayac);
        sayac++;
    }
    public void hıdeImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);//Görünmez yapıyor
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);//İ indekste bulunanı görünür yapar
                handler.postDelayed(this,900);
                skor.setText("Skor :"+sayac);
            }
        };
        handler.post(runnable);
    }

}