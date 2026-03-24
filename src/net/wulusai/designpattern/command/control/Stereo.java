package net.wulusai.designpattern.command.control;

/**
 * 音响
 */
public class Stereo {
    String location;
    Stereo(String location) {
        this.location = location;
    }
    public void on() {
        System.out.println(location + " Stereo on");
    }

    public void off() {
        System.out.println(location + " Stereo off");
    }

    public void setCd() {
        System.out.println(location + " Stereo setCd");
    }

    public void setDVD() {
        System.out.println(location + " Stereo setDVD");
    }

    public void setVolume(int volume) {
        System.out.println(location + " Stereo setVolume " + volume);
    }
}
