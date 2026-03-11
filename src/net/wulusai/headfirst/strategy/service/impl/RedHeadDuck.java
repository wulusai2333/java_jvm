package net.wulusai.headfirst.strategy.service.impl;

import net.wulusai.headfirst.strategy.able.impl.fly.FlyWithWings;
import net.wulusai.headfirst.strategy.able.impl.quack.Quack;
import net.wulusai.headfirst.strategy.model.Duck;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        this.flyAbility = new FlyWithWings();
        this.quackAbility = new Quack();
    }
    @Override
    public void display() {
        System.out.println("I'm a real Red Headed duck");
    }
}
