package net.wulusai.headfirst.strategy.service;

import net.wulusai.headfirst.strategy.able.FlyAble;
import net.wulusai.headfirst.strategy.able.QuackAble;
import net.wulusai.headfirst.strategy.able.impl.fly.FlyNoWay;
import net.wulusai.headfirst.strategy.able.impl.fly.FlyRocketPowered;
import net.wulusai.headfirst.strategy.able.impl.fly.FlyWithWings;
import net.wulusai.headfirst.strategy.able.impl.quack.MuteQuack;
import net.wulusai.headfirst.strategy.able.impl.quack.Quack;
import net.wulusai.headfirst.strategy.able.impl.quack.Squeak;
import net.wulusai.headfirst.strategy.model.Duck;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 封装复杂性
 * 隐藏鸭子创建和配置的细节
 * 提供简洁的API给客户端使用
 * 2. 集中管理
 * 统一管理所有鸭子的生命周期
 * 统一配置行为策略
 * 3. 提供工厂功能
 * 封装具体类的实例化
 * 支持依赖注入
 */
public class DuckService {
    /**
     * duck registry
     */
    private Map<String, Duck> duckRegistry = new HashMap<>();

    /**
     * register duck
     */
    public void registerDuck(String name, Duck duck) {
        duckRegistry.put(name, duck);
    }

    /**
     * get duck with name
     */
    public Duck getDuck(String name) {
        return duckRegistry.get(name);
    }

    /**
     * set ability for all ducks
     */
    public void setAbilityForAllDuck(QuackAble quackAble, FlyAble flyAble) {
        for (Duck duck : duckRegistry.values()) {
            duck.setQuackAbility(quackAble);
            duck.setFlyAbility(flyAble);
        }
    }

    /**
     * create fly ability by name
     */
    public FlyAble createFlyAble(String flyAbleName) {
        switch (flyAbleName) {
            case "flyWithWings":
                return new FlyWithWings();
            case "flyNoWay":
                return new FlyNoWay();
            case "flyRocketPowered":
                return new FlyRocketPowered();
            default:
                return new FlyNoWay();
        }
    }

    /**
     * create quack ability by name
     */
    public QuackAble createQuackAble(String quackAbleName) {
        switch (quackAbleName) {
            case "quack":
                return new Quack();
            case "squeak":
                return new Squeak();
            case "muteQuack":
                return new MuteQuack();
            default:
                return new MuteQuack();
        }
    }

    /**
     * create standard duck with flyWithWings and quack behavior
     */
    public Duck createStandardDuck() {
        Duck duck = new Duck();
        duck.setFlyAbility(new FlyWithWings());
        duck.setQuackAbility(new Quack());
        return duck;
    }

    /**
     * create toy duck with flyNoWay and muteQuack behavior
     */
    public Duck createToyDuck() {
        Duck duck = new Duck();
        duck.setFlyAbility(new FlyNoWay());
        duck.setQuackAbility(new MuteQuack());
        return duck;
    }

}

