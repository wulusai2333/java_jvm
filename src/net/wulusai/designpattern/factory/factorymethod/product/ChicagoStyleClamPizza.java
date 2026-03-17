package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 芝加哥风格蛤蜊披萨
 * 使用厚底面团和冷冻蛤蜊
 */
public class ChicagoStyleClamPizza extends Pizza {
    
    /**
     * 构造函数，初始化芝加哥风格蛤蜊披萨的配料
     */
    public ChicagoStyleClamPizza() {
        this.name = "芝加哥风格蛤蜊披萨";
        this.dough = "厚底面团";
        this.sauce = "李子番茄酱";
        this.toppings.add("碎马苏里拉奶酪");
        this.toppings.add("冷冻蛤蜊");
        this.toppings.add("帕尔玛干酪");
    }
}
