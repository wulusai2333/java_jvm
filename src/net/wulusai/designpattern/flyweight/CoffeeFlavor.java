package net.wulusai.designpattern.flyweight;

/**
 * 抽象享元类 - 咖啡风味
 * 定义咖啡的接口，包含内部状态（咖啡名称）和外部状态（订单信息）
 */
public interface CoffeeFlavor {
    /**
     * 服务咖啡 - 操作享元对象
     * @param table 桌号（外部状态）
     * @param orderNumber 订单号（外部状态）
     */
    void serveCoffee(int table, int orderNumber);

    /**
     * 获取咖啡名称
     * @return 咖啡名称
     */
    String getFlavor();
}
