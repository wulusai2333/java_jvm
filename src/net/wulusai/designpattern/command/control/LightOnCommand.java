package net.wulusai.designpattern.command.control;

import net.wulusai.designpattern.command.Command;

/**
 * 灯开命令
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
