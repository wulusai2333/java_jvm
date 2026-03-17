package net.wulusai.designpattern.factory.simplefactory.creator;

import net.wulusai.designpattern.factory.simplefactory.product.*;

/**
 * 创建简单披萨工厂
 */
public class SimplePizzaFactory {

    /**
     * 根据类型创建披萨
     */
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
