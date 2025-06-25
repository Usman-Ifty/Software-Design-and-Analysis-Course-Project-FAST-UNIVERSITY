// ObserverPattern.java
import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        MatchUpdateNotifier notifier = new MatchUpdateNotifier();

        // Create observers
        UserDevice device1 = new UserDevice("Phone");
        UserDevice device2 = new UserDevice("Tablet");

        // Register observers
        notifier.addObserver(device1);
        notifier.addObserver(device2);

        // Notify observers
        notifier.notifyObservers("Goal scored by Team A!");
    }
}

interface Observer {
    void update(String message);
}

class UserDevice implements Observer {
    private String deviceName;

    public UserDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(String message) {
        System.out.println(deviceName + " received update: " + message);
    }
}

class MatchUpdateNotifier {
    private List<Observer> observers = new ArrayList<>();

    // Add observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
