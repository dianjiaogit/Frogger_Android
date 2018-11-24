package com.example.jiaodian.frogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class StartMainActivity extends AppCompatActivity {
    ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_main);
        v = findViewById(R.id.imageView);
    }

    public void easyGame(View view) {
        EditText edittext = findViewById(R.id.name);
        String name = edittext.getText().toString();
        if (!name.trim().isEmpty()) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Name", name);
            intent.putExtra("LEVEL", "2");
            intent.putExtra("WIDTH", Integer.toString(v.getWidth()));
            intent.putExtra("HEIGHT", Integer.toString(v.getHeight()));
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Please insert your name first", Toast.LENGTH_SHORT).show();
        }
    }

    public void normalGame(View view) {
        EditText edittext = findViewById(R.id.name);
        String name = edittext.getText().toString();
        if (!name.trim().isEmpty()) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Name", name);
            intent.putExtra("LEVEL", "6");
            intent.putExtra("WIDTH", Integer.toString(v.getWidth()));
            intent.putExtra("HEIGHT", Integer.toString(v.getHeight()));
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Please insert your name first", Toast.LENGTH_SHORT).show();
        }
    }

    public void hardGame(View view) {
        EditText edittext = findViewById(R.id.name);
        String name = edittext.getText().toString();
        if (!name.trim().isEmpty()) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Name", name);
            intent.putExtra("LEVEL", "12");
            intent.putExtra("WIDTH", Integer.toString(v.getWidth()));
            intent.putExtra("HEIGHT", Integer.toString(v.getHeight()));
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Please insert your name first", Toast.LENGTH_SHORT).show();
        }
    }
}
