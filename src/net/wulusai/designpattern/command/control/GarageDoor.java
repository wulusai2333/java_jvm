package net.wulusai.designpattern.command.control;

/**
 * 车库门
 */
public class GarageDoor {
    String location;
    public GarageDoor(String location) {
        this.location = location;
    }
    public void up() {
        System.out.println(location + " GarageDoor up");
    }

    public void down() {
        System.out.println(location + " GarageDoor down");
    }
}