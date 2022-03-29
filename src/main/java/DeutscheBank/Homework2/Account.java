package DeutscheBank.Homework2;

public class Account {
    private int acccountNo;
    private int amount;
    private int nationalId;

    public Account() {
    }

    public void withdraw(int amount) throws NotEnoughMoneyException {
        if (amount > this.amount) {
            throw new NotEnoughMoneyException("Not enough money for this payment !", new RuntimeException());
        }
    }

    public void account(int amount) {
        this.amount = amount;
    }

    public void linkToNationalId(int nationalId) throws InvalidNationalIdException {
        if (!InvalidNationalIdException.checkId(String.valueOf(nationalId))) {
            throw new InvalidNationalIdException("National id is not valid !", new RuntimeException());
        }
    }
}
