package net.wulusai.designpattern.factory.abstractfactory.factory.impl;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;
import net.wulusai.designpattern.factory.abstractfactory.product.*;

/**
 * 芝加哥披萨原料工厂
 * 生产芝加哥风味的披萨原料
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
    
    /**
     * 创建厚饼面团
     * @return 厚饼面团实例
     */
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    /**
     * 创建梅子酱
     * @return 梅子酱实例
     */
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    /**
     * 创建马苏里拉奶酪
     * @return 马苏里拉奶酪实例
     */
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    /**
     * 创建芝加哥风味蔬菜
     * @return 蔬菜数组
     */
    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = { 
            new BlackOlives(), 
            new Spinach(), 
            new Eggplant() 
        };
        return veggies;
    }

    /**
     * 创建意大利辣香肠
     * @return 意大利辣香肠实例
     */
    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    /**
     * 创建冷冻蛤蜊
     * @return 冷冻蛤蜊实例
     */
    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
