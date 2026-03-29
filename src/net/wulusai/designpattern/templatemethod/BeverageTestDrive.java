package net.wulusai.designpattern.templatemethod;

/**
 * 模板方法模式测试类
 * 模板方法模式，定义算法骨架，允许子类重写特定步骤而不改变结构
 */
public class BeverageTestDrive {
    public static void main(String[] args) {
        System.out.println("Making tea...");
        new Tea().prepareRecipe();
        System.out.println("Making coffee...");
        new Coffee().prepareRecipe();
        System.out.println("Making tea with hook...");
        new TeaWithHook().prepareRecipe();
        System.out.println("Making coffee with hook...");
        new CoffeeWithHook().prepareRecipe();
    }
}
