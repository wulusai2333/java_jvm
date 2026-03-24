package net.wulusai.designpattern.command.control;

import net.wulusai.designpattern.command.Command;

/**
 * 简单的遥控器
 */
public class SimpleRemoteControl {
    Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    public void undoButtonWasPressed() {
        slot.undo();
    }

}
