package net.wulusai.designpattern.factory.factorymethod.product;

import java.util.ArrayList;

/**
 * 披萨抽象类
 * 定义了所有披萨的通用属性和方法
 */
public abstract class Pizza {
    
    /**
     * 披萨名称
     */
    protected String name;
    
    /**
     * 面团类型
     */
    protected String dough;
    
    /**
     * 酱料类型
     */
    protected String sauce;
    
    /**
     * 配料列表
     */
    protected ArrayList<String> toppings = new ArrayList<>();
    
    /**
     * 准备阶段：添加各种配料
     */
    public void prepare() {
        System.out.println("正在准备 " + name);
        System.out.println("揉面团..." );
        System.out.println("添加酱料: " + sauce);
        System.out.println("添加配料:");
        for (String topping : toppings) {
            System.out.println("  加入 " + topping);
        }
    }
    
    /**
     * 烘烤阶段
     */
    public void bake() {
        System.out.println("烘烤温度：350 华氏度");
        System.out.println("烘烤时间：25 分钟");
        System.out.println(name + " 正在烘烤中...");
    }
    
    /**
     * 切披萨阶段
     */
    public void cut() {
        System.out.println("将 " + name + " 切成三角块");
    }
    
    /**
     * 装盒阶段
     */
    public void box() {
        System.out.println("将 " + name + " 装入官方包装盒");
    }
    
    /**
     * 获取披萨名称
     * @return 披萨名称
     */
    public String getName() {
        return name;
    }
}