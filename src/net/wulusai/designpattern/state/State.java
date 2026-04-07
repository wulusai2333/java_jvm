package net.wulusai.designpattern.state;

/**
 * 状态接口
 * 定义所有具体状态的公共接口
 */
public interface State {
    /**
     * 投入 25 美分
     * @param gumballMachine 糖果机上下文
     */
    void insertQuarter(GumballMachine gumballMachine);
    
    /**
     * 退回 25 美分
     * @param gumballMachine 糖果机上下文
     */
    void ejectQuarter(GumballMachine gumballMachine);
    
    /**
     * 转动曲柄
     * @param gumballMachine 糖果机上下文
     */
    void turnCrank(GumballMachine gumballMachine);
    
    /**
     * 发放糖果
     * @param gumballMachine 糖果机上下文
     */
    void dispense(GumballMachine gumballMachine);
    
    /**
     * 投入糖果（补货）
     * @param gumballMachine 糖果机上下文
     * @param count 补充的糖果数量
     */
    void refill(GumballMachine gumballMachine, int count);
}
