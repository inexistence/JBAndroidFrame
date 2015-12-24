package com.jb.androidframe.tools.task;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * TaskExecutor
 * Created by Jianbin on 2015/12/20.
 */
public class TaskExecutor {
    static {
        ensureThreadExecutor();
    }
    private static ThreadPoolExecutorWrapper sThreadPoolExecutorWrapper;

    private static void ensureThreadExecutor() {
        init(10, Integer.MAX_VALUE, 10);
    }

    public static void init(int maxTaskThread, int maxIdleTaskThread, int maxScheduleTaskThread) {
        if (sThreadPoolExecutorWrapper == null) {
            sThreadPoolExecutorWrapper = new ThreadPoolExecutorWrapper(maxTaskThread, maxIdleTaskThread, maxScheduleTaskThread);
        }
    }

    public static void executeTask(Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.executeTask(task);
    }

    public static <T> Future<T> submitTask(Callable<T> task) {
        ensureThreadExecutor();
        return sThreadPoolExecutorWrapper.submitTask(task);
    }

    public static void scheduleTask(long delay, Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.scheduleTask(delay, task);
    }

    public static void scheduleTaskAtFixedRateIgnoringTaskRunningTime(long initialDelay, long period, Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.scheduleTaskAtFixedRateIgnoringTaskRunningTime(initialDelay, period, task);
    }

    public static void scheduleTaskAtFixedRateIncludingTaskRunningTime(long initialDelay, long period, Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.scheduleTaskAtFixedRateIncludingTaskRunningTime(initialDelay, period, task);
    }

    public static boolean removeScheduledTask(Runnable task) {
        ensureThreadExecutor();
        return sThreadPoolExecutorWrapper.removeScheduledTask(task);
    }

    public static void scheduleTaskOnUiThread(long delay, Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.scheduleTaskOnUiThread(delay, task);
    }

    public static void removeScheduledTaskOnUiThread(Runnable task) {
        ensureThreadExecutor();
        sThreadPoolExecutorWrapper.removeScheduledTaskOnUiThread(task);
    }

    public static void runTaskOnUiThread(Runnable task) {
        sThreadPoolExecutorWrapper.runTaskOnUiThread(task);
    }

    public static void shutdown() {
        if (sThreadPoolExecutorWrapper != null) {
            sThreadPoolExecutorWrapper.shutdown();
            sThreadPoolExecutorWrapper = null;
        }
    }
}
