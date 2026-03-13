package net.wulusai.designpattern.strategy.able.impl.fly;

import net.wulusai.designpattern.strategy.able.FlyAble;

public class FlyWithWings implements FlyAble {
    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
