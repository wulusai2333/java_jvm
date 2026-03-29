package net.wulusai.designpattern.templatemethod;

public class TeaWithHook extends CaffeineBeverageWithHook{
    @Override
    void brew() {
        System.out.println("Tea is brewing...");
    }

    @Override
    boolean customerWantsCondiments() {
        return super.customerWantsCondiments();
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
