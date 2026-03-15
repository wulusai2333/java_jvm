package net.wulusai.designpattern.decorator.decorator;

import net.wulusai.designpattern.decorator.component.Beverage;

/**
 * 摩卡
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
