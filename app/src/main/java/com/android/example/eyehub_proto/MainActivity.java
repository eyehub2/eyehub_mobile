package com.android.example.eyehub_proto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void basketOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, ctchthknny.class);
        startActivity(intent);
    }

    public void topcikOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, ToplamaActivity.class);
        startActivity(intent);
    }

    public void wordOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, WordComparison.class);
        startActivity(intent);
    }
    public void t2sOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentCalistir.class);
        startActivity(intent);
    }


}