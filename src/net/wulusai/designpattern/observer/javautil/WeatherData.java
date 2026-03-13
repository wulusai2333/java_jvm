package net.wulusai.designpattern.observer.javautil;

import java.util.Observable;

/**
 * 气象数据主题类 - 使用 java.util.Observable
 * 对应 Head First 设计模式中的 WeatherData
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
    }
    
    /**
     * 当测量值改变时，此方法会被调用
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    /**
     * 当测量值改变时，此方法会被调用
     * 它首先标记 Observable 已改变，然后通知所有观察者
     */
    public void measurementsChanged() {
        // 标记 Observable 已经改变
        setChanged();
        // 通知所有观察者，传递当前对象作为参数
        notifyObservers();
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
}
