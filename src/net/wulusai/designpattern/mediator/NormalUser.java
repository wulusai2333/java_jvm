package net.wulusai.designpattern.mediator;

/**
 * 具体同事类 - 普通用户
 */
public class NormalUser extends User {

    public NormalUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void receiveMessage(String message, User sender) {
        System.out.println("[" + this.name + "] 收到来自 [" + sender.getName() + "] 的消息: " + message);
    }
}
