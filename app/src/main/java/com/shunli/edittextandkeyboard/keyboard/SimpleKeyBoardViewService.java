package com.shunli.edittextandkeyboard.keyboard;


import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;

import com.shunli.edittextandkeyboard.R;

/**
 * @author shunli.han
 * @date 2022/5/14
 */
public class SimpleKeyBoardViewService extends InputMethodService implements View.OnClickListener {
    private String TAG = SimpleKeyBoardViewService.class.getName();

    // 做了一些非UI方面的初始化，即字符串变量词汇分隔符的初始化
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    /**
     * 键盘 第一次现实的时候调用
     *
     * @return
     */
    @Override
    public View onCreateInputView() {
        // 对应keyboard.xml中定义的KeyboardView
        View keyboardView = getLayoutInflater().inflate(R.layout.keyboard_simple, null);
        keyboardView.findViewById(R.id.btn1).setOnClickListener(this);
        keyboardView.findViewById(R.id.btn2).setOnClickListener(this);
        keyboardView.findViewById(R.id.btn3).setOnClickListener(this);
        keyboardView.findViewById(R.id.btn4).setOnClickListener(this);
        keyboardView.findViewById(R.id.newLine).setOnClickListener(this);
        keyboardView.findViewById(R.id.btn_hide).setOnClickListener(this);
        Log.d(TAG, "onCreateInputView()");
        return keyboardView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hide) {
            // 隐藏软键盘
            onFinishInput();
        } else {
            Button button = (Button) v;
            // 获得InputConnection对象, InputConnection由客户端控件创建，并传递给输入法应用，由输入法应用调用，进行信息反馈
            InputConnection inputConnection = getCurrentInputConnection();
            if (button.getId() == R.id.btn1) {
                // 设置预输入文本
                // setComposingText方法的第2个参数值为1，表示在当前位置预输入文本
                inputConnection.setComposingText(button.getText(), 1);
            } else if (button.getId() == R.id.newLine) {
                inputConnection.commitText("\n", 1);
            } else {
                // 向当前获得焦点的EditText控件输出文本
                // commitText方法第2个参数值为1，表示在当前位置插入文本
                inputConnection.commitText(button.getText(), 1);
            }
        }
    }

    /**
     * 联想词条 第一次被现实的时候调用
     * 在要显示侯选词汇的视图时，由框架调用，和onCreateInputView类似，在这个方法中，对candidateview进行初始化
     *
     * @return
     */
    @Override
    public View onCreateCandidatesView() {
        Log.d(TAG, "onCreateCandidatesView()");
        return super.onCreateCandidatesView();
    }

    @Override
    public void onStartInputView(EditorInfo info, boolean restarting) {
        super.onStartInputView(info, restarting);
        Log.d(TAG, "onStartInputView()");
    }


    @Override
    protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        super.onCurrentInputMethodSubtypeChanged(newSubtype);
        Log.d(TAG, "onCurrentInputMethodSubtypeChanged()");
    }

    @Override
    public void onFinishInput() {
        super.onFinishInput();
        Log.d(TAG, "onFinishInput()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}