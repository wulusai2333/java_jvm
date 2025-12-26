package net.wulusai.jvm;

public class LoadMain {
    public static void main(String[] args) {
        System.out.println("Hello, LoadMain!");
        Child child = new Child();
        child.print();
        child.staticPrint();
        child.methodA();
        child.methodB();
        child.methodC();
        System.out.println(Child.staticField);
        System.out.println(Child.staticField2);
        System.out.println(Child.staticField3);


    }
}
