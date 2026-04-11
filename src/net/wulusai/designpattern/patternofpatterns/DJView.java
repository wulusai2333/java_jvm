package net.wulusai.designpattern.patternofpatterns;

/**
 * DJView - DJ视图
 * 实现BeatObserver和BPMObserver，使用观察者模式接收模型更新
 */
public class DJView implements BeatObserver, BPMObserver, ViewInterface {
    private ControllerInterface controller;
    private BeatModelInterface model;

    public DJView(ControllerInterface controller, BeatModelInterface model) {
        this.controller = controller;
        this.model = model;
        // 注册为观察者
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    @Override
    public void createView() {
        System.out.println("=== 创建DJ视图 ===");
        System.out.println("当前BPM: " + model.getBPM());
        update();
    }

    @Override
    public void createControls() {
        System.out.println("=== 创建控制面板 ===");
        System.out.println("可用操作: start(), stop(), increaseBPM(), decreaseBPM(), setBPM(int)");
    }

    @Override
    public void update() {
        System.out.println("[视图更新] BPM: " + model.getBPM());
    }

    @Override
    public void updateBeat() {
        System.out.println("[节拍] ♪ 咚!");
    }

    @Override
    public void updateBPM() {
        System.out.println("[BPM变化] 新的BPM: " + model.getBPM());
        update();
    }
}
