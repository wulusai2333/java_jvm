package net.wulusai.designpattern.observer.javautil;

import java.util.Observable;
import java.util.Observer;

/**
 * 统计显示器 - 实现 java.util.Observer 接口
 * 对应 Head First 设计模式中的 StatisticsDisplay
 */
public class StatisticsDisplay implements Observer {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Observable observable;
    
    /**
     * 构造函数，注册到主题中
     */
    public StatisticsDisplay(Observable observable) {
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
            float temp = weatherData.getTemperature();
            tempSum += temp;
            numReadings++;
            
            if (temp > maxTemp) {
                maxTemp = temp;
            }
            
            if (temp < minTemp) {
                minTemp = temp;
            }
            
            display();
        }
    }
    
    /**
     * 显示统计信息
     */
    public void display() {
        System.out.println("=== 统计信息 ===");
        System.out.println("平均温度：" + tempSum / numReadings);
        System.out.println("最高温度：" + maxTemp);
        System.out.println("最低温度：" + minTemp);
        System.out.println("总读数：" + numReadings);
    }
}
