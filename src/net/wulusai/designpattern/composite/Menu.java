package net.wulusai.designpattern.composite;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * 菜单 - 组合节点（可以包含子组件）
 */
public class Menu extends MenuComponent {
    private String name;
    private String description;
    private ArrayList<MenuComponent> menuComponents;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        this.menuComponents = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int position) {
        return menuComponents.get(position);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        
        // 遍历子组件并打印
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
