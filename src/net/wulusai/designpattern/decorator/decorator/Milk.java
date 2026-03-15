package net.wulusai.designpattern.decorator.decorator;

import net.wulusai.designpattern.decorator.component.Beverage;

/**
 * 奶泡
 */
public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
