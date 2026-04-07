package net.wulusai.designpattern.state;

/**
 * 已投币状态
 * 用户已经投入了 25 美分
 */
public class HasQuarterState implements State {
    
    public HasQuarterState() {
    }
    
    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("你已经投入了 25 美分，不能再投入了");
    }
    
    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("退回 25 美分");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    
    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("你转动了曲柄");
        // 检查是否还有糖果
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getSoldState());
        } else {
            System.out.println("哦，不！糖果机空了！");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
    
    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("还没有发放糖果，请先转动曲柄");
    }
    
    @Override
    public void refill(GumballMachine gumballMachine, int count) {
        System.out.println("正在补货..." + count + " 颗糖果已添加");
        gumballMachine.setCount(gumballMachine.getCount() + count);
        // 保持在 HasQuarterState 状态
    }
}
