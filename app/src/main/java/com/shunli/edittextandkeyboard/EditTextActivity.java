package com.shunli.edittextandkeyboard;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * EditTextActivity:
 *
 * @author shunli.han
 * @date 2022/5/14
 */
public class EditTextActivity extends AppCompatActivity {
    ViewGroup rootView;
    TextView tips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        rootView = findViewById(R.id.root);
        tips = findViewById(R.id.tips);
        run();
    }

    private void run() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(() -> {
                    int height = rootView.getHeight();
                    tips.setText("rootView Height:" + height);
                });
            }
        }).start();
    }
}