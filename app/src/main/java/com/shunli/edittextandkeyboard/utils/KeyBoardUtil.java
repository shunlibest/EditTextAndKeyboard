package com.shunli.edittextandkeyboard.utils;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import androidx.annotation.NonNull;

/**
 * KeyBoardUtil: 工具类
 *
 * @author shunli.han
 * @date 2022/5/14
 */
public class KeyBoardUtil {

    public static void jumpInputSetting(@NonNull Context context) {
        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
        context.startActivity(intent);
    }
}
