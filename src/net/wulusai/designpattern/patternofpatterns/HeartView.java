package net.wulusai.designpattern.patternofpatterns;

/**
 * HeartView - 心跳视图
 * 只显示心跳，不提供控制功能
 */
public class HeartView implements BeatObserver, ViewInterface {
    private ControllerInterface controller;
    private HeartModelInterface model;

    public HeartView(ControllerInterface controller, HeartModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver(this);
    }

    @Override
    public void createView() {
        System.out.println("=== 创建心跳视图 ===");
        System.out.println("当前心率: " + model.getHeartRate() + " BPM");
    }

    @Override
    public void createControls() {
        System.out.println("=== 心跳监测器（只读）===");
        System.out.println("注意：心率无法手动控制");
    }

    @Override
    public void update() {
        System.out.println("[视图更新] 心率: " + model.getHeartRate() + " BPM");
    }

    @Override
    public void updateBeat() {
        System.out.println("[心跳] ♥ 噗通! (心率: " + model.getHeartRate() + " BPM)");
    }
}
