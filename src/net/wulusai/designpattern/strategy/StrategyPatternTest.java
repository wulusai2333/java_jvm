package net.wulusai.designpattern.strategy;

import net.wulusai.designpattern.strategy.able.impl.fly.FlyNoWay;
import net.wulusai.designpattern.strategy.able.impl.fly.FlyRocketPowered;
import net.wulusai.designpattern.strategy.able.impl.fly.FlyWithWings;
import net.wulusai.designpattern.strategy.able.impl.quack.MuteQuack;
import net.wulusai.designpattern.strategy.able.impl.quack.Quack;
import net.wulusai.designpattern.strategy.able.impl.quack.Squeak;
import net.wulusai.designpattern.strategy.model.Duck;
import net.wulusai.designpattern.strategy.service.impl.ModelDuck;
import net.wulusai.designpattern.strategy.service.impl.RedHeadDuck;
import net.wulusai.designpattern.strategy.service.impl.RubberDuck;

/**
 * 策略模式测试类
 * 演示 Head First设计模式中的策略模式实现
 * 准备一组算法，并将每一个算法封装起来，使得它们可以互换
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        System.out.println("========== 策略模式测试 ==========\n");

        // 测试不同类型的鸭子
        testDifferentDucks();

        System.out.println("\n========== 动态改变行为 ==========\n");

        // 测试动态改变鸭子的行为
        testDynamicBehaviorChange();

        System.out.println("\n========== 测试所有飞行策略 ==========");

        // 测试所有飞行策略
        testAllFlyStrategies();

        System.out.println("\n========== 测试所有叫声策略 ==========");

        // 测试所有叫声策略
        testAllQuackStrategies();

        System.out.println("\n========== 测试完成 ==========");
    }

    /**
     * 测试不同类型的鸭子
     */
    private static void testDifferentDucks() {
        System.out.println("--- 测试不同类型的鸭子 ---\n");

        // 红头鸭
        Duck redHeadDuck = new RedHeadDuck();
        System.out.println("[红头鸭]");
        redHeadDuck.display();
        redHeadDuck.swim();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();

        System.out.println();

        // 橡皮鸭
        Duck rubberDuck = new RubberDuck();
        System.out.println("[橡皮鸭]");
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.performFly();
        rubberDuck.performQuack();

        System.out.println();

        // 模型鸭
        Duck modelDuck = new ModelDuck();
        System.out.println("[模型鸭]");
        modelDuck.display();
        modelDuck.swim();
        modelDuck.performFly();
        modelDuck.performQuack();
    }

    /**
     * 测试动态改变行为
     */
    private static void testDynamicBehaviorChange() {
        System.out.println("--- 测试动态改变鸭子的行为 ---\n");

        // 创建一只模型鸭
        Duck modelDuck = new ModelDuck();
        System.out.println("初始状态:");
        modelDuck.display();
        System.out.print("飞行能力：");
        modelDuck.performFly();
        System.out.print("叫声能力：");
        modelDuck.performQuack();

        System.out.println("\n>>> 为模型鸭添加火箭推进飞行能力...");
        modelDuck.setFlyAbility(new FlyRocketPowered());
        System.out.print("新的飞行能力：");
        modelDuck.performFly();

        System.out.println("\n>>> 为模型鸭添加呱呱叫能力...");
        modelDuck.setQuackAbility(new Quack());
        System.out.print("新的叫声能力：");
        modelDuck.performQuack();

        System.out.println("\n>>> 让模型鸭不会叫...");
        modelDuck.setQuackAbility(new MuteQuack());
        System.out.print("新的叫声能力：");
        modelDuck.performQuack();
    }

    /**
     * 测试所有可用的飞行策略
     */
    private static void testAllFlyStrategies() {
        System.out.println("\n--- 测试所有飞行策略 ---\n");

        Duck testDuck = new Duck();

        System.out.println("1. 使用翅膀飞行:");
        testDuck.setFlyAbility(new FlyWithWings());
        testDuck.performFly();

        System.out.println("\n2. 不能飞行:");
        testDuck.setFlyAbility(new FlyNoWay());
        testDuck.performFly();

        System.out.println("\n3. 火箭推进飞行:");
        testDuck.setFlyAbility(new FlyRocketPowered());
        testDuck.performFly();
    }

    /**
     * 测试所有可用的叫声策略
     */
    private static void testAllQuackStrategies() {
        System.out.println("\n--- 测试所有叫声策略 ---\n");

        Duck testDuck = new Duck();

        System.out.println("1. 呱呱叫:");
        testDuck.setQuackAbility(new Quack());
        testDuck.performQuack();

        System.out.println("\n2. 吱吱叫:");
        testDuck.setQuackAbility(new Squeak());
        testDuck.performQuack();

        System.out.println("\n3. 不会叫:");
        testDuck.setQuackAbility(new MuteQuack());
        testDuck.performQuack();
    }
}
