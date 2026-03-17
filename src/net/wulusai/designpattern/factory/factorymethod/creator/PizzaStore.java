package net.wulusai.designpattern.factory.factorymethod.creator;

import net.wulusai.designpattern.factory.factorymethod.product.Pizza;

/**
 * 工厂方法模式下的披萨店抽象类
 * 定义了创建披萨的模板方法
 */
public abstract class PizzaStore {
    
    /**
     * 订购披萨的模板方法
     * 定义了制作披萨的标准流程
     * @param type 披萨类型
     * @return 制作好的披萨
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        
        System.out.println("--- 正在制作 " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
    
    /**
     * 工厂方法：由子类实现来创建具体的披萨类型
     * @param type 披萨类型
     * @return 具体类型的披萨
     */
    protected abstract Pizza createPizza(String type);
}
