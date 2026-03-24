package net.wulusai.designpattern.command.control;

import net.wulusai.designpattern.command.Command;

/**
 * 灯关命令
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
