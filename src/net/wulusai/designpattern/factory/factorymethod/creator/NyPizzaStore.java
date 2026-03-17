package net.wulusai.designpattern.factory.factorymethod.creator;

import net.wulusai.designpattern.factory.factorymethod.product.NyStyleCheesePizza;
import net.wulusai.designpattern.factory.factorymethod.product.NyStyleClamPizza;
import net.wulusai.designpattern.factory.factorymethod.product.NyStylePepperoniPizza;
import net.wulusai.designpattern.factory.factorymethod.product.NyStyleVeggiePizza;
import net.wulusai.designpattern.factory.factorymethod.product.Pizza;

/**
 * 纽约披萨店
 * 专门制作纽约风格的披萨
 */
public class NyPizzaStore extends PizzaStore {
    
    /**
     * 实现工厂方法，创建纽约风格的各种披萨
     * @param type 披萨类型
     * @return 具体类型的纽约风格披萨
     */
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NyStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new NyStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new NyStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new NyStyleVeggiePizza();
        }
        return null;
    }
}
