package net.wulusai.designpattern.factory.abstractfactory.product;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;

/**
 * 蛤蜊披萨
 */
public class ClamPizza extends Pizza {
    
    /**
     * 构造函数：设置披萨名称
     */
    public ClamPizza() {
        name = "蛤蜊披萨";
    }
    
    /**
     * 准备食材：蛤蜊披萨需要基础原料和蛤蜊
     * @param ingredientFactory 原料工厂接口
     */
    @Override
    public void prepare(PizzaIngredientFactory ingredientFactory) {
        System.out.println("正在准备 " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        clam = ingredientFactory.createClam();
    }
}
