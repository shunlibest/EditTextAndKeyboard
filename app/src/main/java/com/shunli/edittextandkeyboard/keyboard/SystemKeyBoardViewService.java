package com.shunli.edittextandkeyboard.keyboard;


import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;

import com.shunli.edittextandkeyboard.R;

/**
 * Created by yang.jianan on 2017/04/19 14:37.
 * 开发参考：http://blog.csdn.net/le_go/article/details/9264831
 * 输入法服务的生命周期图：http://img.blog.csdn.net/20130707203833640
 */
public class SystemKeyBoardViewService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private String TAG = SystemKeyBoardViewService.class.getName();

    private KeyboardView keyboardView; // 对应keyboard.xml中定义的KeyboardView
    private Keyboard keyboard; // 对应qwerty.xml中定义的Keyboard

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
        // keyboard被创建后，将调用onCreateInputView函数
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboardview_sys, null);  // 此处使用了keyboard.xml

//        KeyboardView keyboardView = (KeyboardView) view.findViewById(R.id.keyboard);


        keyboard = new Keyboard(this, R.xml.qwerty); // 此处使用了qwerty.xml
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this); //注册键盘事件监听

        Log.d(TAG, "onCreateInputView()");
        return keyboardView;
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

    //↓↓↓↓↓↓↓OnKeyboardActionListener接口对应的方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();

        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE: //删除键
                inputConnection.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_DONE: //完成键
                inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                //hideWindow(); //隐藏键盘
                break;
            default: //普通输入
                char code = (char) primaryCode;
                inputConnection.commitText(code + "嘿", 1); //可以对输入的字符串做 加密等等处理
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
