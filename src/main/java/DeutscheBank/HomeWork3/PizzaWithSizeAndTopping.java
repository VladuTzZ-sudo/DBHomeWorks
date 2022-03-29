package DeutscheBank.HomeWork3;

public class PizzaWithSizeAndTopping extends PizzaDecorator{
    private final Size size;
    private final Topping topping;

    public PizzaWithSizeAndTopping(Pizza newPizza, Size size, Topping topping) {
        super(newPizza);
        this.size = size;
        this.topping = topping;
    }

    @Override
    public float getTotalPrice() {
        return size.getValue() * super.getTotalPrice() * topping.getValue();
    }

    public Topping getTopping() {
        return topping;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String bakePizza() {
        notifyUpdate(pizza.bakePizza() + " is baked ! - Price: " + getTotalPrice());
        return super.bakePizza() + "+ (Size - " + size + " - " + size.getValue() + " ) " + "+ (Topping - " + topping + " - " + topping.getValue() +  " ) ";
    }
}
