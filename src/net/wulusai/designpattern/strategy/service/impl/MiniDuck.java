package net.wulusai.designpattern.strategy.service.impl;

import net.wulusai.designpattern.strategy.able.impl.fly.FlyRocketPowered;
import net.wulusai.designpattern.strategy.able.impl.quack.Quack;
import net.wulusai.designpattern.strategy.model.Duck;

public class MiniDuck extends Duck {
    public MiniDuck() {
        this.flyAbility = new FlyRocketPowered();
        this.quackAbility = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a mini duck");
    }
}
