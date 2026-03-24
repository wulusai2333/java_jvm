package net.wulusai.designpattern.command;

/**
 * 客户端
 * 命令模式: 将命令的发送者和接受者完全解耦
 */
public class Client {
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        
        // 创建具体命令对象，并传入接收者
        Command command = new ConcreteCommand(receiver);
        
        // 创建调用者
        Invoker invoker = new Invoker();
        
        // 设置命令
        invoker.setCommand(command);
        
        // 执行命令
        System.out.println("=== 执行命令 ===");
        invoker.action();
        
        // 撤销命令
        System.out.println("\n=== 撤销命令 ===");
        invoker.undo();
    }
}
