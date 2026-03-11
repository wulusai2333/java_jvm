package net.wulusai.headfirst.strategy.able.impl.fly;

import net.wulusai.headfirst.strategy.able.FlyAble;

public class FlyWithWings implements FlyAble {
    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }
}
