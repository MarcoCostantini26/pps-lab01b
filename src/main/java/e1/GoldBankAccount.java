package e1;

public class GoldBankAccount extends BankDecorator{
    private static final int OVERDRAFT = 500;

    @Override
    public void withdraw(int amount) {
        if(this.getBalance() < amount - OVERDRAFT){
            throw new IllegalStateException();
        }else{
            super.withdraw(amount);
        }
    }
}
