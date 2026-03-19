package net.wulusai.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 模仿 Spring Bean的单例容器
 * 使用三级缓存解决循环依赖问题
 * 
 * 一级缓存：singletonObjects - 存放完全初始化好的单例 Bean
 * 二级缓存：earlySingletonObjects - 存放早期的 Bean 引用（未完全初始化）
 * 三级缓存：singletonFactories - 存放 Bean 工厂对象
 */
public class BeanContainer {
    
    /**
     * 一级缓存：存放完全初始化好的单例 Bean
     */
    private final Map<String, Object> singletonObjects = new HashMap<>();
    
    /**
     * 二级缓存：存放早期的 Bean 引用（未完全初始化）
     */
    private final Map<String, Object> earlySingletonObjects = new HashMap<>();
    
    /**
     * 三级缓存：存放 Bean 工厂对象
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();
    
    /**
     * 正在创建的 Bean 集合
     */
    private final Map<String, Boolean> creatingBeans = new HashMap<>();
    
    private static final BeanContainer INSTANCE = new BeanContainer();
    
    private BeanContainer() {
    }
    
    public static BeanContainer getInstance() {
        return INSTANCE;
    }
    
    /**
     * 注册 Bean 定义
     * @param beanName Bean 名称
     * @param factory Bean 工厂
     */
    public void registerBean(String beanName, ObjectFactory<?> factory) {
        singletonFactories.put(beanName, factory);
    }
    
    /**
     * 获取 Bean（支持解决循环依赖）
     * @param beanName Bean 名称
     * @return Bean 实例
     */
    public Object getBean(String beanName) {
        // 1. 尝试从一级缓存获取完全初始化的 Bean
        Object bean = singletonObjects.get(beanName);
        if (bean != null) {
            System.out.println("✓ 从一级缓存获取：" + beanName);
            return bean;
        }
        
        // 2. 尝试从二级缓存获取早期引用
        bean = earlySingletonObjects.get(beanName);
        if (bean != null) {
            System.out.println("✓ 从二级缓存获取早期引用：" + beanName);
            return bean;
        }
        
        // 3. 从三级缓存获取 Bean 工厂并创建 Bean
        ObjectFactory<?> factory = singletonFactories.get(beanName);
        if (factory != null && !isCreating(beanName)) {
            System.out.println("→ 开始创建 Bean: " + beanName);
            bean = createBean(beanName, factory);
        } else if (isCreating(beanName)) {
            System.out.println("⚠ 检测到循环依赖：" + beanName);
            // 循环依赖时返回早期引用
            return earlySingletonObjects.get(beanName);
        }
        
        return bean;
    }
    
    /**
     * 创建 Bean（模拟 Spring 的 doCreateBean）
     * @param beanName Bean 名称
     * @param factory Bean 工厂
     * @return Bean 实例
     */
    @SuppressWarnings("unchecked")
    private Object createBean(String beanName, ObjectFactory<?> factory) {
        // 标记为正在创建
        setCreating(beanName, true);
        
        try {
            // 创建原始 Bean 实例
            Object bean = ((ObjectFactory<Object>) factory).getObject();
            
            // 提前暴露引用，放入二级缓存（解决循环依赖的关键）
            earlySingletonObjects.put(beanName, bean);
            System.out.println("  └─ 提前暴露早期引用到二级缓存：" + beanName);
            
            // 执行属性注入和初始化
            initializeBean(bean, beanName);
            
            // 初始化完成，从二级缓存移到一级缓存
            earlySingletonObjects.remove(beanName);
            singletonObjects.put(beanName, bean);
            System.out.println("  └─ Bean 初始化完成，移入一级缓存：" + beanName);
            
            return bean;
        } finally {
            setCreating(beanName, false);
        }
    }
    
    /**
     * 初始化 Bean（属性注入等）
     * @param bean Bean 实例
     * @param beanName Bean 名称
     */
    private void initializeBean(Object bean, String beanName) {
        System.out.println("  → 执行 Bean 初始化：" + beanName);
        
        // 这里可以添加属性注入逻辑
        // 类似于 Spring 的 populateBean 方法
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
    }
    
    /**
     * 检查 Bean 是否正在创建中
     */
    private boolean isCreating(String beanName) {
        return creatingBeans.containsKey(beanName);
    }
    
    /**
     * 设置 Bean 创建状态
     */
    private void setCreating(String beanName, boolean creating) {
        if (creating) {
            creatingBeans.put(beanName, creating);
        } else {
            creatingBeans.remove(beanName);
        }
    }
    
    /**
     * 清空所有缓存
     */
    public void clear() {
        singletonObjects.clear();
        earlySingletonObjects.clear();
        singletonFactories.clear();
        creatingBeans.clear();
    }
}
