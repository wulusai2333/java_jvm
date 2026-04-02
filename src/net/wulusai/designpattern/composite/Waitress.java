package net.wulusai.designpattern.composite;

import java.util.Iterator;

/**
 * 女招待 - 使用组合模式处理菜单
 */
public class Waitress {
    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /**
     * 打印所有菜单
     */
    public void printMenu() {
        allMenus.print();
    }

    /**
     * 打印素食菜单
     */
    public void printVegetarianMenu() {
        System.out.println("\nVEGETARIAN MENU");
        System.out.println("---------------------");
        printVegetarianMenu(allMenus);
    }
    
    /**
     * 递归打印素食菜单项
     * @param menuComponent 菜单组件
     */
    private void printVegetarianMenu(MenuComponent menuComponent) {
        try {
            // 如果是 MenuItem，检查是否是素食
            if (menuComponent.isVegetarian()) {
                System.out.print("  " + menuComponent.getName());
                System.out.println(", $" + menuComponent.getPrice());
                System.out.println("     -- " + menuComponent.getDescription());
            }
        } catch (UnsupportedOperationException e) {
            // 如果是 Menu，递归处理其子组件
            Iterator<MenuComponent> iterator = menuComponent.createIterator();
            while (iterator.hasNext()) {
                printVegetarianMenu(iterator.next());
            }
        }
    }
}
