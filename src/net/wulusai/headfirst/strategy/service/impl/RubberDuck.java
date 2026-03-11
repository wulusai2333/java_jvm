package net.wulusai.headfirst.strategy.service.impl;

import net.wulusai.headfirst.strategy.able.impl.fly.FlyNoWay;
import net.wulusai.headfirst.strategy.able.impl.quack.Squeak;
import net.wulusai.headfirst.strategy.model.Duck;

public class RubberDuck extends Duck {
    public RubberDuck() {
        this.flyAbility = new FlyNoWay();
        this.quackAbility = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a rubber duck");
    }
}
