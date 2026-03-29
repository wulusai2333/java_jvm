package net.wulusai.designpattern.templatemethod;

public class Tea extends CaffeineBeverage{
    @Override
    void brew() {
        System.out.println("Tea is brewing...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
