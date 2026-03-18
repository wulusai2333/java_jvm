package net.wulusai.designpattern.factory.abstractfactory.factory;

import net.wulusai.designpattern.factory.abstractfactory.product.*;

/**
 * 披萨原料工厂
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}
