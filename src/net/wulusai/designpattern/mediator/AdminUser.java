package net.wulusai.designpattern.mediator;

/**
 * 具体同事类 - 管理员用户
 * 可以发送系统通知
 */
public class AdminUser extends User {

    public AdminUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receiveMessage(String message, User sender) {
        System.out.println("[管理员 " + this.name + "] 收到来自 [" + sender.getName() + "] 的消息: " + message);
    }

    /**
     * 管理员发送系统通知
     * @param message 通知内容
     */
    public void sendSystemNotification(String message) {
        String notification = "[系统通知] " + message;
        System.out.println(this.name + " 发送系统通知: " + message);
        mediator.sendMessage(notification, this);
    }
}
