package net.wulusai.designpattern.bridge;

/**
 * 桥接模式测试类
 * 演示如何使用桥接模式将遥控器（抽象）与电视（实现）分离
 * 
 * 桥接模式的优点：
 * 1. 分离抽象部分和实现部分，使它们可以独立变化
 * 2. 提高系统的可扩展性，新增遥控器或电视品牌无需修改现有代码
 * 3. 实现细节对客户透明
 * 4. 避免使用继承导致类爆炸
 */
public class BridgePatternTest {
    
    /**
     * 主方法：测试桥接模式
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        
        System.out.println("========== 示例1: 基础遥控器控制LG电视 ==========");
        // 创建LG电视（具体实现）
        Implementor lgTV = new ConcreteImplementorA();
        // 创建基础遥控器（抽象），传入LG电视
        Abstraction basicRemote = new Abstraction(lgTV) {};
        
        basicRemote.turnOn();
        basicRemote.setChannel(5);
        System.out.println(basicRemote.getStatus());
        basicRemote.turnOff();
        
        System.out.println("\n========== 示例2: 基础遥控器控制Sony电视 ==========");
        // 创建Sony电视（具体实现）
        Implementor sonyTV = new ConcreteImplementorB();
        // 同一个基础遥控器可以控制不同品牌的电视
        Abstraction basicRemote2 = new Abstraction(sonyTV) {};
        
        basicRemote2.turnOn();
        basicRemote2.setChannel(10);
        System.out.println(basicRemote2.getStatus());
        basicRemote2.turnOff();
        
        System.out.println("\n========== 示例3: 高级遥控器控制LG电视 ==========");
        // 高级遥控器控制LG电视
        RefinedAbstraction advancedRemote1 = new RefinedAbstraction(lgTV);
        
        advancedRemote1.turnOn();
        advancedRemote1.setChannel(8);
        advancedRemote1.favoriteChannel(8);
        advancedRemote1.mute();
        advancedRemote1.displayInfo();
        advancedRemote1.turnOff();
        
        System.out.println("\n========== 示例4: 高级遥控器控制Sony电视 ==========");
        // 高级遥控器控制Sony电视
        RefinedAbstraction advancedRemote2 = new RefinedAbstraction(sonyTV);
        
        advancedRemote2.turnOn();
        advancedRemote2.setChannel(15);
        advancedRemote2.favoriteChannel(15);
        
        // Sony电视特有功能：调节音量（需要类型转换）
        if (advancedRemote2.implementor instanceof ConcreteImplementorB) {
            ConcreteImplementorB sonyImpl = (ConcreteImplementorB) advancedRemote2.implementor;
            sonyImpl.setVolume(80);
        }
        
        advancedRemote2.displayInfo();
        advancedRemote2.turnOff();
        
        System.out.println("\n========== 示例5: 动态切换电视 ==========");
        // 同一个遥控器可以在运行时切换到不同的电视
        RefinedAbstraction universalRemote = new RefinedAbstraction(lgTV);
        universalRemote.turnOn();
        System.out.println("当前控制: " + universalRemote.getStatus());
        
        // 切换到Sony电视
        universalRemote.implementor = sonyTV;
        System.out.println("切换后控制: " + universalRemote.getStatus());
        universalRemote.turnOff();
    }
}
