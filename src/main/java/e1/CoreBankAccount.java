package e1;

class CoreBankAccount implements BankAccount{
    private static final int INITIAL_BALANCE = 0;
    private int balance;

    public CoreBankAccount(int balance) {
        this.balance = INITIAL_BALANCE;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
