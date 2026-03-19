package net.wulusai.designpattern.singleton;

/**
 * 懒汉式单例模式（线程安全版本）
 * 在第一次使用时才创建实例，延迟加载
 * 使用 synchronized 保证线程安全
 */
public class SingletonLazy {

    /**
     * 静态变量，初始为 null
     */
    private volatile static SingletonLazy instance;

    /**
     * 私有构造函数，防止外部实例化
     */
    private SingletonLazy() {
        System.out.println("懒汉式单例已创建");
    }

    /**
     * 获取单例实例（双重检查锁定，线程安全）
     *
     * @return 单例实例
     */
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }

        }
        return instance;
    }

    /**
     * 测试方法
     */
    public void doSomething() {
        System.out.println("懒汉式单例正在执行操作");
    }
}
