package net.wulusai.designpattern.decorator;

import net.wulusai.designpattern.decorator.component.Beverage;
import net.wulusai.designpattern.decorator.component.DarkRoast;
import net.wulusai.designpattern.decorator.component.Espresso;
import net.wulusai.designpattern.decorator.component.HouseBlend;
import net.wulusai.designpattern.decorator.decorator.Mocha;
import net.wulusai.designpattern.decorator.decorator.Soy;
import net.wulusai.designpattern.decorator.decorator.Whip;

/**
 * 装饰者模式是一种结构型设计模式，允许动态地向对象添加额外的职责
 * 组合优于继承，运行时动态添加职责
 * 测试类，测试装饰器模式，星巴兹咖啡
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
            + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
            + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()
            + " $" + beverage3.cost());

        Beverage beverage4 = new HouseBlend();
        beverage4 = new Soy(beverage4);
        beverage4 = new Whip(beverage4);
        System.out.println(beverage4.getDescription()
            + " $" + beverage4.cost());
    }
}
