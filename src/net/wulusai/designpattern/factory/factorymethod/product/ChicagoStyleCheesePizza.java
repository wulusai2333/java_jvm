package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 芝加哥风格奶酪披萨
 * 使用厚底面团和浓郁的奶酪
 */
public class ChicagoStyleCheesePizza extends Pizza {
    
    /**
     * 构造函数，初始化芝加哥风格奶酪披萨的配料
     */
    public ChicagoStyleCheesePizza() {
        this.name = "芝加哥风格奶酪披萨";
        this.dough = "厚底面团";
        this.sauce = "李子番茄酱";
        this.toppings.add("碎马苏里拉奶酪");
        this.toppings.add("帕尔玛干酪");
    }
}
