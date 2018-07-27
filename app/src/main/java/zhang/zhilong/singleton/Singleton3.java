package zhang.zhilong.singleton;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: 静态内部类
 */

public class Singleton3 {

    private Singleton3(){

    }

    private static class SingletonHolder{
        private static Singleton3 mInstance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.mInstance;
    }

}
