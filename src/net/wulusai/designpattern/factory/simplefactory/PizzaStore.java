package net.wulusai.designpattern.factory.simplefactory;

import net.wulusai.designpattern.factory.simplefactory.creator.SimplePizzaFactory;
import net.wulusai.designpattern.factory.simplefactory.product.Pizza;

/**
 * 简单披萨工厂模式下的披萨店
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }
    public Pizza createPizza(String type) {
        return factory.createPizza(type);
    }
    /**
     * 订购披萨
     */
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
