package e1;

public class BankDecorator implements BankAccount{
    private static final int INITIAL_BALANCE = 0;
    private final BankAccount base;

    public BankDecorator() {
        this.base = new CoreBankAccount(INITIAL_BALANCE);
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        base.withdraw(amount);
    }
}
