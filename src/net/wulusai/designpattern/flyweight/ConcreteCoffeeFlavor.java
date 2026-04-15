package net.wulusai.designpattern.flyweight;

/**
 * 具体享元类 - 具体咖啡风味
 * 内部状态：咖啡名称（不可变，可共享）
 * 外部状态：桌号、订单号（由客户端传入）
 */
public class ConcreteCoffeeFlavor implements CoffeeFlavor {
    private String flavor;

    public ConcreteCoffeeFlavor(String flavor) {
        /* 内部状态：咖啡名称，创建后不可改变 */
        this.flavor = flavor;
        System.out.println("创建新的咖啡风味对象: " + flavor);
    }

    @Override
    public void serveCoffee(int table, int orderNumber) {
        /* 
         * 使用内部状态（咖啡名称）和外部状态（桌号、订单号）来服务咖啡
         * 内部状态不变，外部状态由客户端传入
         */
        System.out.println("服务咖啡 [订单#" + orderNumber + "] - " + flavor + " 到第 " + table + " 桌");
    }

    @Override
    public String getFlavor() {
        return flavor;
    }
}
