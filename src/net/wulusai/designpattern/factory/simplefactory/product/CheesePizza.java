package net.wulusai.designpattern.factory.simplefactory.product;

/**
 * 芝士披萨
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备制作芝士披萨");
    }

    @Override
    public void bake() {
        System.out.println("烘烤芝士披萨");
    }

    @Override
    public void cut() {
        System.out.println("切片芝士披萨");
    }

    @Override
    public void box() {
        System.out.println("装盒芝士披萨");
    }
}
