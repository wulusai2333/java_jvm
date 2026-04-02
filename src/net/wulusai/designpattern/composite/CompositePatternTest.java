package net.wulusai.designpattern.composite;

/**
 * 组合模式测试类
 * 组合模式：允许你将对象组合成树形结构来表现"整体/部分"的层次结构
 * 组合模式能让客户以一致的方式处理个别对象以及组合对象
 */
public class CompositePatternTest {
    public static void main(String[] args) {
        // 创建顶层菜单 - 所有菜单
        MenuComponent allMenus = new Menu("All Menus", "All menus combined");

        // 创建早餐菜单
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        pancakeHouseMenu.add(new MenuItem(
            "K&B's Pancake Breakfast",
            "Pancakes with scrambled eggs, and toast",
            true,
            2.99));
        pancakeHouseMenu.add(new MenuItem(
            "Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage",
            false,
            2.99));
        pancakeHouseMenu.add(new MenuItem(
            "Blueberry Pancakes",
            "Pancakes made with fresh blueberries",
            true,
            3.49));

        // 创建午餐菜单
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        dinerMenu.add(new MenuItem(
            "Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat",
            true,
            2.99));
        dinerMenu.add(new MenuItem(
            "BLT",
            "Bacon with lettuce & tomato on whole wheat",
            false,
            2.99));
        dinerMenu.add(new MenuItem(
            "Soup of the day",
            "Soup of the day, with a side of potato salad",
            false,
            3.29));

        // 创建晚餐菜单
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        cafeMenu.add(new MenuItem(
            "Veggie Burger and Air Fries",
            "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
            true,
            3.99));
        cafeMenu.add(new MenuItem(
            "Soup of the day",
            "A cup of the soup of the day, with a side salad",
            false,
            3.69));
        cafeMenu.add(new MenuItem(
            "Burrito",
            "A large burrito, with whole pinto beans, salsa, guacamole",
            true,
            4.29));

        // 将子菜单添加到顶层菜单
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // 创建女招待并传入组合菜单
        Waitress waitress = new Waitress(allMenus);

        // 打印所有菜单
        System.out.println("====== 打印所有菜单 ======");
        waitress.printMenu();

        // 打印素食菜单
        System.out.println("\n====== 打印素食菜单 ======");
        waitress.printVegetarianMenu();
    }
}
