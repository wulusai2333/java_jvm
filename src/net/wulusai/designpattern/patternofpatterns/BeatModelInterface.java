package net.wulusai.designpattern.patternofpatterns;

/**
 * BeatModel接口 - 模型接口
 * 定义了节拍模型的基本行为
 */
public interface BeatModelInterface {
    void initialize();
    
    void on();
    
    void off();
    
    void setBPM(int bpm);
    
    int getBPM();
    
    void registerObserver(BeatObserver observer);
    
    void removeObserver(BeatObserver observer);
    
    void registerObserver(BPMObserver observer);
    
    void removeObserver(BPMObserver observer);
}
