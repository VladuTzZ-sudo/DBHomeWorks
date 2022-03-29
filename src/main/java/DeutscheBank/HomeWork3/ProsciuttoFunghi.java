package DeutscheBank.HomeWork3;

public class ProsciuttoFunghi extends Pizza {
    @Override
    public String bakePizza() {
        return "ProsciuttoFunghi" + ": (BASE PRICE - " + getTotalPrice() + ") ";
    }

    @Override
    public float getTotalPrice() {
        return 40.0f;
    }
}
