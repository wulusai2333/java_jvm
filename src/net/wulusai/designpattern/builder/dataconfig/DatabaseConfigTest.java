package net.wulusai.designpattern.builder.dataconfig;

/**
 * 链式调用建造者模式测试类
 * 演示如何使用带链式调用的建造者模式创建DatabaseConfig对象
 * 
 * 链式调用建造者模式的优点：
 * 1. 代码可读性强，配置清晰
 * 2. 支持可选参数，无需多个构造函数
 * 3. 不可变对象，线程安全
 * 4. 编译时类型检查
 * 5. 可以设置默认值
 */
public class DatabaseConfigTest {
    
    /**
     * 主方法：测试链式调用建造者模式
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        
        System.out.println("========== 示例1: 使用默认配置 ==========");
        // 只设置必填参数，其他使用默认值
        DatabaseConfig config1 = new DatabaseConfig.Builder("localhost", 3306)
                .build();
        config1.showConfig();
        
        System.out.println("\n========== 示例2: 自定义部分配置 ==========");
        // 链式调用设置部分参数
        DatabaseConfig config2 = new DatabaseConfig.Builder("192.168.1.100", 3306)
                .username("admin")
                .password("123456")
                .databaseName("mydb")
                .build();
        config2.showConfig();
        
        System.out.println("\n========== 示例3: 完整配置 ==========");
        // 链式调用设置所有参数
        DatabaseConfig config3 = new DatabaseConfig.Builder("192.168.1.200", 5432)
                .username("postgres")
                .password("secure_password")
                .databaseName("production_db")
                .maxConnections(100)
                .timeout(10000)
                .useSSL(true)
                .charset("UTF-8")
                .autoReconnect(true)
                .build();
        config3.showConfig();
        
        System.out.println("\n========== 示例4: 开发环境配置 ==========");
        DatabaseConfig devConfig = new DatabaseConfig.Builder("dev-server.local", 3306)
                .username("dev_user")
                .password("dev_pass")
                .databaseName("dev_database")
                .maxConnections(5)
                .timeout(3000)
                .useSSL(false)
                .build();
        devConfig.showConfig();
        
        System.out.println("\n========== 示例5: 生产环境配置 ==========");
        DatabaseConfig prodConfig = new DatabaseConfig.Builder("prod-db.example.com", 3306)
                .username("prod_user")
                .password("strong_password_123")
                .databaseName("prod_database")
                .maxConnections(200)
                .timeout(15000)
                .useSSL(true)
                .charset("UTF-8")
                .autoReconnect(true)
                .build();
        prodConfig.showConfig();
        
        System.out.println("\n========== 示例6: 验证参数校验 ==========");
        try {
            // 测试非法参数校验
            DatabaseConfig invalidConfig = new DatabaseConfig.Builder("localhost", 3306)
                    .maxConnections(-1)  // 这会抛出异常
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("捕获到异常: " + e.getMessage());
        }
    }
}
