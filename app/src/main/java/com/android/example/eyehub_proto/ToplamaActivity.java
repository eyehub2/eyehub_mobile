package com.android.example.eyehub_proto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ToplamaActivity extends AppCompatActivity {
    TextView firstNumber;
    TextView secondNumber;
    TextView textView8;
    Button startButton;
    Button guessButton;
    EditText resultText;
    Button cikarmaButton;
    EditText isimText;
    int result=0;

    Random random = new Random();
    TextView kalanText;
    EditText resultCounter;
    int n1,n2;
    double x=0,resultCount;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toplama_layout);
        firstNumber=findViewById(R.id.firstNumber);
        secondNumber=findViewById(R.id.secondNumber);
        textView8=findViewById(R.id.textView8);
        resultText=findViewById(R.id.resultText);
        startButton=findViewById(R.id.startButton);
        guessButton=findViewById(R.id.guessButton);
        cikarmaButton=findViewById(R.id.Cikarma);
        isimText=findViewById(R.id.isimText);
        kalanText=findViewById(R.id.kalanText);
        resultCounter=findViewById(R.id.resultCount2);

        startButton.setOnClickListener(view -> {
            n1=random.nextInt(10)+1;
            String nBirString=String.valueOf(n1);
            firstNumber.setText(nBirString);
            n2=random.nextInt(10)+1;
            String nIkiString=String.valueOf(n2);
            secondNumber.setText(nIkiString);
        });

        guessButton.setOnClickListener(view -> {
            result=Integer.parseInt(resultText.getText().toString());
            String textKalan="Kalan Deneme Sayısı:"+(10-resultCount);
            kalanText.setText(textKalan);
            if (resultText.getText().toString().matches("")){
                Toast.makeText(ToplamaActivity.this,"Lütfen bir sayı giriniz",Toast.LENGTH_LONG).show();
            }
            else {
                resultCount++;
                int correct=n1+n2;
                if (result==correct){
                    Toast.makeText(ToplamaActivity.this,"Doğru Cevap Verdiniz.",Toast.LENGTH_LONG).show();
                    x++;
                }
                else {
                    Toast.makeText(ToplamaActivity.this,"Yanlış! Doğru Cevap "+correct,Toast.LENGTH_LONG).show();
                }
                double yuzde=(x/resultCount)*100;
                resultCounter.setText("Doğruluk Yüzdesi:%"+yuzde);
            }


        });
        cikarmaButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), CikarmaActivity.class);
            startActivity(intent);
        });

    }
}