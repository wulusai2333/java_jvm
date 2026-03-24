package net.wulusai.designpattern.command;

/**
 * 具体命令类
 */
public class ConcreteCommand implements Command {
    
    private Receiver receiver;
    
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("ConcreteCommand: 执行命令");
        receiver.action();
    }
    
    @Override
    public void undo() {
        System.out.println("ConcreteCommand: 撤销命令");
        receiver.undoAction();
    }
}
