package net.wulusai.designpattern.strategy.service.impl;

import net.wulusai.designpattern.strategy.able.impl.fly.FlyNoWay;
import net.wulusai.designpattern.strategy.able.impl.quack.Squeak;
import net.wulusai.designpattern.strategy.model.Duck;

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
