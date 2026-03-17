package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 芝加哥风格素食披萨
 * 使用厚底面团和各种蔬菜
 */
public class ChicagoStyleVeggiePizza extends Pizza {
    
    /**
     * 构造函数，初始化芝加哥风格素食披萨的配料
     */
    public ChicagoStyleVeggiePizza() {
        this.name = "芝加哥风格素食披萨";
        this.dough = "厚底面团";
        this.sauce = "李子番茄酱";
        this.toppings.add("碎马苏里拉奶酪");
        this.toppings.add("黑橄榄");
        this.toppings.add("菠菜");
        this.toppings.add("茄子");
        this.toppings.add("帕尔玛干酪");
    }
}
