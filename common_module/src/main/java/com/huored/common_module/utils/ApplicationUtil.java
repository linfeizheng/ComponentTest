package com.huored.common_module.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplicationUtil {

    private final static List<Activity> activities = new ArrayList<>();

    /**
     * 加入Activity
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 移除Activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 销毁其它Activity
     */
    public static void exit() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }

    public static void finish(Class<?> c) {
        for (Activity activity : activities) {
            if (activity.getClass() == c)
                activity.finish();
        }
    }

    /**
     * 获取当前程序的版本号
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取当前程序的版本号
     */
    public static String getVersionName(Context context) {
        PackageInfo info;
        try {
            synchronized (context) {
                info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            }
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}