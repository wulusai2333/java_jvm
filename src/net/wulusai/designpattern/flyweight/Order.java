package net.wulusai.designpattern.flyweight;

/**
 * 订单类 - 维护外部状态
 * 记录每个订单的外部状态（桌号、订单号）
 */
public class Order {
    private int tableNumber;
    private int orderNumber;
    private CoffeeFlavor flavor;

    public Order(CoffeeFlavor flavor, int tableNumber, int orderNumber) {
        this.flavor = flavor;
        this.tableNumber = tableNumber;
        this.orderNumber = orderNumber;
    }

    /**
     * 服务订单
     */
    public void serve() {
        flavor.serveCoffee(tableNumber, orderNumber);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public CoffeeFlavor getFlavor() {
        return flavor;
    }
}
