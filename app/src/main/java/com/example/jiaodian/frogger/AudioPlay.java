package com.example.jiaodian.frogger;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.getSystemService;

public class AudioPlay {

    public static MediaPlayer mp;
    public static boolean flag;
    public static Button button;


    public static void playAudio(Context c) {

        if (flag == false) {
            mp = MediaPlayer.create(c, R.raw.mainactivity_song);

            mp.start();
            mp.setLooping(true);
            flag = true;
        } else if (mp.isPlaying() && flag == true) {
            mp.pause();
            flag = false;
        }


    }
}