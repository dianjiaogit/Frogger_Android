package com.example.jiaodian.frogger;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioPlay.flag = false;
        AudioPlay.playAudio(this);


        Frog.id = 1;


    }

    public void playGame(View view) {
        //Log.d("game", "buttom clicked");
        Intent intent = new Intent(this, StartMainActivity.class);
        startActivity(intent);

    }

    public void setting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

    public void score(View view) {
        Intent intent = new Intent(this, ScoreBoard.class);
        startActivity(intent);
    }
}
