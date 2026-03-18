package net.wulusai.designpattern.factory.abstractfactory.factory.impl;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;
import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaStore;
import net.wulusai.designpattern.factory.abstractfactory.product.*;

/**
 * 芝加哥披萨店
 * 专门制作芝加哥风格的披萨
 */
public class ChicagoPizzaStore extends PizzaStore {
    
    /**
     * 创建芝加哥风味披萨
     * @param type 披萨类型
     * @return 具体披萨对象
     */
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("芝加哥风味奶酪披萨");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
            pizza.setName("芝加哥风味胡椒香肠披萨");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
            pizza.setName("芝加哥风味蛤蜊披萨");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
            pizza.setName("芝加哥风味素食披萨");
        }
        
        return pizza;
    }
    
    /**
     * 创建芝加哥原料工厂
     * @return 芝加哥原料工厂实例
     */
    @Override
    protected PizzaIngredientFactory createIngredientFactory() {
        return new ChicagoPizzaIngredientFactory();
    }
}
