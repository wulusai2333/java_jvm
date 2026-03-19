package net.wulusai.designpattern.singleton;

/**
 * Service B - 依赖 Service A（形成循环依赖）
 */
public class ServiceB implements InitializingBean {
    
    private ServiceA serviceA;
    
    public ServiceB() {
        System.out.println("  [ServiceB] 构造函数执行");
    }
    
    public void setServiceA(ServiceA serviceA) {
        System.out.println("  [ServiceB] 注入 ServiceA");
        this.serviceA = serviceA;
    }
    
    public ServiceA getServiceA() {
        return serviceA;
    }
    
    @Override
    public void afterPropertiesSet() {
        System.out.println("  [ServiceB] 初始化完成");
    }
    
    public void doSomething() {
        System.out.println("[ServiceB] 执行业务逻辑");
        if (serviceA != null) {
            serviceA.doSomething();
        }
    }
}
