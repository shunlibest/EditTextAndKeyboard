package com.shunli.edittextandkeyboard;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
    LinearLayout childAt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        rootView = findViewById(R.id.root);
        tips = findViewById(R.id.tips);

        FrameLayout decorView = (FrameLayout) getWindow().getDecorView();
        Rect rect = new Rect(-2, 335, 2, 395);
        decorView.requestRectangleOnScreen(rect);
//        decorView.
//        getWindow().getDecorView().getParent().getChildVisibleRect();
//        getWindow().getDecorView()
        childAt = (LinearLayout) decorView.getChildAt(0);

        childAt.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(
                    View v,
                    int left, int top, int right, int bottom,
                    int oldLeft, int oldTop, int oldRight,
                    int oldBottom) {
                Log.e("hanshunli", "");
            }
        });
        rootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Log.e("hanshunli", "");
            }
        });
        run();
    }

    int i = 0;

    private void run() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                childAt.

//                bottomMargin
//                Log.e("",""+bottomMargin);
                runOnUiThread(() -> {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    i += 5;
                    int leftMargin = layoutParams.leftMargin;
                    int rightMargin = layoutParams.rightMargin;
                    int topMargin = layoutParams.topMargin;
                    int bottomMargin = layoutParams.bottomMargin;


                    childAt.animate().translationY(-i);
//                    layoutParams.setMargins(leftMargin,topMargin,i,i);
//                    childAt.setLayoutParams(layoutParams);


//                    Rect rect = new Rect(-2, 335, 2,i );
//                    tips.requestRectangleOnScreen(rect,true);
//                    int height = rootView.getHeight();
//                    tips.setText("bottomMargin Height:" + bottomMargin);
                });
            }
        }).start();
    }
}