package net.wulusai.designpattern.observer;

import net.wulusai.designpattern.observer.observer.CurrentConditionsDisplay;
import net.wulusai.designpattern.observer.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        // Simulate some weather data changes
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);


    }
}
