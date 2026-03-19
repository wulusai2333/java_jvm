package net.wulusai.designpattern.singleton;

/**
 * 初始化 Bean 接口
 * 模仿 Spring 的 InitializingBean
 */
public interface InitializingBean {
    /**
     * 在属性设置完成后执行
     */
    void afterPropertiesSet();
}
