package net.wulusai.oom;

import java.util.List;

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    protected void finalize() throws Throwable {
        //OOMTest.list.add(this);
        System.out.println("User age is:"+age+",list size is:"+OOMTest.list.size());
    }
}
