package net.wulusai.designpattern.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端测试类
 * 享元模式: 运用共享技术有效地支持大量细粒度对象的复用
 * 通过共享咖啡风味对象，减少内存占用
 */
public class FlyweightPatternTest {
    private static List<Order> orders = new ArrayList<>();
    private static CoffeeFlavorFactory flavorFactory;

    public static void main(String[] args) {
        /* 创建享元工厂 */
        flavorFactory = new CoffeeFlavorFactory();

        System.out.println("=== 模拟咖啡店订单系统 ===\n");

        /* 模拟多个订单，其中有些订单是相同的咖啡风味 */
        takeOrder("卡布奇诺", 1, 101);
        takeOrder("拿铁", 2, 102);
        takeOrder("卡布奇诺", 3, 103);  /* 与第一个订单相同风味，应复用对象 */
        takeOrder("美式咖啡", 1, 104);
        takeOrder("拿铁", 4, 105);      /* 与第二个订单相同风味，应复用对象 */
        takeOrder("卡布奇诺", 5, 106);  /* 再次复用卡布奇诺对象 */
        takeOrder("摩卡", 2, 107);
        takeOrder("美式咖啡", 3, 108);  /* 复用美式咖啡对象 */
        takeOrder("拿铁", 6, 109);      /* 再次复用完铁对象 */
        takeOrder("摩卡", 4, 110);      /* 复用摩卡对象 */

        System.out.println("\n=== 开始服务所有订单 ===\n");
        /* 服务所有订单 */
        for (Order order : orders) {
            order.serve();
        }

        System.out.println("\n=== 统计信息 ===");
        System.out.println("总共创建了 " + flavorFactory.getTotalFlavorsMade() + " 个咖啡风味对象");
        System.out.println("总共处理了 " + orders.size() + " 个订单");
        System.out.println("通过享元模式节省了 " + (orders.size() - flavorFactory.getTotalFlavorsMade()) + " 个对象的空间");
    }

    /**
     * 接受订单
     * @param flavorName 咖啡风味名称
     * @param tableNumber 桌号
     * @param orderNumber 订单号
     */
    private static void takeOrder(String flavorName, int tableNumber, int orderNumber) {
        /* 从工厂获取咖啡风味对象（可能复用已有对象） */
        CoffeeFlavor flavor = flavorFactory.getCoffeeFlavor(flavorName);
        
        /* 创建订单，维护外部状态 */
        Order order = new Order(flavor, tableNumber, orderNumber);
        orders.add(order);
    }
}
