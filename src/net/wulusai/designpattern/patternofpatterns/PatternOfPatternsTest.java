package net.wulusai.designpattern.patternofpatterns;

/**
 * PatternOfPatternsTest - 测试类
 * 演示MVC架构中多个设计模式的组合使用
 * 
 * 组合的设计模式：
 * 1. 观察者模式 - 模型通知视图更新
 * 2. 策略模式 - 控制器作为视图的策略
 * 3. 组合模式 - 统一的Controller接口
 * 4. 适配器模式 - HeartAdapter适配不同模型
 * 5. MVC架构 - Model-View-Controller分离
 */
public class PatternOfPatternsTest {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  设计模式的模式 - MVC架构示例");
        System.out.println("========================================\n");

        // 示例1: DJ节拍器
        System.out.println("【示例1】DJ节拍器控制系统");
        System.out.println("----------------------------------------");
        BeatModelInterface beatModel = new BeatModel();
        beatModel.initialize();
        ControllerInterface djController = new BeatController(beatModel);
        
        // 模拟用户操作
        System.out.println("\n>>> 用户操作: 启动节拍器");
        djController.start();
        
        try {
            Thread.sleep(3000); // 运行3秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n>>> 用户操作: 增加BPM");
        djController.increaseBPM();
        djController.increaseBPM();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n>>> 用户操作: 设置BPM为120");
        djController.setBPM(120);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n>>> 用户操作: 停止节拍器");
        djController.stop();
        
        System.out.println("\n\n");

        // 示例2: 心跳监测器
        System.out.println("【示例2】心跳监测系统");
        System.out.println("----------------------------------------");
        HeartModelInterface heartModel = new HeartModel();
        ControllerInterface heartController = new HeartController(heartModel);
        
        // 模拟用户操作
        System.out.println("\n>>> 用户操作: 启动心跳监测");
        heartController.start();
        
        try {
            Thread.sleep(4000); // 运行4秒
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n>>> 用户操作: 尝试手动控制心率");
        heartController.increaseBPM();
        heartController.decreaseBPM();
        
        System.out.println("\n>>> 用户操作: 停止心跳监测");
        heartController.stop();
        
        System.out.println("\n========================================");
        System.out.println("  测试完成");
        System.out.println("========================================");
        System.out.println("\n使用的設計模式:");
        System.out.println("1. 观察者模式 - 模型变化通知视图");
        System.out.println("2. 策略模式 - 控制器作为视图的行为策略");
        System.out.println("3. 组合模式 - 统一的Controller接口");
        System.out.println("4. 适配器模式 - 适配不同的模型接口");
        System.out.println("5. MVC架构 - 分离关注点");
    }
}
