package net.wulusai.designpattern.patternofpatterns;

/**
 * Controller接口 - 控制器接口
 * 定义控制器的基本行为
 */
public interface ControllerInterface {
    void start();
    
    void stop();
    
    void increaseBPM();
    
    void decreaseBPM();
    
    void setBPM(int bpm);
}
