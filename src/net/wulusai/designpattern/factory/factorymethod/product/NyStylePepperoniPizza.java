package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 纽约风格意大利辣香肠披萨
 * 添加香辣意式香肠
 */
public class NyStylePepperoniPizza extends Pizza {
    
    /**
     * 构造函数，初始化纽约风格意大利辣香肠披萨的配料
     */
    public NyStylePepperoniPizza() {
        this.name = "纽约风格意大利辣香肠披萨";
        this.dough = "薄脆面团";
        this.sauce = "番茄酱";
        this.toppings.add("磨碎的马苏里拉奶酪");
        this.toppings.add("香辣意式香肠");
        this.toppings.add("红辣椒片");
    }
}
