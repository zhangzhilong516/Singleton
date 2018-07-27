package zhang.zhilong.singleton;

/**
 * author zhangzhilong
 * on 2018/7/27.
 * Description: 饿汉式
 */

public enum Singleton4 {
    INSTANCE;
    public void doSomething(){
        Singleton4.INSTANCE.doSomething();
    }
}
