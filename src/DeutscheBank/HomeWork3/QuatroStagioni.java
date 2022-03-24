package DeutscheBank.HomeWork3;

public class QuatroStagioni extends Pizza {
    @Override
    public String bakePizza() {
        return "QuatroStagioni" + ": (BASE PRICE - " + getTotalPrice() + ") ";
    }

    @Override
    public float getTotalPrice() {
        return 45.0f;
    }
}
