package net.wulusai.designpattern.state;

/**
 * 售出状态
 * 正在发放糖果的状态
 */
public class SoldState implements State {
    
    public SoldState() {
    }
    
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("请稍等，糖果正在发放中...");
    }
    
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("抱歉，你已经转动了曲柄，糖果正在发放，无法退款");
    }
    
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("你已经转动过一次曲柄了，不能再次转动");
    }
    
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("正在发放糖果...");
        gumballMachine.setCount(gumballMachine.getCount() - 1);
        
        // 检查剩余的糖果数量
        if (gumballMachine.getCount() > 0) {
            System.out.println("糖果发放完成！还剩 " + gumballMachine.getCount() + " 颗糖果");
            // 如果还有糖果，回到 NoQuarterState 状态
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("糖果发放完成！糖果机已经空了");
            // 如果没有糖果了，切换到 SoldOutState 状态
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
    
    @Override
    public void refill(GumballMachine gumballMachine, int count) {
        System.out.println("正在补货..." + count + " 颗糖果已添加");
        gumballMachine.setCount(gumballMachine.getCount() + count);
        // 补货后切换到 NoQuarterState 状态
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}
