package com.shunli.edittextandkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shunli.edittextandkeyboard.utils.KeyBoardUtil;

/**
 * MainActivity: 主页面
 *
 * @author shunli.han
 * @date 2022/5/14
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void jumpInputSetting(View view) {
        KeyBoardUtil.jumpInputSetting(this);
    }

    public void jumpEditTextTest(View view) {
        startActivity(new Intent(MainActivity.this, EditTextActivity.class));
    }
}