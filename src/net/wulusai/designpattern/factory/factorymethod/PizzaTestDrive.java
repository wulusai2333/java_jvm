package net.wulusai.designpattern.factory.factorymethod;

import net.wulusai.designpattern.factory.factorymethod.creator.ChicagoPizzaStore;
import net.wulusai.designpattern.factory.factorymethod.creator.NyPizzaStore;
import net.wulusai.designpattern.factory.factorymethod.creator.PizzaStore;
import net.wulusai.designpattern.factory.factorymethod.product.Pizza;

/**
 * 工厂方法模式测试类
 * 演示如何使用工厂方法模式创建不同风味的披萨
 * 工厂方法模式:定义一个创建对象的接口，让子类决定实例化哪一个类
 * 使用条件:
 * 1.需要创建对象
 * 2.对象类型比较多
 * 3.需要扩展
 * 创建目标:单个产品
 * 工厂数量:多个工厂类
 * 适用场景:产品类型多
 * 需要增加产品时符合开闭原则
 */
public class PizzaTestDrive {
    
    /**
     * 主方法：测试工厂方法模式
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建纽约披萨店
        PizzaStore nyStore = new NyPizzaStore();
        // 创建芝加哥披萨店
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        
        System.out.println("========== 在纽约订购披萨 ==========");
        // 在纽约订购奶酪披萨
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("\n顾客点了：" + pizza.getName() + "\n");
        
        System.out.println("\n========== 在纽约订购蛤蜊披萨 ==========");
        // 在纽约订购蛤蜊披萨
        pizza = nyStore.orderPizza("clam");
        System.out.println("\n顾客点了：" + pizza.getName() + "\n");
        
        System.out.println("\n========== 在芝加哥订购披萨 ==========");
        // 在芝加哥订购奶酪披萨
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("\n顾客点了：" + pizza.getName() + "\n");
        
        System.out.println("\n========== 在芝加哥订购意式香肠披萨 ==========");
        // 在芝加哥订购意式香肠披萨
        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("\n顾客点了：" + pizza.getName() + "\n");
    }
}
