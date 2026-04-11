package net.wulusai.designpattern.bridge;

/**
 * 具体实现类A - LG电视
 * 实现Implementor接口，提供LG品牌电视的具体功能
 */
public class ConcreteImplementorA implements Implementor {
    private boolean isOn = false;
    private int channel = 1;

    @Override
    public void on() {
        isOn = true;
        System.out.println("LG电视已打开");
    }

    @Override
    public void off() {
        isOn = false;
        System.out.println("LG电视已关闭");
    }

    @Override
    public void tuneChannel(int channel) {
        if (isOn) {
            this.channel = channel;
            System.out.println("LG电视切换到频道: " + channel);
        } else {
            System.out.println("LG电视未打开，无法切换频道");
        }
    }

    @Override
    public String getStatus() {
        return "LG电视 [状态: " + (isOn ? "开启" : "关闭") + ", 频道: " + channel + "]";
    }
}
