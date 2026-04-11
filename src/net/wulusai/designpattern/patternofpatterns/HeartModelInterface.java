package net.wulusai.designpattern.patternofpatterns;

/**
 * HeartModelInterface接口 - 心跳模型接口
 * 模拟心跳监测器
 */
public interface HeartModelInterface {
    int getHeartRate();
    
    void registerObserver(BeatObserver observer);
    
    void removeObserver(BeatObserver observer);
}
