package net.wulusai.designpattern.strategy.service.impl;

import net.wulusai.designpattern.strategy.able.impl.fly.FlyNoWay;
import net.wulusai.designpattern.strategy.able.impl.quack.MuteQuack;
import net.wulusai.designpattern.strategy.model.Duck;

public class ModelDuck extends Duck {
    public ModelDuck() {
        this.flyAbility = new FlyNoWay();
        this.quackAbility = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}

