package net.wulusai.designpattern.decorator.decorator;

import net.wulusai.designpattern.decorator.component.Beverage;

/**
 * 鞭打奶油
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
