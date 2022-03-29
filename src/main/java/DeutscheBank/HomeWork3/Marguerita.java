package DeutscheBank.HomeWork3;

public class Marguerita extends Pizza {
    @Override
    public String bakePizza() {
        return "Marguerita" + ": (BASE PRICE - " + getTotalPrice() + ") ";
    }

    @Override
    public float getTotalPrice() {
        return 20.0f;
    }
}
