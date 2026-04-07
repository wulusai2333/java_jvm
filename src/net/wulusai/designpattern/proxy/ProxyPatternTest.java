package net.wulusai.designpattern.proxy;

/**
 * 代理模式测试类
 * 演示 Head First 设计模式中的虚拟代理（Virtual Proxy）实现
 * 
 * 代理模式为：为另一个对象提供一种代理以控制对这个对象的访问。
 * 虚拟代理常用于延迟加载，只有在真正需要时才创建开销大的对象。
 */
public class ProxyPatternTest {
    public static void main(String[] args) {
        System.out.println("========== 代理模式测试 ==========\n");
        
        // 测试1：使用代理图像（延迟加载）
        testProxyImage();
        
        System.out.println("\n================================\n");
        
        // 测试2：对比真实图像和代理图像的性能差异
        testPerformanceComparison();
        
        System.out.println("\n========== 测试完成 ==========");
    }
    
    /**
     * 测试代理图像的延迟加载特性
     */
    private static void testProxyImage() {
        System.out.println("--- 测试代理图像（延迟加载）---\n");
        
        System.out.println("1. 创建代理图像对象（不会立即加载）:");
        Image image1 = new ProxyImage("photo1.jpg");
        System.out.println("   代理对象创建完成\n");
        
        System.out.println("2. 第一次显示图像（触发加载）:");
        image1.display();
        System.out.println();
        
        System.out.println("3. 第二次显示图像（使用缓存，无需重新加载）:");
        image1.display();
        System.out.println();
        
        System.out.println("4. 创建第二个代理图像对象:");
        Image image2 = new ProxyImage("photo2.jpg");
        System.out.println("   代理对象创建完成\n");
        
        System.out.println("5. 显示第二个图像:");
        image2.display();
    }
    
    /**
     * 对比真实图像和代理图像的性能差异
     */
    private static void testPerformanceComparison() {
        System.out.println("--- 性能对比测试 ---\n");
        
        System.out.println("[场景A] 使用真实图像（立即加载）:");
        long startTime1 = System.currentTimeMillis();
        System.out.println("1. 创建真实图像对象:");
        Image realImage1 = new RealImage("document1.jpg");
        Image realImage2 = new RealImage("document2.jpg");
        Image realImage3 = new RealImage("document3.jpg");
        long endTime1 = System.currentTimeMillis();
        System.out.println("   总耗时: " + (endTime1 - startTime1) + " ms\n");
        
        System.out.println("2. 显示第一个文档:");
        realImage1.display();
        System.out.println();
        
        System.out.println("----------------------------------------\n");
        
        System.out.println("[场景B] 使用代理图像（延迟加载）:");
        long startTime2 = System.currentTimeMillis();
        System.out.println("1. 创建代理图像对象:");
        Image proxyImage1 = new ProxyImage("document1.jpg");
        Image proxyImage2 = new ProxyImage("document2.jpg");
        Image proxyImage3 = new ProxyImage("document3.jpg");
        long endTime2 = System.currentTimeMillis();
        System.out.println("   总耗时: " + (endTime2 - startTime2) + " ms");
        System.out.println("   （几乎无耗时，因为只是创建了代理对象）\n");
        
        System.out.println("2. 只显示第一个文档:");
        proxyImage1.display();
        System.out.println();
        
        System.out.println(">>> 性能优势分析:");
        System.out.println("   - 真实图像：创建时立即加载所有图像，即使可能不需要显示");
        System.out.println("   - 代理图像：只在真正需要显示时才加载，节省资源");
        System.out.println("   - 适用场景：图像很大、加载很慢、或可能不需要显示的情况");
    }
}
