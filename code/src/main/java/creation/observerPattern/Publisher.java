package creation.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    List<Observer> observers;

    public static final Publisher publisher = new Publisher();
    private Publisher(){
        observers = new ArrayList<>();

    }



    public void addObserver(Observer observer) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }
    public boolean removeObserver(Observer observer){
        if(observers!=null) {
            return observers.remove(observer);
        }
        return false;
    }

    public void updateAll(){
        observers.stream().forEach(Observer::update);
    }
}
