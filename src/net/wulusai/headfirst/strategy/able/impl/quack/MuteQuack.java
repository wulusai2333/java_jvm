package net.wulusai.headfirst.strategy.able.impl.quack;

import net.wulusai.headfirst.strategy.able.QuackAble;

public class MuteQuack implements QuackAble {
    @Override
    public void quack() {
        System.out.println("Mute");
    }
}
