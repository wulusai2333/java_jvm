package net.wulusai.designpattern.facade;

/**
 * 家庭影院外观类
 * 提供统一的外观接口，简化客户端调用
 */
public class HomeTheaterFacade {
    
    // 持所有子系统组件的引用
    private Amplifier amplifier;
    private CdPlayer cdPlayer;
    private DvdPlayer dvdPlayer;
    private PopcornPopper popcornPopper;
    private Projector projector;
    private Screen screen;
    private TheaterLights theaterLights;
    private Tuner tuner;
    
    // 构造方法，初始化所有子系统
    public HomeTheaterFacade(Amplifier amplifier, 
                            CdPlayer cdPlayer, 
                            DvdPlayer dvdPlayer, 
                            PopcornPopper popcornPopper,
                            Projector projector, 
                            Screen screen, 
                            TheaterLights theaterLights, 
                            Tuner tuner) {
        this.amplifier = amplifier;
        this.cdPlayer = cdPlayer;
        this.dvdPlayer = dvdPlayer;
        this.popcornPopper = popcornPopper;
        this.projector = projector;
        this.screen = screen;
        this.theaterLights = theaterLights;
        this.tuner = tuner;
    }
    
    /**
     * 观看电影的一键操作
     * 封装了多个子系统的复杂操作流程
     */
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popcornPopper.on();
        popcornPopper.makePopcorn();
        theaterLights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setVolume(25);
        amplifier.setDvd(dvdPlayer);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }
    
    /**
     * 结束观影的一键操作
     */
    public void endMovie() {
        System.out.println("Shutting home theater down...");
        popcornPopper.off();
        theaterLights.on();
        screen.up();
        projector.off();
        amplifier.off();
        dvdPlayer.stop();
        dvdPlayer.off();
    }
    
    /**
     * 听音乐模式
     */
    public void listenToCd(String music) {
        System.out.println("Get ready to listen to CD...");
        amplifier.on();
        amplifier.setVolume(20);
        amplifier.setCd(cdPlayer);
        cdPlayer.on();
        cdPlayer.play(music);
    }
    
    /**
     * 停止听音乐
     */
    public void stopCd() {
        System.out.println("Stop listening to CD...");
        cdPlayer.stop();
        cdPlayer.off();
        amplifier.off();
    }
    
    /**
     * 听收音机模式
     */
    public void listenToFm(double frequency) {
        System.out.println("Get ready to listen to FM radio...");
        amplifier.on();
        amplifier.setVolume(15);
        amplifier.setTuner(tuner);
        tuner.on();
        tuner.setFm();
        tuner.setFrequency(frequency);
    }
    
    /**
     * 停止听收音机
     */
    public void stopFm() {
        System.out.println("Stop listening to FM radio...");
        tuner.off();
        amplifier.off();
    }
}
