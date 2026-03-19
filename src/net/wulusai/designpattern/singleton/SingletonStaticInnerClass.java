package net.wulusai.designpattern.singleton;

/**
 * 静态内部类式单例模式
 * 利用类加载机制保证线程安全，同时实现延迟加载
 * JVM 保证静态内部类只会被加载一次
 */
public class SingletonStaticInnerClass {
    
    /**
     * 私有构造函数，防止外部实例化
     */
    private SingletonStaticInnerClass() {
        System.out.println("静态内部类式单例已创建");
    }
    
    /**
     * 静态内部类，持有单例实例
     * 只有在调用 getInstance() 时才会被加载
     */
    private static class SingletonHolder {
        private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
    }
    
    /**
     * 获取单例实例
     * @return 单例实例
     */
    public static SingletonStaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    /**
     * 测试方法
     */
    public void doSomething() {
        System.out.println("静态内部类式单例正在执行操作");
    }
}
