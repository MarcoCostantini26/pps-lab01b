package e1;

public class BronzeBankAccount implements BankAccount{
    public static final int INITIAL_BALANCE = 0;
    public static final int FEE = 1;
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
        } else if (amount < 100 ) {
            this.balance -= amount;
        } else {
            this.balance -= (amount + FEE);
        }

    }
}
