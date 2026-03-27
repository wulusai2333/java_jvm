package net.wulusai.designpattern.facade;

/**
 * DVD 播放器
 */
public class DvdPlayer {
    
    public void on() {
        System.out.println("DvdPlayer.on()");
    }
    
    public void off() {
        System.out.println("DvdPlayer.off()");
    }
    
    public void play(String movie) {
        System.out.println("DvdPlayer.play(\"" + movie + "\")");
    }
    
    public void stop() {
        System.out.println("DvdPlayer.stop()");
    }
    
    public void pause() {
        System.out.println("DvdPlayer.pause()");
    }
    
    public void setTwoChannelAudio() {
        System.out.println("DvdPlayer.setTwoChannelAudio()");
    }
    
    public void setSurroundAudio() {
        System.out.println("DvdPlayer.setSurroundAudio()");
    }
}
