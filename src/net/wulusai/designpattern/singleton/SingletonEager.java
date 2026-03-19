package net.wulusai.designpattern.singleton;

/**
 * 饿汉式单例模式
 * 在类加载时就创建实例，线程安全但可能浪费资源
 */
public class SingletonEager {
    
    /**
     * 静态变量，在类加载时创建实例
     */
    private static SingletonEager instance = new SingletonEager();
    
    /**
     * 私有构造函数，防止外部实例化
     */
    private SingletonEager() {
        System.out.println("饿汉式单例已创建");
    }
    
    /**
     * 获取单例实例
     * @return 单例实例
     */
    public static SingletonEager getInstance() {
        return instance;
    }
    
    /**
     * 测试方法
     */
    public void doSomething() {
        System.out.println("饿汉式单例正在执行操作");
    }
}
