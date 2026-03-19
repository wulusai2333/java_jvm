package net.wulusai.designpattern.singleton;

/**
 * 单例模式测试类
 * 测试四种不同的单例实现方式
 *
 */
public class SingletonTest {
    
    public static void main(String[] args) {
        System.out.println("========== 饿汉式单例测试 ==========");
        SingletonEager eager1 = SingletonEager.getInstance();
        SingletonEager eager2 = SingletonEager.getInstance();
        eager1.doSomething();
        System.out.println("eager1 == eager2: " + (eager1 == eager2));
        
        System.out.println("\n========== 懒汉式单例测试 ==========");
        SingletonLazy lazy1 = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
//        lazy1.doSomething();
//        System.out.println("lazy1 == lazy2: " + (lazy1 == lazy2));
        
        System.out.println("\n========== 静态内部类式单例测试 ==========");
        SingletonStaticInnerClass inner1 = SingletonStaticInnerClass.getInstance();
        SingletonStaticInnerClass inner2 = SingletonStaticInnerClass.getInstance();
        inner1.doSomething();
        System.out.println("inner1 == inner2: " + (inner1 == inner2));
        
        System.out.println("\n========== 枚举式单例测试 ==========");
        SingletonEnum enum1 = SingletonEnum.INSTANCE;
        SingletonEnum enum2 = SingletonEnum.INSTANCE;
        enum1.doSomething();
        System.out.println("enum1 == enum2: " + (enum1 == enum2));
        SingletonEnum.INSTANCE.doSomething();
        System.out.println("\n========== 所有单例模式测试完成 ==========");
    }
}
