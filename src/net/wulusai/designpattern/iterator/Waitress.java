package net.wulusai.designpattern.iterator;

/**
 * 女招待 - 使用迭代器遍历所有菜单
 */
public class Waitress {
    private Collection pancakeHouseMenu;
    private Collection dinerMenu;

    public Waitress(Collection pancakeHouseMenu, Collection dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    /**
     * 打印所有菜单项
     */
    public void printMenu() {
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }

    /**
     * 使用迭代器打印菜单项
     */
    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    /**
     * 打印素食菜单项
     */
    public void printVegetarianMenu() {
        printVegetarianMenu(pancakeHouseMenu.createIterator());
        printVegetarianMenu(dinerMenu.createIterator());
    }

    /**
     * 使用迭代器打印素食菜单项
     */
    private void printVegetarianMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            if (menuItem.isVegetarian()) {
                System.out.println(menuItem.getName() + "\t$" + menuItem.getPrice());
                System.out.println("   " + menuItem.getDescription());
            }
        }
    }
}
