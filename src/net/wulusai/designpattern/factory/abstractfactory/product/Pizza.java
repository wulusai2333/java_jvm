package net.wulusai.designpattern.factory.abstractfactory.product;

import net.wulusai.designpattern.factory.abstractfactory.factory.PizzaIngredientFactory;

/**
 * 披萨抽象类
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clam;

    /**
     * 准备方法：使用原料工厂准备食材
     * @param ingredientFactory 原料工厂接口
     */
    public void prepare(PizzaIngredientFactory ingredientFactory) {
        System.out.println("正在准备 " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }

    /**
     * 烘烤披萨
     */
    public void bake() {
        System.out.println("烘烤 25 分钟，温度 350 度");
    }

    /**
     * 切披萨
     */
    public void cut() {
        System.out.println("将披萨切成对角线片");
    }

    /**
     * 装盒
     */
    public void box() {
        System.out.println("将披萨放入官方披萨店包装盒中");
    }

    /**
     * 获取披萨名称
     * @return 披萨名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置披萨名称
     * @param name 披萨名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 显示披萨信息
     */
    public void printInfo() {
        System.out.println("---- 制作 " + name + " ----");
        
        if (dough != null) {
            System.out.println("面团：" + dough);
        }
        if (sauce != null) {
            System.out.println("酱料：" + sauce);
        }
        if (cheese != null) {
            System.out.println("奶酪：" + cheese);
        }
        if (veggies != null && veggies.length > 0) {
            System.out.println("蔬菜：");
            for (int i = 0; i < veggies.length; i++) {
                System.out.println("   " + veggies[i]);
            }
        }
        if (pepperoni != null) {
            System.out.println("意大利辣香肠：" + pepperoni);
        }
        if (clam != null) {
            System.out.println("蛤蜊：" + clam);
        }
    }
}
