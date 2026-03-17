package net.wulusai.designpattern.factory.factorymethod.product;

/**
 * 纽约风格素食披萨
 * 添加各种新鲜蔬菜
 */
public class NyStyleVeggiePizza extends Pizza {
    
    /**
     * 构造函数，初始化纽约风格素食披萨的配料
     */
    public NyStyleVeggiePizza() {
        this.name = "纽约风格素食披萨";
        this.dough = "薄脆面团";
        this.sauce = "番茄酱";
        this.toppings.add("磨碎的马苏里拉奶酪");
        this.toppings.add("洋葱");
        this.toppings.add("青椒");
        this.toppings.add("蘑菇");
        this.toppings.add("橄榄");
    }
}
