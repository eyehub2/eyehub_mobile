package com.android.example.eyehub_proto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.example.eyehub_proto.R;

import java.util.ArrayList;
import java.util.Random;

public class ctchthknny extends AppCompatActivity {
    private int score = 0;
    private boolean gameStarted = false;
    String isim;

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (ImageView image : imageArray) {
                image.setVisibility(View.INVISIBLE);
            }
            int randomIndex = new Random().nextInt(9);
            imageArray.get(randomIndex).setVisibility(View.VISIBLE);
            handler.postDelayed(this, 1500);
        }
    };
    private ArrayList<ImageView> imageArray = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctch_layout);

        Button returnToMenuButton = findViewById(R.id.returnToMenuButton);

        returnToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        showStartGameDialog();

        imageArray.add(findViewById(R.id.imageView));
        imageArray.add(findViewById(R.id.imageView2));
        imageArray.add(findViewById(R.id.imageView3));
        imageArray.add(findViewById(R.id.imageView4));
        imageArray.add(findViewById(R.id.imageView5));
        imageArray.add(findViewById(R.id.imageView6));
        imageArray.add(findViewById(R.id.imageView7));
        imageArray.add(findViewById(R.id.imageView8));
        imageArray.add(findViewById(R.id.imageView9));

    }

    private void showStartGameDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Start Game");
        dialogBuilder.setMessage("Are you ready to start the game?");

        dialogBuilder.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameStarted = true;
                new CountDownTimer(15500, 1000) {
                    TextView timeText=findViewById(R.id.timeText);

                    @Override
                    public void onFinish() {

                        timeText.setText(R.string.time_up);
                        handler.removeCallbacks(runnable);
                        for (ImageView image : imageArray) {
                            image.setVisibility(View.INVISIBLE);
                        }

                        AlertDialog.Builder alert = new AlertDialog.Builder(ctchthknny.this);
                        alert.setTitle("Time's UP");
                        alert.setMessage("Restart The Game?");
                        alert.setPositiveButton("Yes", (dialog, which) -> {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        });

                        alert.setNegativeButton("No", (dialog, which) -> {
                            Toast.makeText(ctchthknny.this, "Time's UP! Score: " + score+" Well done "+isim, Toast.LENGTH_LONG).show();
                        });

                        alert.show();



                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        //fix
                        timeText.setText("Time:" + millisUntilFinished / 1000);
                    }
                }.start();
                hideImages();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ctchthknny.this, "Game cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }

    private void hideImages() {
        if (gameStarted) {
            handler.post(runnable);
        }
    }

    public void increaseScore(View view) {
        TextView scoreText=findViewById(R.id.scoreText);
        score = score + 1;
        scoreText.setText("Score: " + score);
    }
}
