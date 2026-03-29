package net.wulusai.designpattern.templatemethod;

/**
 * 带有钩子的抽象类
 */
public abstract class CaffeineBeverageWithHook {

    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    abstract void brew();
    /** 钩子方法，子类可以覆盖 */
    boolean customerWantsCondiments(){
        return true;
    }
    abstract void addCondiments();
    void boilWater() {
        System.out.println("Boiling water");
    }
    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
