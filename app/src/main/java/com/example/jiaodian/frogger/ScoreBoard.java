package com.example.jiaodian.frogger;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private static final float DEFAULTSCORE = 99999;
    private static final String DEFAULTNAME = "DEFAULT";

    private String FSTNAME = "FirstName";
    private String FSTTIME = "FirstTime";
    private String SNDNAME = "SecondName";
    private String SNDTIME = "SecondTime";
    private String THRNAME = "ThirdName";
    private String THRTIME = "ThirdTime";

    SharedPreferences prefs;

    String fst;
    String snd;
    String thr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        prefs = getSharedPreferences("sp", Context.MODE_PRIVATE);
        textView1 = findViewById(R.id.textView221);
        fst = "First Player: "+ prefs.getString(FSTNAME,DEFAULTNAME) + "  Score: " + prefs.getFloat(FSTTIME,DEFAULTSCORE);
        textView1.setText(fst);
        textView2 = findViewById(R.id.textView222);
        snd = "Second Player: "+ prefs.getString(SNDNAME,DEFAULTNAME) + "  Score: " + prefs.getFloat(SNDTIME,DEFAULTSCORE);
        textView2.setText(snd);
        textView3 = findViewById(R.id.textView223);
        thr = "Third Player: "+ prefs.getString(THRNAME,DEFAULTNAME) + "  Score: " + prefs.getFloat(THRTIME,DEFAULTSCORE);
        textView3.setText(thr);
    }







}
