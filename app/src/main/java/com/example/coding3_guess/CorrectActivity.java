package com.example.coding3_guess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CorrectActivity extends AppCompatActivity {

    private TextView mgetinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        //将input编辑框的字体设置为consolas
        mgetinput=findViewById(R.id.getinput);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"consola.ttf");
        mgetinput.setTypeface(typeFace);

        Intent intent =getIntent();
        mgetinput.setText(intent.getStringExtra("string0"));
    }
}
