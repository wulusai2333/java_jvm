package net.wulusai.designpattern.bridge;

/**
 * 抽象类 - 遥控器
 * 持有Implementor的引用，将操作委托给具体的电视实现
 */
public abstract class Abstraction {
    /**
     * 电视实现对象
     */
    protected Implementor implementor;

    /**
     * 构造方法
     * @param implementor 电视实现对象
     */
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 打开电视 - 委托给具体实现
     */
    public void turnOn() {
        implementor.on();
    }

    /**
     * 关闭电视 - 委托给具体实现
     */
    public void turnOff() {
        implementor.off();
    }

    /**
     * 切换频道 - 委托给具体实现
     * @param channel 频道号
     */
    public void setChannel(int channel) {
        implementor.tuneChannel(channel);
    }

    /**
     * 获取电视状态
     * @return 电视状态描述
     */
    public String getStatus() {
        return implementor.getStatus();
    }
}
