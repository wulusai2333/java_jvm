package net.wulusai.designpattern.factory.abstractfactory;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaStore;
import net.wulusai.designpattern.factory.abstractfactory.factory.impl.ChicagoPizzaStore;
import net.wulusai.designpattern.factory.abstractfactory.factory.impl.NyPizzaStore;
import net.wulusai.designpattern.factory.abstractfactory.product.Pizza;

/**
 * 抽象工厂模式测试类
 * 演示如何使用抽象工厂模式创建不同风味的披萨
 * 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，无需指定具体类
 * 使用条件:
 * 1. 需要创建对象
 * 2. 需要相关产品组合
 * 3. 需要扩展
 * 创建目标：产品族
 * 工厂数量：多个工厂类
 * 适用场景：相关产品组合
 * 符合开闭原则，保证产品兼容性
 */
public class PizzaTestDrive {
    
    /**
     * 主方法：测试抽象工厂模式
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建纽约披萨店和芝加哥披萨店
        PizzaStore nyStore = new NyPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        
        System.out.println("========== 订购纽约风味披萨 ==========\n");
        
        // 在纽约披萨店订购奶酪披萨
        Pizza nyCheese = nyStore.orderPizza("cheese");
        System.out.println("\n" + nyCheese.getName() + " 已准备好！\n");
        nyCheese.printInfo();
        
        System.out.println("\n----------------------------------------\n");
        
        // 在纽约披萨店订购蛤蜊披萨
        Pizza nyClam = nyStore.orderPizza("clam");
        System.out.println("\n" + nyClam.getName() + " 已准备好！\n");
        nyClam.printInfo();
        
        System.out.println("\n========================================\n");
        System.out.println("========== 订购芝加哥风味披萨 ==========\n");
        
        // 在芝加哥披萨店订购奶酪披萨
        Pizza chicagoCheese = chicagoStore.orderPizza("cheese");
        System.out.println("\n" + chicagoCheese.getName() + " 已准备好！\n");
        chicagoCheese.printInfo();
        
        System.out.println("\n----------------------------------------\n");
        
        // 在芝加哥披萨店订购素食披萨
        Pizza chicagoVeggie = chicagoStore.orderPizza("veggie");
        System.out.println("\n" + chicagoVeggie.getName() + " 已准备好！\n");
        chicagoVeggie.printInfo();
    }
}
