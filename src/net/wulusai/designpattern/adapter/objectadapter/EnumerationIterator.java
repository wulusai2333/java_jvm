package net.wulusai.designpattern.adapter.objectadapter;


import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 枚举迭代器
 * 对象适配器模式: 使用组合关系适配对象实例
 */
public class EnumerationIterator implements Iterator {
    Enumeration enumeration;
    EnumerationIterator(Enumeration enumeration){
        this.enumeration=enumeration;
    }
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException();
    }
}
