package net.wulusai.designpattern.mediator;

/**
 * 抽象同事类 - 用户
 * 定义了用户的基本行为
 */
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 发送消息 - 通过中介者发送
     * @param message 消息内容
     */
    public void sendMessage(String message) {
        System.out.println(this.name + " 发送消息: " + message);
        mediator.sendMessage(message, this);
    }

    /**
     * 接收消息 - 由中介者调用
     * @param message 消息内容
     * @param sender 发送者
     */
    public abstract void receiveMessage(String message, User sender);

    public String getName() {
        return name;
    }
}
