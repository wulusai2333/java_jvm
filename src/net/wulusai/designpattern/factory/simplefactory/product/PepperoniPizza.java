package net.wulusai.designpattern.factory.simplefactory.product;

/**
 * 意大利辣香肠披萨
 */
public class PepperoniPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备制作意大利辣香肠披萨");
    }

    @Override
    public void bake() {
        System.out.println("制作意大利辣香肠披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割意大利辣香肠披萨");
    }

    @Override
    public void box() {
        System.out.println("打包意大利辣香肠披萨");
    }
}
