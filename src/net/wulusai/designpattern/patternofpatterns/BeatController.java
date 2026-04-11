package net.wulusai.designpattern.patternofpatterns;

/**
 * BeatController - 节拍控制器
 * 作为模型和视图之间的中介，使用策略模式的思想
 */
public class BeatController implements ControllerInterface {
    private BeatModelInterface model;
    private DJView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        // 创建视图并注册为观察者
        this.view = new DJView(this, model);
        view.createView();
        view.createControls();
    }

    @Override
    public void start() {
        model.on();
    }

    @Override
    public void stop() {
        model.off();
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM();
        if (bpm < 200) {
            model.setBPM(bpm + 1);
        }
    }

    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM();
        if (bpm > 1) {
            model.setBPM(bpm - 1);
        }
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
