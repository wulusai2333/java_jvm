package net.wulusai.designpattern.observer.javautil;

import java.util.Observable;
import java.util.Observer;

/**
 * 预报显示器 - 实现 java.util.Observer 接口
 * 对应 Head First 设计模式中的 ForecastDisplay
 */
public class ForecastDisplay implements Observer {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable observable;
    
    /**
     * 构造函数，注册到主题中
     */
    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        // 注册成为观察者
        observable.addObserver(this);
    }
    
    /**
     * 当主题状态改变时，此方法会被调用
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
    
    /**
     * 显示天气预报
     */
    public void display() {
        System.out.println("=== 天气预报 ===");
        if (currentPressure > lastPressure) {
            System.out.println("天气正在好转！");
        } else if (currentPressure == lastPressure) {
            System.out.println("天气和之前一样");
        } else {
            System.out.println("可能要下雨了");
        }
        System.out.println("当前气压：" + currentPressure + " inches");
        System.out.println("上次气压：" + lastPressure + " inches");
    }
}
