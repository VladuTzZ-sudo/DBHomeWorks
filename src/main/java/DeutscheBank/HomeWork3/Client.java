package DeutscheBank.HomeWork3;

public class Client implements Observer {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String m) {
        System.out.println("The Client @" + getName() + " received this message:\t" + "\"" + m + "\"");
    }
}
