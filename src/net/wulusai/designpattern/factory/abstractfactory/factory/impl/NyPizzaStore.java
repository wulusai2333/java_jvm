package net.wulusai.designpattern.factory.abstractfactory.factory.impl;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;
import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaStore;
import net.wulusai.designpattern.factory.abstractfactory.product.*;

/**
 * 纽约披萨店
 * 专门制作纽约风格的披萨
 */
public class NyPizzaStore extends PizzaStore {
    
    /**
     * 创建纽约风味披萨
     * @param type 披萨类型
     * @return 具体披萨对象
     */
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("纽约风味奶酪披萨");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
            pizza.setName("纽约风味胡椒香肠披萨");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
            pizza.setName("纽约风味蛤蜊披萨");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
            pizza.setName("纽约风味素食披萨");
        }
        
        return pizza;
    }
    
    /**
     * 创建纽约原料工厂
     * @return 纽约原料工厂实例
     */
    @Override
    protected PizzaIngredientFactory createIngredientFactory() {
        return new NyPizzaIngredientFactory();
    }
}
