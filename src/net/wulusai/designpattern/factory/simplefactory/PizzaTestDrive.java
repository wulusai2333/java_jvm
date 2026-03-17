package net.wulusai.designpattern.factory.simplefactory;

import net.wulusai.designpattern.factory.simplefactory.creator.SimplePizzaFactory;
import net.wulusai.designpattern.factory.simplefactory.product.Pizza;

/**
 * 简单工厂:通过一个工厂类创建不同类型的对象，但不属于GoF 23种设计模式
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
