package com.example.jiaodian.frogger;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {
    private TextView textView;
    private Boolean hasWon;
    private String Name;
    private Float Time;
    private String Result;

    private static final float DEFAULTSCORE = 99999;
    private static final String DEFAULTNAME = "DEFAULT";
    private String FSTNAME = "FirstName";
    private String FSTTIME = "FirstTime";
    private String SNDNAME = "SecondName";
    private String SNDTIME = "SecondTime";
    private String THRNAME = "ThirdName";
    private String THRTIME = "ThirdTime";
    private String fstName;
    private Float fstTime;
    private String sndName;
    private Float sndTime;
    private String thrName;
    private Float thrTime;


    public GameOverActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        Intent intent = getIntent();
        textView = findViewById(R.id.textView555);
        String won = intent.getStringExtra("hasWon");
        if (won.equals("0")) {
            hasWon = false;
        } else if (won.equals("1")) {
            hasWon = true;
        }
        Time = Float.parseFloat(intent.getStringExtra("Time"));
        Name = intent.getStringExtra("NAME");
        if (hasWon) {
            Result = ("Player: " + Name + "  Score: " + Time);
        } else {
            Result = ("You Lost!");
        }
        textView.setText(Result);
        textView.getPaint().setFakeBoldText(true);

        SharedPreferences prefs = getSharedPreferences("sp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if (hasWon) {
            fstName = prefs.getString(FSTNAME, DEFAULTNAME);
            fstTime = prefs.getFloat(FSTTIME, DEFAULTSCORE);
            sndName = prefs.getString(SNDNAME, DEFAULTNAME);
            sndTime = prefs.getFloat(SNDTIME, DEFAULTSCORE);
            thrName = prefs.getString(THRNAME, DEFAULTNAME);
            thrTime = prefs.getFloat(THRTIME, DEFAULTSCORE);

            if (fstTime > Time) {
                thrTime = sndTime;
                sndTime = fstTime;
                fstTime = Time;
                thrName = sndName;
                sndName = fstName;
                fstName = Name;
            } else if (sndTime > Time) {
                thrTime = sndTime;
                thrName = sndName;
                sndTime = Time;
                sndName = Name;
            } else if (thrTime > Time) {
                thrTime = Time;
                thrName = Name;
            }

            editor.putString(FSTNAME, fstName);
            editor.putFloat(FSTTIME, fstTime);
            editor.putString(SNDNAME, sndName);
            editor.putFloat(SNDTIME, sndTime);
            editor.putString(THRNAME, thrName);
            editor.putFloat(THRTIME, thrTime);
            editor.commit();
        }
    }

    public void clickRestart(View view) {
        Intent intent = new Intent(this, StartMainActivity.class);
        startActivity(intent);
    }


    public void Menu(View view) {
        AudioPlay.playAudio(this);


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void gameBoard(View view) {
        Intent intent = new Intent(this, ScoreBoard.class);
        startActivity(intent);
    }
}
