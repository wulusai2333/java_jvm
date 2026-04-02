package net.wulusai.designpattern.iterator;

/**
 * 餐厅菜单 - 使用数组存储菜单项
 */
public class DinerMenu implements Collection {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog", "A hot dog, with sauerkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    @Override
    public void add(Object item) {
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else if (item instanceof MenuItem) {
            menuItems[numberOfItems] = (MenuItem) item;
            numberOfItems++;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }

    /**
     * 内部类：餐厅菜单迭代器
     */
    private class DinerMenuIterator implements Iterator {
        private MenuItem[] items;
        private int position = 0;

        public DinerMenuIterator(MenuItem[] items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            if (position >= items.length || items[position] == null) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Object next() {
            MenuItem menuItem = items[position];
            position++;
            return menuItem;
        }
    }
}
