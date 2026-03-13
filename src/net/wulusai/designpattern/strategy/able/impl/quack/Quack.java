package net.wulusai.designpattern.strategy.able.impl.quack;

import net.wulusai.designpattern.strategy.able.QuackAble;

public class Quack implements QuackAble {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
