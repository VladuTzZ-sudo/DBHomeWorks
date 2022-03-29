package DeutscheBank.HomeWork3;

public class Test {
    public static void main(String[] args) {
        CommandCapricioasa capricioasa = new CommandCapricioasa();
        CommandQuatroStagioni quatroStagioni = new CommandQuatroStagioni();
        CommandMarguerita marguerita = new CommandMarguerita();
        CommandProsciuttoFunghi prosciuttoFunghi = new CommandProsciuttoFunghi();

        Client vlad = new Client("Vlad");
        Client maria = new Client("Maria");
        Client cristi = new Client("Cristian");

        // AM CONSIDERAT CA ATUNCI CAND UN CLIENT FACE PENTRU PRIMA DATA O COMANDA, ACESTA SE VA ABONA LA PIZZERIE AUTOMAT !
        capricioasa.execute(vlad, Size.MEDIUM, Topping.NO_TOPPING);
        marguerita.execute(maria, Size.SMALL, Topping.TOMATOES);
        prosciuttoFunghi.execute(cristi, Size.MEDIUM, Topping.CAULIFLAWER);
        quatroStagioni.execute(cristi, Size.LARGE, Topping.NO_TOPPING);

        Client ion = new Client("Ion");
        PizzaFactory pizzaFactory = PizzaFactory.getInstance();
        pizzaFactory.detach(cristi);

        prosciuttoFunghi.execute(vlad, Size.SMALL, Topping.NO_TOPPING);
        quatroStagioni.execute(ion, Size.LARGE, Topping.TOMATOES);
        capricioasa.execute(maria, Size.MEDIUM, Topping.CAULIFLAWER);



    }
}
