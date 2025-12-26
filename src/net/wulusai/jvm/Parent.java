package net.wulusai.jvm;

public class Parent extends GrandParent implements InterfaceB{
    public static final int staticField = 200;

    public static final String staticField2 = "finalParent";

    public static int staticField3 = 201;

    public static String staticField4 = "staticParent";

    public int intFieldField = 202;

    public String stringField = "stringParent";

    static {
        System.out.println("parent static block");
    }

    {
        System.out.println("parent instance block");
    }

    public Parent() {
        System.out.println("parent constructor");
    }

    public void print() {
        System.out.println("parent print");
    }

    public static void staticPrint() {
        System.out.println("parent static print");
    }

    public static void main(String[] args) {
        System.out.println("parent main");
        Parent parent = new Parent();
        parent.print();
        parent.staticPrint();
        parent.methodA();
        parent.methodB();
    }

    @Override
    public void methodB() {
        System.out.println("parent methodB");
    }
}
