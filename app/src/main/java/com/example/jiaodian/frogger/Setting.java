package com.example.jiaodian.frogger;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Setting extends AppCompatActivity {
    int original_alpha = 500;
    public static MediaPlayer mp;
    boolean flag = false;
    Button button;


    public void setToOriginal(Drawable one, Drawable two) {

        one.setAlpha(original_alpha);
        two.setAlpha(original_alpha);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Frog.id = 1;
    }


    public void playMusic(View view) { // play the music "ON"
        button = (Button) findViewById(R.id.ON);
        AudioPlay.playAudio(this);
        if (AudioPlay.flag == true) {
            button.setText("OFF");
        } else {
            button.setText("ON");
        }


    }

    public void setPig(View view) {
        ImageButton goat = findViewById(R.id.goat);
        ImageButton frog = findViewById(R.id.frog);
        Drawable one = getResources().getDrawable(R.drawable.character_goat);
        Drawable two = getResources().getDrawable(R.drawable.character_frog);
        goat.setBackgroundDrawable(one);
        frog.setBackgroundDrawable(two);

        setToOriginal(one, two);
        ImageButton pig = findViewById(R.id.pig);
        Drawable d = getResources().getDrawable(R.drawable.character_pig);
        d.setAlpha(60);
        pig.setBackgroundDrawable(d);
        Frog.id = 3;


    }

    public void setGoat(View view) {

        ImageButton pig = findViewById(R.id.pig);
        ImageButton frog = findViewById(R.id.frog);
        Drawable one = getResources().getDrawable(R.drawable.character_pig);
        Drawable two = getResources().getDrawable(R.drawable.character_frog);
        pig.setBackgroundDrawable(one);
        frog.setBackgroundDrawable(two);

        setToOriginal(one, two);
        ImageButton goat = findViewById(R.id.goat);
        Drawable d = getResources().getDrawable(R.drawable.character_goat);
        d.setAlpha(60);
        goat.setBackgroundDrawable(d);
        Frog.id = 2;


    }

    public void setFrog(View view) {
        ImageButton goat = findViewById(R.id.goat);
        ImageButton pig = findViewById(R.id.pig);
        Drawable one = getResources().getDrawable(R.drawable.character_goat);
        Drawable two = getResources().getDrawable(R.drawable.character_pig);
        goat.setBackgroundDrawable(one);
        pig.setBackgroundDrawable(two);

        setToOriginal(one, two);
        ImageButton frog = findViewById(R.id.frog);
        Drawable d = getResources().getDrawable(R.drawable.character_frog);
        d.setAlpha(60);
        frog.setBackgroundDrawable(d);
        Frog.id = 1;

    }
}
