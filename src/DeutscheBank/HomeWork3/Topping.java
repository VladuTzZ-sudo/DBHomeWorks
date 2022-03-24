package DeutscheBank.HomeWork3;

public enum Topping {
    NO_TOPPING(1.0f), TOMATOES(1.3f), CAULIFLAWER(1.5f);
    private final float v;

    Topping(float v) {
        this.v = v;
    }

    public float getValue() {
        return v;
    }
}
