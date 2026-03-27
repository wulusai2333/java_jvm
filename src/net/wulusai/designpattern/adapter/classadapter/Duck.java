package net.wulusai.designpattern.adapter.classadapter;

/**
 * 目标接口：野鸭（期望的接口）
 */
public interface Duck {
    /**
     * 嘎嘎叫
     */
    void quack();
    
    /**
     * 飞行
     */
    void fly();
}
