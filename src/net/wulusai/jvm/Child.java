package net.wulusai.jvm;

public class Child extends Parent implements InterfaceC{
    public static final int staticField = 300;

    public static final String staticField2 = "finalChild";

    public static int staticField3 = 301;

    public static String staticField4 = "staticChild";

    public int intFieldField = 302;

    public String stringField = "stringChild";

    static {
        System.out.println("child static block");
    }

    {
        System.out.println("child instance block");
    }

    public Child() {
        System.out.println("child constructor");
    }

    public void print() {
        System.out.println("child print");
    }

    public static void staticPrint() {
        System.out.println("child static print");
    }

    public static void main(String[] args) {
        System.out.println("child main");
        Child child = new Child();
        child.print();
        child.staticPrint();
        child.methodA();
        child.methodB();
        child.methodC();
    }

    @Override
    public void methodC() {
        System.out.println("child methodC");
    }
}
