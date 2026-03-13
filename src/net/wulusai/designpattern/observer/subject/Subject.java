package net.wulusai.designpattern.observer.subject;


import net.wulusai.designpattern.observer.observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();

}
