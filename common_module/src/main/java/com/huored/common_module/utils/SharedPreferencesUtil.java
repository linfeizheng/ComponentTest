package com.huored.common_module.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtil {

    /**
     * 存储文件名
     */
    public final static String SHAREDPREFERENCES_FILE = "helloboard.xml";

    /**
     * 社区选择topic标志位，如果为false，则点击社区，需要弹出选择关注话题页面（第一次打开App）
     * 当用户进入选择关注话题页面，即永久改为true，不管关注还是跳过，都不再进入选择关注话题页面
     */
    public static final String BBS_TOPIC_FLAG = "BBS_TOPIC_FLAG";

    /**
     * 抽奖，是否记住了不再提示
     */
    public static final String WHEEL_REMIND_FLAG = "WHEEL_REMIND_FLAG";

    /**
     * 第一次进入
     */
    public static final String FIRST_IN = "FIRST_IN";

    private SharedPreferences sp;
    private Editor editor;

    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences(SHAREDPREFERENCES_FILE, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void put(String key, Object object) {
        try {
            if (object instanceof String) {
                editor.putString(key, (String) object);
            } else if (object instanceof Integer) {
                editor.putInt(key, (Integer) object);
            } else if (object instanceof Boolean) {
                editor.putBoolean(key, (Boolean) object);
            } else if (object instanceof Float) {
                editor.putFloat(key, (Float) object);
            } else if (object instanceof Long) {
                editor.putLong(key, (Long) object);
            } else {
                editor.putString(key, object.toString());
            }
        } catch (Exception e) {
//            Logger.e("SharedPreferences存入失败", e);
        }
        editor.commit();
    }

    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
//        Logger.e("没有读取到shared值：key-->" + key);
        return null;
    }

    public boolean getBbsTopicFlag() {
        return sp.getBoolean(BBS_TOPIC_FLAG, false);
    }

    public void saveBbsTopicFlag(boolean flag) {
        editor.putBoolean(BBS_TOPIC_FLAG, flag).commit();
    }

    public boolean getWheelRemindFlag() {
        return sp.getBoolean(WHEEL_REMIND_FLAG, false);
    }

    public void saveWheelRemindFlag(boolean flag) {
        editor.putBoolean(WHEEL_REMIND_FLAG, flag).commit();
    }

    public boolean isFirstIn() {
        return sp.getBoolean(FIRST_IN, true);
    }

    public void saveFirstInFlag(boolean flag) {
        editor.putBoolean(FIRST_IN, flag).commit();
    }
}
