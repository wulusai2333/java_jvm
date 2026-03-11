package net.wulusai.headfirst.strategy.able.impl.fly;

import net.wulusai.headfirst.strategy.able.FlyAble;

public class FlyNoWay implements FlyAble {
    @Override
    public void fly() {
        System.out.println("I cannot fly");
    }
}
