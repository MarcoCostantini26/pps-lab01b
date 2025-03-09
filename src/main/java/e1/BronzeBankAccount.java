package e1;

public class BronzeBankAccount extends BankDecorator{
    private static final int FEE = 1;
    private static final int OVERDRAFT = 100;

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() < amount){
            throw new IllegalStateException();
        } else if (amount < OVERDRAFT) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + FEE);
        }

    }
}
