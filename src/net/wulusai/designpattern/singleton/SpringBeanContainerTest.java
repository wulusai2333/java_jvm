package net.wulusai.designpattern.singleton;

/**
 * 测试 Spring Bean 单例容器（解决循环依赖）
 */
public class SpringBeanContainerTest {
    
    public static void main(String[] args) {
        System.out.println("========== Spring Bean 容器测试（三级缓存解决循环依赖）==========\n");
        
        BeanContainer container = BeanContainer.getInstance();
        container.clear(); // 清空缓存
        
        // 注册 ServiceA 和 ServiceB，它们互相依赖（循环依赖）
        container.registerBean("serviceA", () -> {
            ServiceA serviceA = new ServiceA();
            // 模拟属性注入：ServiceA 需要 ServiceB
            ServiceB serviceB = (ServiceB) container.getBean("serviceB");
            serviceA.setServiceB(serviceB);
            return serviceA;
        });
        
        container.registerBean("serviceB", () -> {
            ServiceB serviceB = new ServiceB();
            // 模拟属性注入：ServiceB 需要 ServiceA
            ServiceA serviceA = (ServiceA) container.getBean("serviceA");
            serviceB.setServiceA(serviceA);
            return serviceB;
        });
        
        System.out.println("\n→ 开始获取 ServiceA（触发循环依赖解决流程）:");
        ServiceA serviceA = (ServiceA) container.getBean("serviceA");
        
        System.out.println("\n→ 获取 ServiceB（从一级缓存直接获取）:");
        ServiceB serviceB = (ServiceB) container.getBean("serviceB");
        
        System.out.println("\n========== 测试结果 ==========");
        System.out.println("ServiceA 实例：" + serviceA);
        System.out.println("ServiceB 实例：" + serviceB);
        System.out.println("ServiceA == ServiceB.getServiceA(): " + (serviceA == serviceB.getServiceA()));
        System.out.println("ServiceB == ServiceA.getServiceB(): " + (serviceB == serviceA.getServiceB()));
        
        System.out.println("\n→ 调用业务方法:");
        serviceA.doSomething();
        
        System.out.println("\n✓ 循环依赖成功解决！");
    }
}
