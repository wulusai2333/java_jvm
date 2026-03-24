package net.wulusai.designpattern.command.control;

public class Light {
    String location;

    public Light(String location) {
        this.location = location;
        System.out.println("Light is " + location);
    }

    public void on() {
        System.out.println(location + " Light is on");
    }

    public void off() {
        System.out.println(location + " Light is off");
    }
}
