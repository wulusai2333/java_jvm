package net.wulusai.designpattern.mediator;

/**
 * 抽象中介者接口
 * 定义同事对象之间通信的接口
 */
public interface ChatMediator {
    /**
     * 注册聊天用户
     * @param user 聊天用户
     */
    void registerUser(User user);

    /**
     * 发送消息
     * @param message 消息内容
     * @param sender 发送者
     */
    void sendMessage(String message, User sender);
}
