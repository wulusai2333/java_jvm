package net.wulusai.designpattern.bridge;

/**
 * 具体实现类B - Sony电视
 * 实现Implementor接口，提供Sony品牌电视的具体功能
 */
public class ConcreteImplementorB implements Implementor {
    private boolean isOn = false;
    private int channel = 1;
    private int volume = 50;

    @Override
    public void on() {
        isOn = true;
        System.out.println("Sony电视已打开");
    }

    @Override
    public void off() {
        isOn = false;
        System.out.println("Sony电视已关闭");
    }

    @Override
    public void tuneChannel(int channel) {
        if (isOn) {
            this.channel = channel;
            System.out.println("Sony电视切换到频道: " + channel);
        } else {
            System.out.println("Sony电视未打开，无法切换频道");
        }
    }

    /**
     * Sony电视特有功能：调节音量
     * @param volume 音量值（0-100）
     */
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Sony电视音量设置为: " + volume);
        } else {
            System.out.println("音量必须在0-100之间");
        }
    }

    @Override
    public String getStatus() {
        return "Sony电视 [状态: " + (isOn ? "开启" : "关闭") + ", 频道: " + channel + ", 音量: " + volume + "]";
    }
}
