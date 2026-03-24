package net.wulusai.designpattern.command.control;

public class RemoteLoaderForCeilingFan {
    public static void main(String[] args) {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        remote.setCommand(0, ceilingFanHigh, ceilingFanOff);
        remote.setCommand(1, ceilingFanMedium, ceilingFanOff);
        remote.setCommand(2, ceilingFanLow, ceilingFanOff);
        remote.setCommand(3, ceilingFanOff, ceilingFanOff);
        System.out.println(remote);

        remote.onButtonWasPushed(0);
        remote.offButtonWasPushed(0);
        System.out.println(remote);
        remote.undoButtonWasPushed();

        remote.onButtonWasPushed(1);
        System.out.println(remote);
        remote.undoButtonWasPushed();
    }
}
