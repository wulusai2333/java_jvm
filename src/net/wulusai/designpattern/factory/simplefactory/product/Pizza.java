package net.wulusai.designpattern.factory.simplefactory.product;

import java.util.ArrayList;

/**
 * 披萨抽象类
 */
public abstract class Pizza {
    /**
     * 披萨名称
     */
    public String name;
    /**
     * 面团
     */
    public String dough;
    /**
     * 酱料
     */
    public String sauce;
    /**
     * 佐料
     */
    public ArrayList<String> toppings = new ArrayList<String>();

    /**
     * 准备
     */
    public void prepare() {
        System.out.println("准备制作" + name);
        System.out.println("准备制作" + name + "的 面团");
        System.out.println("准备制作" + name + "的 酱料");
        System.out.println("准备制作" + name + "的 佐料");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    /**
     * 烘烤
     */
    public void bake() {
        System.out.println("烘烤" + name);
    }

    /**
     * 切割
     */
    public void cut() {
        System.out.println("切割" + name);
    }

    /**
     * 打包
     */
    public void box() {
        System.out.println("打包" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}