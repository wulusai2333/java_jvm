package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 纽约风格奶酪披萨
 * 使用纽约风味的面团和酱料
 */
public class NyStyleCheesePizza extends Pizza {
    
    /**
     * 构造函数，初始化纽约风格奶酪披萨的配料
     */
    public NyStyleCheesePizza() {
        this.name = "纽约风格奶酪披萨";
        this.dough = "薄脆面团";
        this.sauce = "番茄酱";
        this.toppings.add("磨碎的马苏里拉奶酪");
    }
}
