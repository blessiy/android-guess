package com.example.coding3_guess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class WrongActivity extends AppCompatActivity {

    private TextView mgetinput;
    private ImageView mup;
    private ImageView mdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);

        //将input编辑框的字体设置为consolas
        mgetinput=findViewById(R.id.getinput);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"consola.ttf");
        mgetinput.setTypeface(typeFace);

        Intent intent =getIntent();
        mgetinput.setText(intent.getStringExtra("string1"));

        mup=findViewById(R.id.up);
        mdown=findViewById(R.id.down);

        VectorDrawableCompat vectorDrawableCompatUpFocusd= VectorDrawableCompat.create(getResources(), R.drawable.ic_keyboard_arrow_up_black_24dp, getTheme());
        VectorDrawableCompat vectorDrawableCompatUpUnFocusd= VectorDrawableCompat.create(getResources(), R.drawable.ic_keyboard_arrow_up_black_24dp, getTheme());
        vectorDrawableCompatUpFocusd.setTint(Color.parseColor("#D81B60"));
        vectorDrawableCompatUpUnFocusd.setTint(Color.parseColor("#919191"));

        VectorDrawableCompat vectorDrawableCompatDownFocusd= VectorDrawableCompat.create(getResources(), R.drawable.ic_keyboard_arrow_down_black_24dp, getTheme());
        VectorDrawableCompat vectorDrawableCompatDownUnFocusd= VectorDrawableCompat.create(getResources(), R.drawable.ic_keyboard_arrow_down_black_24dp, getTheme());
        vectorDrawableCompatDownFocusd.setTint(Color.parseColor("#D81B60"));
        vectorDrawableCompatDownUnFocusd.setTint(Color.parseColor("#919191"));

        if (Integer.valueOf(intent.getStringExtra("string1"))<Integer.valueOf(intent.getStringExtra("stringanswer")))
        {
            mup.setImageDrawable(vectorDrawableCompatUpFocusd);
            mdown.setImageDrawable(vectorDrawableCompatDownUnFocusd);
        }
        else
        {
            mup.setImageDrawable(vectorDrawableCompatUpUnFocusd);
            mdown.setImageDrawable(vectorDrawableCompatDownFocusd);
        }
    }
}
