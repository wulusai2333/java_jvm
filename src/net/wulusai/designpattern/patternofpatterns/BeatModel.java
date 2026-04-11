package net.wulusai.designpattern.patternofpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * BeatModel实现类 - 具体的节拍模型
 * 使用观察者模式通知视图更新
 */
public class BeatModel implements BeatModelInterface {
    private List<BeatObserver> beatObservers = new ArrayList<>();
    private List<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm = 90;
    private boolean playing = false;
    private Thread beatThread;

    @Override
    public void initialize() {
        System.out.println("初始化节拍模型");
    }

    @Override
    public void on() {
        playing = true;
        startBeatThread();
        System.out.println("节拍器开启");
    }

    @Override
    public void off() {
        playing = false;
        if (beatThread != null) {
            beatThread.interrupt();
        }
        System.out.println("节拍器关闭");
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        int index = beatObservers.indexOf(observer);
        if (index >= 0) {
            beatObservers.remove(index);
        }
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        int index = bpmObservers.indexOf(observer);
        if (index >= 0) {
            bpmObservers.remove(index);
        }
    }

    /**
     * 通知所有节拍观察者
     */
    void notifyBeatObservers() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

    /**
     * 通知所有BPM观察者
     */
    void notifyBPMObservers() {
        for (BPMObserver observer : bpmObservers) {
            observer.updateBPM();
        }
    }

    /**
     * 启动节拍线程
     */
    private void startBeatThread() {
        beatThread = new Thread(() -> {
            while (playing && !Thread.currentThread().isInterrupted()) {
                try {
                    long delay = 60000 / bpm;
                    Thread.sleep(delay);
                    if (playing) {
                        notifyBeatObservers();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        beatThread.start();
    }
}
