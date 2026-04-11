package net.wulusai.designpattern.bridge;

/**
 * 实现类接口 - 电视
 * 定义电视的基本操作接口，所有具体电视品牌都需要实现此接口
 */
public interface Implementor {
    /**
     * 打开电视
     */
    void on();

    /**
     * 关闭电视
     */
    void off();

    /**
     * 切换频道
     * @param channel 频道号
     */
    void tuneChannel(int channel);

    /**
     * 获取当前状态信息
     * @return 电视状态描述
     */
    String getStatus();
}
