package DeutscheBank.HomeWork3;

import static java.lang.Thread.sleep;

public class CommandCapricioasa implements Command {
    @Override
    public void execute(Client client, Size size, Topping topping) {
        PizzaFactory pizzaFactory = PizzaFactory.getInstance();

        // AM CONSIDERAT CA ATUNCI CAND UN CLIENT FACE PENTRU PRIMA DATA O COMANDA, ACESTA SE VA ABONA LA PIZZERIE AUTOMAT !
        pizzaFactory.attach(client);
        Pizza pizza = pizzaFactory.createPizza(PizzaType.CAPRICIOSA, size, topping);
        pizza.attach(client);

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pizza.bakePizza();
    }
}
