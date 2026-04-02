package net.wulusai.designpattern.composite;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * 组合迭代器 - 用于遍历组合结构中的所有元素
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    private Iterator<MenuComponent> iterator;
    private int position = 0;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (iterator == null || !iterator.hasNext()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuComponent next() {
        MenuComponent menuComponent = iterator.next();
        position++;
        return menuComponent;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
