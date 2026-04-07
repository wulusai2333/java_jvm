package net.wulusai.designpattern.state;

/**
 * 状态模式测试类
 * 演示 Head First 设计模式中的状态模式实现
 * 
 * 状态模式：允许一个对象在其内部状态改变时改变它的行为
 * 它将状态封装成独立的类，并将行为委托给当前状态对象
 * 
 * 优点：
 * 1. 将与特定状态相关的行为局部化，并且将不同状态的行为分割开来
 * 2. 通过把各种状态逻辑转移到状态类之间，可以消除庞大的条件分支语句
 * 3. 状态转换显式化，更容易理解和维护
 */
public class StatePatternTest {
    public static void main(String[] args) {
        System.out.println("========== 状态模式测试 ==========\n");

        // 测试 1: 基本的糖果购买流程
        testBasicPurchase();

        // 测试 2: 售完状态测试
        testSoldOutState();

        // 测试 3: 退款操作
        testEjectQuarter();

        // 测试 4: 补货操作
        testRefill();

        // 测试 5: 错误操作处理
        testInvalidOperations();

        System.out.println("\n========== 测试完成 ==========");
    }

    /**
     * 测试基本的糖果购买流程
     */
    private static void testBasicPurchase() {
        System.out.println("--- 测试 1: 基本的糖果购买流程 ---\n");
        
        GumballMachine gumballMachine = new GumballMachine(5);
        gumballMachine.printStatus();
        
        System.out.println(">>> 投入 25 美分...");
        gumballMachine.insertQuarter();
        
        System.out.println(">>> 转动曲柄...");
        gumballMachine.turnCrank();
        
        System.out.println(">>> 再次投入 25 美分并转动曲柄...");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        
        gumballMachine.printStatus();
    }

    /**
     * 测试售完状态
     */
    private static void testSoldOutState() {
        System.out.println("--- 测试 2: 售完状态测试 ---\n");
        
        GumballMachine gumballMachine = new GumballMachine(2);
        
        // 买光所有糖果
        System.out.println(">>> 连续购买直到糖果售完...\n");
        for (int i = 0; i < 2; i++) {
            System.out.println("--- 第 " + (i + 1) + " 次购买 ---");
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
        
        System.out.println(">>> 尝试在售罄状态下投入硬币...");
        gumballMachine.insertQuarter();
        
        System.out.println(">>> 尝试在售罄状态下转动曲柄...");
        gumballMachine.turnCrank();
        
        gumballMachine.printStatus();
    }

    /**
     * 测试退款操作
     */
    private static void testEjectQuarter() {
        System.out.println("--- 测试 3: 退款操作 ---\n");
        
        GumballMachine gumballMachine = new GumballMachine(3);
        
        System.out.println(">>> 投入 25 美分后退款...");
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        
        System.out.println(">>> 没有投币就尝试退款...");
        gumballMachine.ejectQuarter();
        
        System.out.println(">>> 投币、转动曲柄后再尝试退款...");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        
        gumballMachine.printStatus();
    }

    /**
     * 测试补货操作
     */
    private static void testRefill() {
        System.out.println("--- 测试 4: 补货操作 ---\n");
        
        GumballMachine gumballMachine = new GumballMachine(2);
        
        // 买光糖果
        System.out.println(">>> 买光所有糖果...\n");
        for (int i = 0; i < 2; i++) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
        
        System.out.println(">>> 在售罄状态下补货 10 颗糖果...");
        gumballMachine.refill(10);
        
        System.out.println(">>> 补货后购买一颗糖果...");
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        
        gumballMachine.printStatus();
    }

    /**
     * 测试错误操作处理
     */
    private static void testInvalidOperations() {
        System.out.println("--- 测试 5: 错误操作处理 ---\n");
        
        GumballMachine gumballMachine = new GumballMachine(3);
        
        System.out.println(">>> 重复投币...");
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        
        System.out.println("\n>>> 重复转动曲柄...");
        gumballMachine.turnCrank();
        gumballMachine.turnCrank();
        
        System.out.println("\n>>> 在售出状态下投币...");
        // 需要重新创建一个机器来测试
        GumballMachine machine2 = new GumballMachine(1);
        machine2.insertQuarter();
        // 手动触发售出状态（通过转动曲柄）
        machine2.turnCrank();
        // 在售出过程中尝试投币
        machine2.insertQuarter();
        
        gumballMachine.printStatus();
    }
}
