package net.wulusai.designpattern.iterator;

/**
 * 集合接口
 */
public interface Collection {
    Iterator createIterator();
    void add(Object item);
}
