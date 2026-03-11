package net.wulusai.headfirst.strategy.able.impl.quack;

import net.wulusai.headfirst.strategy.able.QuackAble;

public class Squeak implements QuackAble {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
