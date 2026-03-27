package net.wulusai.designpattern.facade;

/**
 * 剧院灯光
 */
public class TheaterLights {
    
    public void on() {
        System.out.println("TheaterLights.on()");
    }
    
    public void off() {
        System.out.println("TheaterLights.off()");
    }
    
    public void dim(int level) {
        System.out.println("TheaterLights.dim(" + level + ")");
    }
}
