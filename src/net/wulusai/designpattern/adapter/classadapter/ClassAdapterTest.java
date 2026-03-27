package net.wulusai.designpattern.adapter.classadapter;

/**
 * 类适配器测试
 *
 */
public class ClassAdapterTest {
    public static void main(String[] args) {
        // 创建适配器
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter();

        System.out.println("========== 把火鸡当作鸭子使用 ==========");
        // 现在可以把火鸡当作鸭子使用了
        turkeyAdapter.quack();  // 实际调用的是 Turkey.gobble()
        turkeyAdapter.fly();    // 调用的是 Turkey.fly()

        System.out.println("\n========== 仍然可以当作火鸡使用 ==========");
        // 由于是继承关系，仍然可以直接当作火鸡使用
        turkeyAdapter.gobble();
        turkeyAdapter.fly();
    }
}
