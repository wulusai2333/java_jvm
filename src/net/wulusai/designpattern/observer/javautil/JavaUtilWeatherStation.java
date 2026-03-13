package net.wulusai.designpattern.observer.javautil;

/**
 * 气象站主程序 - 使用 java.util 的观察者模式
 * 对应 Head First 设计模式中的 WeatherStation
 */
public class JavaUtilWeatherStation {
    public static void main(String[] args) {
        // 创建主题（被观察者）
        WeatherData weatherData = new WeatherData();
        
        // 创建观察者并注册到主题中
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        System.out.println("========== 第一次测量 ==========");
        weatherData.setMeasurements(80, 65, 30.4f);
        
        System.out.println("\n========== 第二次测量 ==========");
        weatherData.setMeasurements(82, 70, 29.2f);
        
        System.out.println("\n========== 第三次测量 ==========");
        weatherData.setMeasurements(78, 90, 29.2f);
        
        System.out.println("\n========== 移除统计显示器后的测量 ==========");
        // 演示移除观察者
        weatherData.deleteObserver(statisticsDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
        
        System.out.println("\n========== 重新添加统计显示器后的测量 ==========");
        // 演示重新添加观察者
        weatherData.addObserver(statisticsDisplay);
        weatherData.setMeasurements(99, 95, 27.8f);
    }
}
