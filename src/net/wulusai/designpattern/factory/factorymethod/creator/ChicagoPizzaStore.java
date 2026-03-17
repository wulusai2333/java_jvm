package net.wulusai.designpattern.factory.factorymethod.creator;

import net.wulusai.designpattern.factory.factorymethod.product.ChicagoStyleCheesePizza;
import net.wulusai.designpattern.factory.factorymethod.product.ChicagoStyleClamPizza;
import net.wulusai.designpattern.factory.factorymethod.product.ChicagoStylePepperoniPizza;
import net.wulusai.designpattern.factory.factorymethod.product.ChicagoStyleVeggiePizza;
import net.wulusai.designpattern.factory.factorymethod.product.Pizza;

/**
 * 芝加哥披萨店
 * 专门制作芝加哥风格的披萨
 */
public class ChicagoPizzaStore extends PizzaStore {
    
    /**
     * 实现工厂方法，创建芝加哥风格的各种披萨
     * @param type 披萨类型
     * @return 具体类型的芝加哥风格披萨
     */
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        }
        return null;
    }
}
