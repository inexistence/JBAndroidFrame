package com.jb.androidframe.tools;

import android.util.Log;

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

    private static TagPositionInfo getTagPosition() {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[4];

        String className = stackTrace.getClassName();
        String simpleClassName = className.substring(className.lastIndexOf('.') + 1);

        String tag = TAG_HEAD + "/" + simpleClassName;
        String position = " ("+simpleClassName+".java:"+stackTrace.getLineNumber()+")";
        TagPositionInfo tagPositionInfo = new TagPositionInfo();
        tagPositionInfo.tag = tag;
        tagPositionInfo.logPosition = position;
        return tagPositionInfo;
    }

    public static void d(String message, Object... args) {
    	if(!LOG_OPEN) return ;
        message = formatMessage(message, args);
        TagPositionInfo tagPositionInfo = getTagPosition();
        Log.d(tagPositionInfo.tag, message + tagPositionInfo.logPosition);
    }

    public static void i(String message, Object... args) {
    	if(!LOG_OPEN) return ;
        message = formatMessage(message, args);
        TagPositionInfo tagPositionInfo = getTagPosition();
        Log.i(tagPositionInfo.tag, message + tagPositionInfo.logPosition);
    }

    public static void w(String message, Object... args) {
    	if(!LOG_OPEN) return ;
        message = formatMessage(message, args);
        TagPositionInfo tagPositionInfo = getTagPosition();
        Log.w(tagPositionInfo.tag, message + tagPositionInfo.logPosition);
    }

    public static void w(Throwable e) {
    	if(!LOG_OPEN) return ;
        e.printStackTrace();
    }

    public static void e(String message, Object... args) {
    	if(!LOG_OPEN) return ;
        message = formatMessage(message, args);
        TagPositionInfo tagPositionInfo = getTagPosition();
        Log.e(tagPositionInfo.tag, message + tagPositionInfo.logPosition);
    }

    public static void e(Throwable e) {
    	if(!LOG_OPEN) return ;
        e.printStackTrace();
    }

    public static void v(String message, Object... args) {
    	if(!LOG_OPEN) return ;
        message = formatMessage(message, args);
        TagPositionInfo tagPositionInfo = getTagPosition();
        Log.v(tagPositionInfo.tag, message + tagPositionInfo.logPosition);
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

    private static class TagPositionInfo {
        String tag;
        String logPosition;
    }
}
