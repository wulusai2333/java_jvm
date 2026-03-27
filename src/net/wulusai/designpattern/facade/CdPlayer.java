package net.wulusai.designpattern.facade;

/**
 * CD 播放器
 */
public class CdPlayer {
    
    public void on() {
        System.out.println("CdPlayer.on()");
    }
    
    public void off() {
        System.out.println("CdPlayer.off()");
    }
    
    public void play(String music) {
        System.out.println("CdPlayer.play(\"" + music + "\")");
    }
    
    public void stop() {
        System.out.println("CdPlayer.stop()");
    }
    
    public void pause() {
        System.out.println("CdPlayer.pause()");
    }
}
