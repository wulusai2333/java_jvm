package net.wulusai.designpattern.decorator.component;

/**
 * 焦糖咖啡
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }
    public double cost() {
        return 0.99;

    }
}
