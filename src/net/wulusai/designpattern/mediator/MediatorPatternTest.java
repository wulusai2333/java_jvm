package net.wulusai.designpattern.mediator;

/**
 * 客户端测试类
 * 中介者模式: 用一个中介对象封装一系列的对象交互
 * 使各对象不需要显式地相互引用，从而使其耦合松散
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        /* 创建中介者 - 聊天室 */
        ChatMediator chatRoom = new ChatRoom();

        /* 创建用户并注册到聊天室 */
        User user1 = new NormalUser(chatRoom, "张三");
        User user2 = new NormalUser(chatRoom, "李四");
        User user3 = new NormalUser(chatRoom, "王五");
        User admin = new AdminUser(chatRoom, "管理员");

        /* 注册用户到聊天室 */
        chatRoom.registerUser(user1);
        chatRoom.registerUser(user2);
        chatRoom.registerUser(user3);
        chatRoom.registerUser(admin);

        System.out.println("=== 普通用户发送消息 ===");
        /* 用户1发送消息，会通过中介者转发给其他所有用户 */
        user1.sendMessage("大家好，我是新来的！");

        System.out.println("\n=== 用户2回复 ===");
        user2.sendMessage("欢迎欢迎！");

        System.out.println("\n=== 管理员发送系统通知 ===");
        /* 管理员可以发送系统通知 */
        ((AdminUser) admin).sendSystemNotification("请注意群规，文明聊天");

        System.out.println("\n=== 用户3发送消息 ===");
        user3.sendMessage("今天天气不错");
    }
}
