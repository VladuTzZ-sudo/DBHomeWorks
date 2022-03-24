package DeutscheBank.HomeWork3;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza implements Subject {
    float totalPrice = 0.0f;
    public abstract String bakePizza();
    public abstract float getTotalPrice();

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(String m) {
        for(Observer o: observers) {
            o.update(m);
        }
        System.out.println();
    }
}
