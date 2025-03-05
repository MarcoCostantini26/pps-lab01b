package e1;

public class BronzeBankAccount implements BankAccount{
    private static final int INITIAL_BALANCE = 0;
    private static final int FEE = 1;
    private static final int OVERDRAFT = 100;
    private int balance;

    public BronzeBankAccount() {
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
        if(this.getBalance() < amount){
            throw new IllegalStateException();
        } else if (amount < OVERDRAFT) {
            this.balance -= amount;
        } else {
            this.balance -= (amount + FEE);
        }

    }
}
