package net.wulusai.designpattern.factory.abstractfactory.factory.impl;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;
import net.wulusai.designpattern.factory.abstractfactory.product.*;

/**
 * 纽约披萨原料工厂
 * 生产纽约风味的披萨原料
 */
public class NyPizzaIngredientFactory implements PizzaIngredientFactory{
    
    /**
     * 创建薄饼面团
     * @return 薄饼面团实例
     */
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    /**
     * 创建番茄酱
     * @return 番茄酱实例
     */
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    /**
     * 创建新鲜莫扎里拉奶酪
     * @return 新鲜莫扎里拉奶酪实例
     */
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    /**
     * 创建纽约风味蔬菜
     * @return 蔬菜数组
     */
    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = { 
            new Garlic(), 
            new Onion(), 
            new Mushroom(), 
            new RedPepper() 
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
     * 创建新鲜蛤蜊
     * @return 新鲜蛤蜊实例
     */
    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
