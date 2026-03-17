package net.wulusai.designpattern.factory.simplefactory.product;

/**
 * 蛤蜊披萨
 */
public class ClamPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备制作蛤蜊披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤蛤蜊披萨");
    }

    @Override
    public void cut() {
        System.out.println("切片蛤蜊披萨");
    }

    @Override
    public void box() {
        System.out.println("装盒蛤蜊披萨");
    }
}