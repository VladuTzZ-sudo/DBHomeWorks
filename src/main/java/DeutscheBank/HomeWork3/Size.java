package DeutscheBank.HomeWork3;

public enum Size {
    SMALL(1.1f), MEDIUM(1.2f), LARGE(1.4f);
    private final float v;

    Size(float v) {
        this.v = v;
    }

    public float getValue() {
        return v;
    }
}
