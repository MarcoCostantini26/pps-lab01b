package e1;

public class SilverBankAccount extends BankDecorator{
    private static final int FEE = 1;

    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount + FEE);
    }
}
