package net.wulusai.designpattern.iterator;

import java.util.ArrayList;

/**
 * 煎饼屋菜单 - 使用 ArrayList 存储菜单项
 */
public class PancakeHouseMenu implements Collection {
    private ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        
        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    @Override
    public void add(Object item) {
        if (item instanceof MenuItem) {
            menuItems.add((MenuItem) item);
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        return new PancakeHouseIterator(menuItems);
    }

    /**
     * 内部类：煎饼屋菜单迭代器
     */
    private class PancakeHouseIterator implements Iterator {
        private ArrayList<MenuItem> items;
        private int position = 0;

        public PancakeHouseIterator(ArrayList<MenuItem> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            if (position >= items.size()) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Object next() {
            MenuItem menuItem = items.get(position);
            position++;
            return menuItem;
        }
    }
}
