package net.wulusai.designpattern.decorator.component;

/**
 * 饮料抽象类
 */
public abstract class Beverage {
    /**
     * 描述
     */
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
