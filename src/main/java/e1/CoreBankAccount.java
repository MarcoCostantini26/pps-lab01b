package e1;

class CoreBankAccount {

    private final BankAccount bankAccount;

    public CoreBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getBalance() {
        return this.bankAccount.getBalance();
    }

    public void deposit(int amount) {
        this.bankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        this.bankAccount.withdraw(amount);
    }
}
