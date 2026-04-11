package net.wulusai.designpattern.builder;

/**
 * 建造者模式测试类
 * 演示如何使用建造者模式创建不同类型的房屋
 * 
 * 建造者模式：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * 
 * 使用条件：
 * 1. 需要创建复杂对象
 * 2. 对象的构建过程需要分步骤进行
 * 3. 相同的构建过程可以有不同的表示
 * 
 * 优点：
 * - 封装性好，客户端不必知道产品内部组成的细节
 * - 建造者独立，易于扩展
 * - 便于控制细节风险
 */
public class BuilderPatternTest {
    
    /**
     * 主方法：测试建造者模式
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建指挥者
        Director director = new Director();
        
        System.out.println("========== 建造普通房屋 ==========");
        // 使用普通房屋建造者
        Builder builder1 = new ConcreteBuilder1();
        director.setBuilder(builder1);
        Product product1 = director.construct();
        product1.show();
        
        System.out.println("\n========== 建造豪华房屋 ==========");
        // 使用豪华房屋建造者
        Builder builder2 = new ConcreteBuilder2();
        director.setBuilder(builder2);
        Product product2 = director.construct();
        product2.show();
        
        System.out.println("\n========== 再次建造普通房屋 ==========");
        // 重新使用普通房屋建造者，展示复用性
        Builder builder3 = new ConcreteBuilder1();
        director.setBuilder(builder3);
        Product product3 = director.construct();
        product3.show();
    }
}
