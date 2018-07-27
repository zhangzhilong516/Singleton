package zhang.zhilong.singleton;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: 双重锁 (DCL)
 */

public class Singleton2 {

    //volatile 1.线程不可见 2.处理器乱序执行

    private static volatile Singleton2 mInstance;

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(mInstance == null){
            synchronized (Singleton2.class){
                if(mInstance == null){
                    mInstance = new Singleton2();
                }
            }
        }
        return mInstance;
    }
}
