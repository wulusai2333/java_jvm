package net.wulusai.designpattern.facade;

/**
 * 功放
 */
public class Amplifier {
    
    public void on() {
        System.out.println("Amplifier.on()");
    }
    
    public void off() {
        System.out.println("Amplifier.off()");
    }
    
    public void setVolume(int level) {
        System.out.println("Amplifier.setVolume(" + level + ")");
    }
    
    public void setCd(CdPlayer cd) {
        System.out.println("Amplifier.setCd()");
    }
    
    public void setDvd(DvdPlayer dvd) {
        System.out.println("Amplifier.setDvd()");
    }
    
    public void setTuner(Tuner tuner) {
        System.out.println("Amplifier.setTuner()");
    }
}
