package e1;

public class GoldBankAccount implements BankAccount{
    private static final int INITIAL_BALANCE = 0;
    private static final int OVERDRAFT = 500;
    private int balance;

    public GoldBankAccount() {
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
        if(this.getBalance() < amount - OVERDRAFT){
            throw new IllegalStateException();
        }else{
            this.balance -= amount;
        }
    }
}
