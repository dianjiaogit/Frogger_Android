package com.example.jiaodian.frogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class GameActivity extends AppCompatActivity implements GameOver{
    GameView gameView;
    Map <String, Float> record;
    ArrayList<Map<String, Float>> records;
    final String FILENAME = "SCOREBOARD.xml";
    final String SAVENAME = "SCOREBOARD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String LEVEL = intent.getStringExtra("LEVEL");
        String NAME = intent.getStringExtra("Name");
        int WIDTH = Integer.parseInt(intent.getStringExtra("WIDTH"));
        int HEIGHT = Integer.parseInt(intent.getStringExtra("HEIGHT"));
        gameView = findViewById(R.id.gameview);
        gameView.HEIGHT = HEIGHT;
        gameView.WIDTH = WIDTH;
        gameView.registerGameOver(this);
        gameView.create();
        gameView.getLevel(LEVEL);
        gameView.getName(NAME);
    }

    public void clickUP (View view) {
        gameView.moveUp();
    }

    public void clickDOWN (View view) {
        gameView.moveDown();
    }

    public void clickLEFT (View view) {
        gameView.moveLeft();
    }

    public void clickRIGHT (View view) {
        gameView.moveRight();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void gameOver() {
        setResult(AppCompatActivity.RESULT_OK);
        Intent intent = new Intent(this, GameOverActivity.class);
        if (gameView.hasWon) {
            intent.putExtra("hasWon", "1");
        } else {
            intent.putExtra("hasWon", "0");
        }
        intent.putExtra("Time", String.format("%.1f", gameView.time));
        intent.putExtra("NAME", gameView.NAME);
        startActivity(intent);
        finish();
    }

    public ArrayList<Map<String, Float>> getRecords() {
        File f = new File(FILENAME);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        records = new ArrayList<>();
        try {
            // load the xml tree
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(f);

            // parse the tree and obtain the person info
            Node node = doc.getFirstChild();
            if (node.getNodeName().equals(SAVENAME)) {
                Node n = node.getFirstChild();
                //records = n.getTextContent();
            }

        } catch (Exception e) {
            System.err.println("Problem loading " + FILENAME);
            System.out.println(e);
        }
        return records;
    }
}
