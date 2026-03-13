package net.wulusai.designpattern.strategy.able.impl.fly;

import net.wulusai.designpattern.strategy.able.FlyAble;

public class FlyRocketPowered implements FlyAble {
    @Override
    public void fly() {
        System.out.println("Fly with rocket power");
    }
}
