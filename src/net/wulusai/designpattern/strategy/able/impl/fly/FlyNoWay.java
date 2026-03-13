package net.wulusai.designpattern.strategy.able.impl.fly;

import net.wulusai.designpattern.strategy.able.FlyAble;

public class FlyNoWay implements FlyAble {
    @Override
    public void fly() {
        System.out.println("I cannot fly");
    }
}
