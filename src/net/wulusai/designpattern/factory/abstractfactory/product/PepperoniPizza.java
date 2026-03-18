package net.wulusai.designpattern.factory.abstractfactory.product;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;

/**
 * 胡椒香肠披萨
 */
public class PepperoniPizza extends Pizza {
    
    /**
     * 构造函数：设置披萨名称
     */
    public PepperoniPizza() {
        name = "胡椒香肠披萨";
    }
    
    /**
     * 准备食材：胡椒香肠披萨需要基础原料和意大利辣香肠
     * @param ingredientFactory 原料工厂接口
     */
    @Override
    public void prepare(PizzaIngredientFactory ingredientFactory) {
        System.out.println("正在准备 " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
