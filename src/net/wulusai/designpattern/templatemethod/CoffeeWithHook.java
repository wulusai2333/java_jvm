package net.wulusai.designpattern.templatemethod;

public class CoffeeWithHook extends CaffeineBeverageWithHook{
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    boolean customerWantsCondiments() {
        return super.customerWantsCondiments();
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
