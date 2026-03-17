package net.wulusai.designpattern.factory.simplefactory;

import net.wulusai.designpattern.factory.simplefactory.creator.SimplePizzaFactory;
import net.wulusai.designpattern.factory.simplefactory.product.Pizza;

/**
 * 简单工厂:通过一个工厂类创建不同类型的对象，但不属于GoF 23种设计模式
 * 使用条件:
 * 1.需要创建对象
 * 2.对象类型固定
 * 3.不需要扩展
 * 创建目标:单个产品
 * 工厂数量:只有一个工厂类
 * 适用场景:产品类型少
 * 如果遇到需要修改的情况,简单工厂违反了破坏开闭原则
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("制作一个 " + pizza.getName());
        System.out.println(pizza);
        pizza = pizzaStore.orderPizza("veggie");
        System.out.println("制作一个 " + pizza.getName());
        System.out.println(pizza);
        pizza = pizzaStore.orderPizza("clam");
        System.out.println("制作一个 " + pizza.getName());
        System.out.println(pizza);
        pizza = pizzaStore.orderPizza("pepperoni");
        System.out.println("制作一个 " + pizza.getName());
        System.out.println(pizza);
    }
}
