package ObserverPattern.src.observer;

import java.util.ArrayList;
import java.util.List;

public class CricketData {
    private List<Observer> observers;
    private int runs;
    private int wickets;

    public CricketData() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setScore(int runs, int wickets) {
        this.runs = runs;
        this.wickets = wickets;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(runs, wickets);
        }
    }
}
