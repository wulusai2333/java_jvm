package net.wulusai.designpattern.state;

/**
 * 糖果机 - 上下文类
 * 持有当前状态，并将行为委托给状态对象
 */
public class GumballMachine {
    
    // 定义所有可能的状态
    private final State soldOutState;      // 售罄状态
    private final State noQuarterState;    // 未投币状态
    private final State hasQuarterState;   // 已投币状态
    private final State soldState;         // 售出状态
    
    // 当前状态
    private State currentState;
    
    // 糖果数量
    private int count;
    
    public GumballMachine(int numberGumballs) {
        // 初始化所有状态对象
        this.soldOutState = new SoldOutState();
        this.noQuarterState = new NoQuarterState();
        this.hasQuarterState = new HasQuarterState();
        this.soldState = new SoldState();
        
        // 初始状态取决于糖果数量
        if (numberGumballs > 0) {
            this.currentState = noQuarterState;
        } else {
            this.currentState = soldOutState;
        }
        this.count = numberGumballs;
        
        System.out.println("糖果机初始化完成，共有 " + numberGumballs + " 颗糖果");
        System.out.println("当前状态：" + getCurrentStateDescription());
    }
    
    /**
     * 投入 25 美分
     */
    public void insertQuarter() {
        currentState.insertQuarter(this);
    }
    
    /**
     * 退回 25 美分
     */
    public void ejectQuarter() {
        currentState.ejectQuarter(this);
    }
    
    /**
     * 转动曲柄
     */
    public void turnCrank() {
        currentState.turnCrank(this);
        // 如果状态变为 SoldState，则调用 dispense
        if (currentState == soldState) {
            currentState.dispense(this);
        }
    }
    
    /**
     * 发放糖果（由状态对象调用）
     */
    public void dispense() {
        currentState.dispense(this);
    }
    
    /**
     * 补货
     * @param numberGumballs 补充的糖果数量
     */
    public void refill(int numberGumballs) {
        currentState.refill(this, numberGumballs);
        System.out.println("补货完成，当前糖果数量：" + count);
        System.out.println("当前状态：" + getCurrentStateDescription());
    }
    
    /**
     * 设置当前状态
     * @param state 新的状态
     */
    public void setState(State state) {
        this.currentState = state;
        System.out.println(">>> 状态切换：" + getCurrentStateDescription());
    }
    
    /**
     * 获取当前状态的描述
     * @return 状态描述字符串
     */
    private String getCurrentStateDescription() {
        if (currentState == soldOutState) {
            return "SoldOutState（售罄状态）";
        } else if (currentState == noQuarterState) {
            return "NoQuarterState（未投币状态）";
        } else if (currentState == hasQuarterState) {
            return "HasQuarterState（已投币状态）";
        } else if (currentState == soldState) {
            return "SoldState（售出状态）";
        }
        return "Unknown State";
    }
    
    // Getter methods for states
    public State getSoldOutState() {
        return soldOutState;
    }
    
    public State getNoQuarterState() {
        return noQuarterState;
    }
    
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    
    public State getSoldState() {
        return soldState;
    }
    
    public State getCurrentState() {
        return currentState;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * 打印当前机器状态
     */
    public void printStatus() {
        System.out.println("\n--- 糖果机状态 ---");
        System.out.println("糖果数量：" + count);
        System.out.println("当前状态：" + getCurrentStateDescription());
        System.out.println("----------------\n");
    }
}
