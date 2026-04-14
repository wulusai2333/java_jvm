package net.wulusai.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者 - 聊天室
 * 负责协调各个用户之间的消息传递
 */
public class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void registerUser(User user) {
        /* 注册用户到聊天室 */
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    @Override
    public void sendMessage(String message, User sender) {
        /* 
         * 中介者的核心逻辑：将消息转发给所有其他用户
         * 发送者不需要知道有哪些接收者，只需要通过中介者发送
         */
        for (User user : users) {
            /* 不将消息发送给发送者自己 */
            if (user != sender) {
                user.receiveMessage(message, sender);
            }
        }
    }
}
