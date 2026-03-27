package net.wulusai.designpattern.adapter.classadapter;

/**
 * 适配器：火鸡适配器（类适配器模式）
 * 
 * Head First 设计模式中的经典示例：
 * 将火鸡（Turkey）适配为鸭子（Duck）
 * 
 * 类适配器特点：
 * 1. 继承被适配者（Turkey）- 获得火鸡的功能
 * 2. 实现目标接口（Duck）- 符合鸭子的标准
 * 3. 不使用组合，完全通过继承建立适配关系
 */
public class TurkeyAdapter extends Turkey implements Duck {
    
    /**
     * 实现鸭子的 quack() 方法
     * 委托给火鸡的 gobble() 方法
     */
    @Override
    public void quack() {
        // 调用父类（火鸡）的方法
        super.gobble();
        System.out.println("（火鸡假装是鸭子在叫）");
    }
    
    /**
     * 实现鸭子的 fly() 方法
     * 直接复用父类（火鸡）的 fly() 方法
     * 因为 Turkey 已经有 fly() 方法了，可以直接继承使用
     */
    @Override
    public void fly() {
        System.out.println("（火鸡假装能像鸭子一样飞）");
        super.fly();
    }

}
