package com.example.coding3_guess;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText minput;
    private Button mcheck;
    private String mstring;
    private int code=0;
    private String manswer="5668";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //将input编辑框的字体设置为consolas
        minput=findViewById(R.id.input);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"consola.ttf");
        minput.setTypeface(typeFace);

        //监听input编辑框内容，仅当为0001-9999时，check按钮颜色为玫红进行跳转
        mcheck=findViewById(R.id.check);
        minput.addTextChangedListener(new TextWatcher(){

            public void onTextChanged(CharSequence text, int start, int before, int count) {
                //text  输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                mstring=String.valueOf(text);
                Pattern p = Pattern.compile("[0-9]*");
                Matcher m = p.matcher(text);

                if (m.matches() && mstring.equals("0000") == false && mstring.length() == 4)
                {
                    mcheck.setBackgroundResource(R.drawable.my_button_checked);
                    if(mstring.equals(manswer))
                    {
                        code=0;
                    }
                    else
                    {
                        code=1;
                    }
                }
                else
                {
                    mcheck.setBackgroundResource(R.drawable.my_button_unchecked);
                    code=2;
                }

                mcheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        switch(code)
                        {
                            case 0:
                                Intent intent0 = new Intent(MainActivity.this, CorrectActivity.class);
                                intent0.putExtra("string0", mstring);
                                startActivity(intent0);
                                break;
                            case 1:
                                Intent intent1 = new Intent(MainActivity.this, WrongActivity.class);
                                intent1.putExtra("string1", mstring);
                                intent1.putExtra("stringanswer", manswer);
                                startActivity(intent1);
                                break;
                            case 2:
                                break;
                        }
                    }
                });
        }

            public void beforeTextChanged(CharSequence text, int start, int count,int after) {
                //text  输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量

            }

            public void afterTextChanged(Editable edit) {
                //edit  输入结束呈现在输入框中的信息

            }

        });



    }
}
