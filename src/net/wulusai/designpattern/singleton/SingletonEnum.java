package net.wulusai.designpattern.singleton;

/**
 * 枚举式单例模式
 * 《Effective Java》推荐的方式
 * 天然支持序列化，防止反射攻击
 */
public enum SingletonEnum {
    
    /**
     * 唯一的单例实例
     */
    INSTANCE;
    
    /**
     * 构造函数，枚举类型天然私有
     */
    SingletonEnum() {
        System.out.println("枚举式单例已创建");
    }
    
    /**
     * 测试方法
     */
    public void doSomething() {
        System.out.println("枚举式单例正在执行操作");
    }
}
