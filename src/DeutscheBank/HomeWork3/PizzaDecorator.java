package DeutscheBank.HomeWork3;

public class PizzaDecorator extends Pizza {
    Pizza pizza;

    public PizzaDecorator(Pizza newPizza) {
        this.pizza = newPizza;
    }

    @Override
    public String bakePizza() {
        return pizza.bakePizza();
    }

    @Override
    public float getTotalPrice() {
        return pizza.getTotalPrice();
    }
}
