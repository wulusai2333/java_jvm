package net.wulusai.designpattern.state;

/**
 * 没有投币状态
 * 这是糖果机的初始状态
 */
public class NoQuarterState implements State {
    
    public NoQuarterState() {
    }
    
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("你投入了 25 美分");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("你没有投入 25 美分");
    }
    
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("你转动了曲柄，但是没有投入 25 美分");
    }
    
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("没有发放糖果，你需要先投入 25 美分");
    }
    
    @Override
    public void refill(GumballMachine gumballMachine, int count) {
        System.out.println("正在补货..." + count + " 颗糖果已添加");
        gumballMachine.setCount(gumballMachine.getCount() + count);
        // 保持在 NoQuarterState 状态
    }
}
