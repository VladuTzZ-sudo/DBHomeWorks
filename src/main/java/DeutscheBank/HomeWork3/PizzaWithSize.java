package DeutscheBank.HomeWork3;

public class PizzaWithSize extends PizzaDecorator {
    private final Size size;

    public PizzaWithSize(Pizza newPizza, Size size) {
        super(newPizza);
        this.size = size;
    }

    @Override
    public float getTotalPrice() {
        return size.getValue() * super.getTotalPrice();
    }

    @Override
    public String bakePizza() {
        notifyUpdate(pizza.bakePizza() + " is baked ! - Price: " + getTotalPrice());
        return super.bakePizza() + "+ (Size - " + size + " - " + size.getValue() + " ) ";
    }
}
