package net.wulusai.designpattern.singleton;

/**
 * Bean 工厂接口
 * 用于创建 Bean 实例
 */
@FunctionalInterface
public interface ObjectFactory<T> {
    T getObject();
}
