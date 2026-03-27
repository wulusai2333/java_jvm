package net.wulusai.designpattern.facade;

/**
 * 爆米花机
 */
public class PopcornPopper {
    
    public void on() {
        System.out.println("PopcornPopper.on()");
    }
    
    public void off() {
        System.out.println("PopcornPopper.off()");
    }
    
    public void makePopcorn() {
        System.out.println("PopcornPopper.makePopcorn()");
    }
}
