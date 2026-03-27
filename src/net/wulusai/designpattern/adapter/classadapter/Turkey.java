package net.wulusai.designpattern.adapter.classadapter;

/**
 * 被适配者：具体的火鸡类（遗留系统）
 */
public class Turkey {
    
    /**
     * 咯咯叫（火鸡的叫声）
     */
    public void gobble() {
        System.out.println("Gobble gobble");
    }
    
    /**
     * 飞行（火鸡飞不远）
     */
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
