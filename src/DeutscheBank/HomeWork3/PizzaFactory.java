package DeutscheBank.HomeWork3;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory implements Subject {
    private static PizzaFactory instance;
    private final List<Observer> observers = new ArrayList<>();

    private PizzaFactory() {
    }

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza createPizza(PizzaType type, Size size, Topping topping) {
        notifyUpdate("Pizza in the process of baking !\t-\tTYPE:" + type + " SIZE:" + size + " TOPPING:" + topping);

        switch (type) {
            case CAPRICIOSA -> {
                if (topping == Topping.NO_TOPPING) {
                    return new PizzaWithSize(new Capriciosa(), size);
                } else {
                    return new PizzaWithSizeAndTopping(new Capriciosa(), size, topping);
                }
            }
            case PROSCIUTTO_FUNGHI -> {
                if (topping == Topping.NO_TOPPING) {
                    return new PizzaWithSize(new ProsciuttoFunghi(), size);
                } else {
                    return new PizzaWithSizeAndTopping(new ProsciuttoFunghi(), size, topping);
                }
            }
            case QUATRO_STAGIONI -> {
                if (topping == Topping.NO_TOPPING) {
                    return new PizzaWithSize(new QuatroStagioni(), size);
                } else {
                    return new PizzaWithSizeAndTopping(new QuatroStagioni(), size, topping);
                }
            }
            case MARGUERITA -> {
                if (topping == Topping.NO_TOPPING) {
                    return new PizzaWithSize(new Marguerita(), size);
                } else {
                    return new PizzaWithSizeAndTopping(new Marguerita(), size, topping);
                }
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void attach(Observer o) {
        if (!observers.contains(o)) {
            System.out.println("Clientul @" + ((Client) o).getName() + " subscribed the pizza factory.");
            observers.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyUpdate(String m) {
        for (Observer o : observers) {
            o.update(m);
        }
    }
}
