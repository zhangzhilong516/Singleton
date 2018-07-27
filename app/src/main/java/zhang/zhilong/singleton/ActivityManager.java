package zhang.zhilong.singleton;

import android.app.Activity;

import java.util.Stack;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: Activity统一管理类
 */

public class ActivityManager {

    private static final class Holder{
        private static final ActivityManager INSTANCE = new ActivityManager();
    }
    private static ActivityManager instance;

    public static ActivityManager getInstance() {
        return Holder.INSTANCE;
    }

    private Stack<Activity> mActivityStack;

    private ActivityManager() {
        mActivityStack = new Stack<>();
    }

    public void attach(Activity activity) {
        mActivityStack.add(activity);
    }

    public void detach(Activity activity) {
        mActivityStack.remove(activity);
    }

    public Activity currentActivity() {
        return mActivityStack.lastElement();
    }

    public void finish(Activity activity) {
        mActivityStack.remove(activity);
        activity.finish();
    }

    public void finish(Class<? extends Activity> activityClass) {
        int size = mActivityStack.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivityStack.get(i);
            if (activity.getClass().equals(activityClass)) {
                mActivityStack.remove(i);
                activity.finish();
                i--;
                size--;
            }
        }
    }

    public boolean isActivityExist(Class<? extends Activity> activityClass) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(activityClass)) {
                return true;
            }
        }
        return false;
    }

    public void finishAllActivity() {
        int size = mActivityStack.size();
        for (int i = 0; i < size; i++) {
            Activity activity = mActivityStack.get(i);
            mActivityStack.remove(i);
            activity.finish();
            i--;
            size--;
        }
        mActivityStack.clear();
    }

    public void exit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
