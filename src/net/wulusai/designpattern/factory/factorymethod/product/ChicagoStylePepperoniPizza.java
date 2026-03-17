package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 芝加哥风格意大利辣香肠披萨
 * 使用厚底面团和香辣意式香肠
 */
public class ChicagoStylePepperoniPizza extends Pizza {
    
    /**
     * 构造函数，初始化芝加哥风格意大利辣香肠披萨的配料
     */
    public ChicagoStylePepperoniPizza() {
        this.name = "芝加哥风格意大利辣香肠披萨";
        this.dough = "厚底面团";
        this.sauce = "李子番茄酱";
        this.toppings.add("碎马苏里拉奶酪");
        this.toppings.add("香辣意式香肠");
        this.toppings.add("红辣椒片");
        this.toppings.add("帕尔玛干酪");
    }
}
