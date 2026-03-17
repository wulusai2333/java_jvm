package net.wulusai.designpattern.factory.simplefactory.product;

/**
 * 蔬菜披萨
 */
public class VeggiePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("准备蔬菜披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤蔬菜披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割蔬菜披萨");
    }

    @Override
    public void box() {
        System.out.println("打包蔬菜披萨");
    }
}
