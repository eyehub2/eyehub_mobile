package com.android.example.eyehub_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WordComparison extends AppCompatActivity {
    TextView uzumText;
    TextView ozgunText;
    TextView celikText;
    TextView halText;
    TextView elmaText;
    TextView balText;
    TextView yurtText;
    TextView kuruText;
    Button uzumButton;
    Button uzunButton;
    Button ozgurButton;
    Button ozgunButton;
    Button celikButton;
    Button cekikButton;
    Button hakButton;
    Button halButton;
    Button elmaButton;
    Button imlaButton;
    Button balButton;
    Button bolButton;
    Button yurtButton;
    Button kurtButton;
    Button kuzuButton;
    Button kuruButton;


    TextView textView;
    Button baslaButton;


    double x,y;
    double yuzde;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_comparison);
        uzumText=findViewById(R.id.uzumText);
        ozgunText=findViewById(R.id.OzgunText);
        celikText=findViewById(R.id.celikText);
        halText=findViewById(R.id.halText);
        elmaText=findViewById(R.id.elmaText);
        balText=findViewById(R.id.balText);
        yurtText=findViewById(R.id.yurtText);
        kuruText=findViewById(R.id.kuruText);
        uzumButton=findViewById(R.id.uzumButton);
        uzunButton=findViewById(R.id.uzunButton);
        ozgurButton=findViewById(R.id.ozgurButton);
        ozgunButton=findViewById(R.id.ozgunButton);
        celikButton=findViewById(R.id.celikButton);
        cekikButton=findViewById(R.id.cekikButton);
        hakButton=findViewById(R.id.hakButton);
        halButton=findViewById(R.id.halButton);
        elmaButton=findViewById(R.id.elmaButton);
        imlaButton=findViewById(R.id.imlaButton);
        balButton=findViewById(R.id.balButton);
        bolButton=findViewById(R.id.bolButton);
        yurtButton=findViewById(R.id.yurtButton);
        kurtButton=findViewById(R.id.kurtButton);
        kuzuButton=findViewById(R.id.kuzuButton);
        kuruButton=findViewById(R.id.kuruButton);


        textView=findViewById(R.id.textView);
        baslaButton=findViewById(R.id.baslaButton);


        x=0;
        y=0;
        yuzde=0;



        baslaButton.setOnClickListener(view -> {
            baslaButton.setVisibility(View.INVISIBLE);
            uzumFun();
        });
        uzumButton.setOnClickListener(view -> {

            uzumButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            ozgunFun();
        });
        ozgunButton.setOnClickListener(view -> {
            ozgunButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            celikFun();
        });
        celikButton.setOnClickListener(view -> {
            celikButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            halFun();
        });
        halButton.setOnClickListener(view -> {
            halButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            elmaFun();
        });
        elmaButton.setOnClickListener(view -> {
            elmaButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            balFun();
        });
        balButton.setOnClickListener(view -> {
            balButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            yurtFun();
        });
        yurtButton.setOnClickListener(view -> {
            yurtButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            kuruFun();
        });
        kuruButton.setOnClickListener(view -> {
            kuruButton.setBackgroundColor(Color.GREEN);
            x++;
            setYuzde();
            kuruButton.setVisibility(View.INVISIBLE);
            kuzuButton.setVisibility(View.INVISIBLE);
        });
        kuzuButton.setOnClickListener(view -> {
            kuzuButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            kuruButton.setVisibility(View.INVISIBLE);
            kuzuButton.setVisibility(View.INVISIBLE);
        });
        kurtButton.setOnClickListener(view -> {
            kurtButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            kuruFun();
        });
        bolButton.setOnClickListener(view -> {
            bolButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            yurtFun();
        });
        imlaButton.setOnClickListener(view -> {
            imlaButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            balFun();
        });
        hakButton.setOnClickListener(view -> {
            hakButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            elmaFun();
        });
        cekikButton.setOnClickListener(view -> {
            cekikButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            halFun();
        });
        uzunButton.setOnClickListener(view -> {
            uzunButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            ozgunFun();
        });
        ozgurButton.setOnClickListener(view -> {
            ozgurButton.setBackgroundColor(Color.RED);
            y++;
            setYuzde();
            celikFun();
        });
    }

    public void uzumFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                uzumText.setVisibility(View.VISIBLE);
                uzumButton.setVisibility(View.INVISIBLE);
                uzunButton.setVisibility(View.INVISIBLE);
            }
            public void onFinish() {
                uzumButton.setVisibility(View.VISIBLE);
                uzunButton.setVisibility(View.VISIBLE);
                uzumText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void ozgunFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                uzumButton.setVisibility(View.INVISIBLE);
                uzunButton.setVisibility(View.INVISIBLE);
                ozgunText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                ozgunButton.setVisibility(View.VISIBLE);
                ozgurButton.setVisibility(View.VISIBLE);
                ozgunText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void celikFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                ozgunButton.setVisibility(View.INVISIBLE);
                ozgurButton.setVisibility(View.INVISIBLE);
                celikText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                celikButton.setVisibility(View.VISIBLE);
                cekikButton.setVisibility(View.VISIBLE);
                celikText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void halFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                celikButton.setVisibility(View.INVISIBLE);
                cekikButton.setVisibility(View.INVISIBLE);
                halText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                halButton.setVisibility(View.VISIBLE);
                hakButton.setVisibility(View.VISIBLE);
                halText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void elmaFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                halButton.setVisibility(View.INVISIBLE);
                hakButton.setVisibility(View.INVISIBLE);
                elmaText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                elmaButton.setVisibility(View.VISIBLE);
                imlaButton.setVisibility(View.VISIBLE);
                elmaText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void balFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                elmaButton.setVisibility(View.INVISIBLE);
                imlaButton.setVisibility(View.INVISIBLE);
                balText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                balButton.setVisibility(View.VISIBLE);
                bolButton.setVisibility(View.VISIBLE);
                balText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void yurtFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                balButton.setVisibility(View.INVISIBLE);
                bolButton.setVisibility(View.INVISIBLE);
                yurtText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                yurtButton.setVisibility(View.VISIBLE);
                kurtButton.setVisibility(View.VISIBLE);
                yurtText.setVisibility(View.INVISIBLE);
            }
        }.start();

    }
    public void kuruFun(){
        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                yurtButton.setVisibility(View.INVISIBLE);
                kurtButton.setVisibility(View.INVISIBLE);
                kuruText.setVisibility(View.VISIBLE);
            }
            public void onFinish() {
                kuruButton.setVisibility(View.VISIBLE);
                kuzuButton.setVisibility(View.VISIBLE);
                kuruText.setVisibility(View.INVISIBLE);
            }
        }.start();
    }


    @SuppressLint("SetTextI18n")
    public void setYuzde(){
        yuzde=(x/(x+y))*100;
        textView.setText("Doğruluk Yüzdesi:%"+Math.round(yuzde));
    }
}