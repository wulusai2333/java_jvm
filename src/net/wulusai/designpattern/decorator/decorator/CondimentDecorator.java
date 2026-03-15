package net.wulusai.designpattern.decorator.decorator;

import net.wulusai.designpattern.decorator.component.Beverage;

/**
 * 抽象装饰者
 */
public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();

}
