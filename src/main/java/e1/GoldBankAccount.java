package e1;

public class GoldBankAccount implements BankAccount{

    public static final int INITIAL_BALANCE = 0;
    private CoreBankAccount base = new CoreBankAccount(INITIAL_BALANCE);

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() < amount - 500){
            throw new IllegalStateException();
        }else{
            this.base.withdraw(amount);
        }

    }
}
