package DeutscheBank.HomeWork3;

public class Capriciosa extends Pizza {
    @Override
    public String bakePizza() {
        return "Capriciosa" + ": (BASE PRICE - " + getTotalPrice() + ") ";
    }

    @Override
    public float getTotalPrice() {
        return 30.f;
    }
}
