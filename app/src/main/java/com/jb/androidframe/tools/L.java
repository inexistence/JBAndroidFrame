package com.jb.androidframe.tools;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 全局log开关
 * 自动设置TAG为当前类名
 */
public final class L {
	public static boolean LOG_OPEN = true;
    public static final String TAG_HEAD = "JBAndroid";

	public static void setLogOpen(boolean open) {
		LOG_OPEN = open;
	}

    public static void v(String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.v(getTag(null), formatMessage(message, args));
    }

    public static void d(String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.d(getTag(null), formatMessage(message, args));
    }

    public static void i(String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.i(getTag(null), formatMessage(message, args));
    }

    public static void w(String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.w(getTag(null), formatMessage(message, args));
    }

    public static void e(String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.e(getTag(null), formatMessage(message, args));
    }
    public static void v(String tag, String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.v(getTag(tag), formatMessage(message, args));
    }

    public static void d(String tag, String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.d(getTag(tag), formatMessage(message, args));
    }

    public static void i(String tag, String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.i(getTag(tag), formatMessage(message, args));
    }

    public static void w(String tag, String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.w(getTag(tag), formatMessage(message, args));
    }

    public static void e(String tag, String message, Object... args) {
        if(!LOG_OPEN) return ;
        Log.e(getTag(tag), formatMessage(message, args));
    }
    public static void w(Throwable e) {
        if(!LOG_OPEN) return ;
        e.printStackTrace();
    }

    public static void e(Throwable e) {
        if(!LOG_OPEN) return ;
        e.printStackTrace();
    }

    public static void json(String tag, String json) {
        if(!LOG_OPEN) return ;
        printJson(getTag(tag), json);
    }

    public static void json(String json) {
        if(!LOG_OPEN) return ;
        printJson(getTag(null), json);
    }

    public static void printJson(String tag, String json) {
        // TODO 输出格式不美观
        if(TextUtils.isEmpty(json)) {
            Log.e(tag, "Empty/Null json content");
        } else {
            try {
                String message;
                if(json.startsWith("{")) {
                    JSONObject e1 = new JSONObject(json);
                    message = e1.toString(4);
                    Log.d(tag, message);
                    return;
                }

                if(json.startsWith("[")) {
                    JSONArray e = new JSONArray(json);
                    message = e.toString(4);
                    Log.d(tag, message);
                }
            } catch (JSONException var4) {
                Log.e(tag, var4.getCause().getMessage() + "\n" + json);
            }
        }
    }

    private static String formatMessage(String message, Object... args) {
        if (message == null) {
            return "";
        }
        if (args != null && args.length > 0) {
            try {
                return String.format(message, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    private static String getTag(String customTag) {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[4];
        String className = stackTrace.getClassName();
        String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
        String tag = TextUtils.isEmpty(customTag) ? TAG_HEAD + "/" + simpleClassName : TAG_HEAD + "/" + customTag;
        String position = " [("+simpleClassName+".java:"+stackTrace.getLineNumber()+")#"+stackTrace.getMethodName() +"]";
        return tag + position;
    }
}
