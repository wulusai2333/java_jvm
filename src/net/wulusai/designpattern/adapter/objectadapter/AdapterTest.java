package net.wulusai.designpattern.adapter.objectadapter;

import java.util.Collections;
import java.util.Enumeration;

/**
 * 适配器测试 别名为包装器(Wrapper)
 */
public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("=== 测试对象适配器 EnumerationIterator ===");
        Enumeration enumeration = Collections.emptyEnumeration();
        EnumerationIterator enumerationIterator = new EnumerationIterator(enumeration);
        enumerationIterator.hasNext();
        try {
            enumerationIterator.next();
        } catch (Exception e) {
            System.out.println("没有下一个元素了");
        }
        try {
            enumerationIterator.remove();
        } catch (Exception e) {
            System.out.println("不支持的功能");
        }

        System.out.println("=== 测试类适配器 EnumerationIteratorAdapter ===");

    }
}
