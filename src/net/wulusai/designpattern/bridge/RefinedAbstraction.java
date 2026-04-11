package net.wulusai.designpattern.bridge;

/**
 * 扩充抽象类 - 高级遥控器
 * 在基础遥控器功能上扩展更多功能
 */
public class RefinedAbstraction extends Abstraction {

    /**
     * 构造方法
     * @param implementor 电视实现对象
     */
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    /**
     * 静音功能 - 通过快速切换频道实现
     */
    public void mute() {
        System.out.println("高级遥控器：执行静音操作");
        int currentChannel = 1;
        setChannel(currentChannel);
        System.out.println("已静音");
    }

    /**
     * 收藏频道功能
     * @param channel 要收藏的频道号
     */
    public void favoriteChannel(int channel) {
        System.out.println("高级遥控器：收藏频道 " + channel);
        setChannel(channel);
        System.out.println("频道 " + channel + " 已添加到收藏夹");
    }

    /**
     * 显示电视信息
     */
    public void displayInfo() {
        System.out.println("===== 高级遥控器信息 =====");
        System.out.println(getStatus());
        System.out.println("=========================");
    }
}
