package e1;

public class SilverBankAccount implements BankAccount{

    private static final int INITIAL_BALANCE = 0;
    private static final int FEE = 1;
    private int balance;

    public SilverBankAccount() {
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

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.balance -= (amount + FEE);
    }
}
