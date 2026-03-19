package net.wulusai.designpattern.singleton;

/**
 * Service A - 依赖 Service B
 */
public class ServiceA implements InitializingBean {
    
    private ServiceB serviceB;
    
    public ServiceA() {
        System.out.println("  [ServiceA] 构造函数执行");
    }
    
    public void setServiceB(ServiceB serviceB) {
        System.out.println("  [ServiceA] 注入 ServiceB");
        this.serviceB = serviceB;
    }
    
    public ServiceB getServiceB() {
        return serviceB;
    }
    
    @Override
    public void afterPropertiesSet() {
        System.out.println("  [ServiceA] 初始化完成");
    }
    
    public void doSomething() {
        System.out.println("[ServiceA] 执行业务逻辑");
        if (serviceB != null) {
            serviceB.doSomething();
        }
    }
}
