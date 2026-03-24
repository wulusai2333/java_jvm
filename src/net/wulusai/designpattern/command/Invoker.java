package net.wulusai.designpattern.command;

/**
 * 命令调用者
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void action() {
        System.out.println("Invoker: 调用命令");
        if (command != null) {
            command.execute();
        }
    }
    
    public void undo() {
        System.out.println("Invoker: 撤销命令");
        if (command != null) {
            command.undo();
        }
    }
}
