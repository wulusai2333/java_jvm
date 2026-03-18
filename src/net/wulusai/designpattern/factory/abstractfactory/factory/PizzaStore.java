package net.wulusai.designpattern.factory.abstractfactory.factory;

import net.wulusai.designpattern.factory.abstractfactory.product.Pizza;

/**
 * 工厂方法模式下的披萨店抽象类
 * 定义了创建披萨的模板方法
 */
public abstract class PizzaStore {
    
    /**
     * 订购披萨：模板方法
     * @param type 披萨类型
     * @return 制作好的披萨
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        
        if (pizza != null) {
            pizza.prepare(createIngredientFactory());
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        
        return pizza;
    }
    
    /**
     * 创建披萨：由子类实现
     * @param type 披萨类型
     * @return 具体披萨对象
     */
    protected abstract Pizza createPizza(String type);
    
    /**
     * 创建原料工厂：由子类实现
     * @return 原料工厂实例
     */
    protected abstract PizzaIngredientFactory createIngredientFactory();
}
