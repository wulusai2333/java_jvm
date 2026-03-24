package net.wulusai.designpattern.command;

/**
 * 接收者
 */
public class Receiver {
    public void action() {
        System.out.println("Receiver: 执行操作");
    }
    
    public void undoAction() {
        System.out.println("Receiver: 撤销操作");
    }
}
