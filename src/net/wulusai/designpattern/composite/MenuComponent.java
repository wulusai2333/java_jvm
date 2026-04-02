package net.wulusai.designpattern.composite;

import java.util.Iterator;

/**
 * 菜单组件 - 抽象构件
 */
public abstract class MenuComponent {
    
    /**
     * 添加菜单组件
     * @param menuComponent 要添加的菜单组件
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 移除菜单组件
     * @param menuComponent 要移除的菜单组件
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 获取子组件
     * @param position 位置索引
     * @return 菜单组件
     */
    public MenuComponent getChild(int position) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 获取名称
     * @return 名称
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 获取描述
     * @return 描述
     */
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 获取价格
     * @return 价格
     */
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 是否是素食
     * @return true 表示是素食
     */
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * 打印菜单信息
     */
    public abstract void print();
    
    /**
     * 创建迭代器
     * @return 迭代器
     */
    public Iterator<MenuComponent> createIterator() {
        throw new UnsupportedOperationException();
    }
}
