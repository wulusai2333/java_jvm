package net.wulusai.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类 - 咖啡风味工厂
 * 负责创建和管理咖啡风味对象的共享池
 * 确保相同风味的咖啡只创建一个实例
 */
public class CoffeeFlavorFactory {
    private Map<String, CoffeeFlavor> flavorPool;

    public CoffeeFlavorFactory() {
        /* 初始化享元池 */
        this.flavorPool = new HashMap<>();
    }

    /**
     * 获取咖啡风味对象
     * 如果池中已存在该风味的对象，则直接返回
     * 如果不存在，则创建新对象并放入池中
     * 
     * @param flavor 咖啡风味名称
     * @return 咖啡风味对象
     */
    public CoffeeFlavor getCoffeeFlavor(String flavor) {
        CoffeeFlavor coffeeFlavor = flavorPool.get(flavor);
        
        if (coffeeFlavor == null) {
            /* 池中不存在，创建新对象 */
            coffeeFlavor = new ConcreteCoffeeFlavor(flavor);
            flavorPool.put(flavor, coffeeFlavor);
        } else {
            System.out.println("复用已有的咖啡风味对象: " + flavor);
        }
        
        return coffeeFlavor;
    }

    /**
     * 获取享元池中对象的数量
     * @return 对象数量
     */
    public int getTotalFlavorsMade() {
        return flavorPool.size();
    }
}
