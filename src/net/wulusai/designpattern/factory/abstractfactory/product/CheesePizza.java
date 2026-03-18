package net.wulusai.designpattern.factory.abstractfactory.product;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;

/**
 * 奶酪披萨
 */
public class CheesePizza extends Pizza {
    
    /**
     * 构造函数：设置披萨名称
     */
    public CheesePizza() {
        name = "奶酪披萨";
    }
    
    /**
     * 准备食材：奶酪披萨只需要基础原料（面团、酱料、奶酪、蔬菜）
     * @param ingredientFactory 原料工厂接口
     */
    @Override
    public void prepare(PizzaIngredientFactory ingredientFactory) {
        System.out.println("正在准备 " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}
