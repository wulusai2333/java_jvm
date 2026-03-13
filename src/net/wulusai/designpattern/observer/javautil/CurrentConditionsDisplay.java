package net.wulusai.designpattern.observer.javautil;

import java.util.Observable;
import java.util.Observer;

/**
 * 当前条件显示器 - 实现 java.util.Observer 接口
 * 对应 Head First 设计模式中的 CurrentConditionsDisplay
 */
public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Observable observable;
    
    /**
     * 构造函数，注册到主题中
     */
    public CurrentConditionsDisplay(Observable observable) {
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
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
    
    /**
     * 显示当前条件
     */
    public void display() {
        System.out.println("=== 当前条件 ===");
        System.out.println("温度：" + temperature + " F");
        System.out.println("湿度：" + humidity + " %");
        System.out.println("气压：" + ((WeatherData)observable).getPressure() + " inches");
    }
}
