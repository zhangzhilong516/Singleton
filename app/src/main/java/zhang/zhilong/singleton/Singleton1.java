package zhang.zhilong.singleton;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: 懒汉式
 */

public class Singleton1 {
    private static Singleton1 mInstance;

    private Singleton1(){

    }
    // 多线程有可能创建多个实例
    public static Singleton1 getInstance(){
        if(mInstance == null){
            mInstance = new Singleton1();
        }
        return mInstance;
    }

    /**
     * 每次都要同步判断
     */
    public static synchronized Singleton1 getInstance1(){
        if(mInstance == null){
            mInstance = new Singleton1();
        }
        return mInstance;
    }

}
