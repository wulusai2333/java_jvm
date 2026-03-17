package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 纽约风格蛤蜊披萨
 * 使用新鲜的蛤蜊作为配料
 */
public class NyStyleClamPizza extends Pizza {
    
    /**
     * 构造函数，初始化纽约风格蛤蜊披萨的配料
     */
    public NyStyleClamPizza() {
        this.name = "纽约风格蛤蜊披萨";
        this.dough = "薄脆面团";
        this.sauce = "番茄酱";
        this.toppings.add("磨碎的马苏里拉奶酪");
        this.toppings.add("新鲜蛤蜊");
        this.toppings.add("大蒜");
    }
}
