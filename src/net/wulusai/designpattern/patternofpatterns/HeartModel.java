package net.wulusai.designpattern.patternofpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * HeartModel - 心跳模型
 * 模拟真实的心跳，心率会随机波动
 */
public class HeartModel implements HeartModelInterface {
    private List<BeatObserver> beatObservers = new ArrayList<>();
    private Random random = new Random();
    private int heartRate = 80;
    private boolean running = false;
    private Thread heartThread;

    public HeartModel() {
        simulateHeartRate();
    }

    @Override
    public int getHeartRate() {
        return heartRate;
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

    /**
     * 通知所有观察者心跳发生
     */
    void notifyBeatObservers() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

    /**
     * 模拟心率变化
     */
    private void simulateHeartRate() {
        heartThread = new Thread(() -> {
            running = true;
            while (running && !Thread.currentThread().isInterrupted()) {
                try {
                    // 心率在70-90之间随机波动
                    heartRate = 70 + random.nextInt(21);
                    Thread.sleep(60000 / heartRate);
                    if (running) {
                        notifyBeatObservers();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        heartThread.start();
    }

    /**
     * 停止心跳模拟
     */
    public void stop() {
        running = false;
        if (heartThread != null) {
            heartThread.interrupt();
        }
    }
}
