package net.wulusai.designpattern.state;

/**
 * 售完状态
 * 糖果机中没有糖果了
 */
public class SoldOutState implements State {
    
    public SoldOutState() {
    }
    
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("糖果已经售罄，无法投入 25 美分");
    }
    
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("你没有投入 25 美分，而且糖果机已经空了");
    }
    
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("你转动了曲柄，但是糖果机已经空了");
    }
    
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("没有糖果可以发放");
    }
    
    @Override
    public void refill(GumballMachine gumballMachine, int count) {
        System.out.println("正在补货..." + count + " 颗糖果已添加");
        gumballMachine.setCount(count);
        // 补货后切换到 NoQuarterState 状态
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
