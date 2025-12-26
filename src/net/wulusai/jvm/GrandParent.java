package net.wulusai.jvm;

public class GrandParent implements InterfaceA {

    public static final int staticField = 100;

    public static final String staticField2 = "finalGrandParent";

    public static int staticField3 = 101;

    public static String staticField4 = "staticGrandParent";

    public int intFieldField = 102;

    public String stringField = "stringGrandParent";

    static {
        System.out.println("grandParent static block");
    }

    {
        System.out.println("grandParent instance block");
    }

    public GrandParent() {
        System.out.println("grandParent constructor");
    }

    public void print() {
        System.out.println("grandParent print");
    }

    public static void staticPrint() {
        System.out.println("grandParent static print");
    }

    public static void main(String[] args) {
        System.out.println("grandParent main");
        GrandParent grandParent = new GrandParent();
        grandParent.print();
        GrandParent.staticPrint();
        grandParent.methodA();
    }

    @Override
    public void methodA() {
        System.out.println("grandParent methodA");
    }
}
