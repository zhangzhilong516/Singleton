package zhang.zhilong.singleton;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: 饿汉式
 */

public class Singleton {
    // 类初始化的时候已经加载到内存
    private static Singleton mInstance = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return mInstance;
    }

}
