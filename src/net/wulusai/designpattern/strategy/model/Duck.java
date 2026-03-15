package net.wulusai.designpattern.strategy.model;

import net.wulusai.designpattern.strategy.able.FlyAble;
import net.wulusai.designpattern.strategy.able.QuackAble;

/**
 * 父类
 * has 比 is 更好
 *
 */
public class Duck {
    /**
     * 飞行能力
     */
    protected FlyAble flyAbility;

    /**
     * 吱吱叫能力
     */
    protected QuackAble quackAbility;

    public void performFly() {
        flyAbility.fly();
    }

    public void performQuack() {
        quackAbility.quack();
    }

    public void setFlyAbility(FlyAble flyAbility) {
        this.flyAbility = flyAbility;
    }

    public void setQuackAbility(QuackAble quackAbility) {
        this.quackAbility = quackAbility;
    }

    public void display() {
        System.out.println("Duck is displayed");
    }

    public void swim() {
        System.out.println("Duck is swimming");
    }
}
