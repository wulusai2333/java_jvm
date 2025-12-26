package net.wulusai.oom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {
    public static List<Object> list = new ArrayList<>();
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(UUID.randomUUID().toString(), i++));
            new User(UUID.randomUUID().toString(), j--);
            //System.out.println(list.size());
//            try {
//                Thread.sleep(1L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
