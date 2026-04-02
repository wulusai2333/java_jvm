package net.wulusai.designpattern.iterator;

/**
 * 迭代器模式测试类
 * 迭代器模式:提供一种方法顺序访问聚合对象中的各个元素，而又不暴露其内部表示
 */
public class IteratorPatternTest {
    public static void main(String[] args) {
        // 创建两个菜单
        Collection pancakeHouseMenu = new PancakeHouseMenu();
        Collection dinerMenu = new DinerMenu();

        // 创建女招待，传入两个菜单
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);

        // 打印所有菜单
        System.out.println("====== 打印所有菜单 ======");
        waitress.printMenu();

        // 打印素食菜单
        System.out.println("\n====== 打印素食菜单 ======");
        waitress.printVegetarianMenu();
    }
}
