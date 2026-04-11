package net.wulusai.designpattern.patternofpatterns;

/**
 * HeartController - 心跳控制器
 * 适配心跳模型到DJ视图，使用适配器模式
 */
public class HeartController implements ControllerInterface {
    private HeartModelInterface model;
    private HeartView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        this.view = new HeartView(this, model);
        view.createView();
        view.createControls();
    }

    @Override
    public void start() {
        System.out.println("心跳监测已启动");
    }

    @Override
    public void stop() {
        if (model instanceof HeartModel) {
            ((HeartModel) model).stop();
        }
        System.out.println("心跳监测已停止");
    }

    @Override
    public void increaseBPM() {
        System.out.println("无法手动增加心率，心率由身体自动控制");
    }

    @Override
    public void decreaseBPM() {
        System.out.println("无法手动降低心率，心率由身体自动控制");
    }

    @Override
    public void setBPM(int bpm) {
        System.out.println("无法手动设置心率，心率由身体自动控制");
    }
}
