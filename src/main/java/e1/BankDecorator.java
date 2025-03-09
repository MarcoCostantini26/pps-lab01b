package e1;

public class BankDecorator implements BankAccount{
    public static final int INITIAL_BALANCE = 0;
    private int balance;

    public BankDecorator() {
        this.balance = INITIAL_BALANCE;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
