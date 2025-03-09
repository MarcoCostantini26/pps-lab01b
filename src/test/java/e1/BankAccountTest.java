package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private static final int DEPOSIT_INITIAL_BALANCE = 1000;
    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        final int INITIAL_BALANCE = 0;
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertEquals(DEPOSIT_INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        final int AMOUNT_799_MONEY = 799;
        final int AMOUNT_200_MONEY = 200;
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        this.account.withdraw(AMOUNT_200_MONEY);
        assertEquals(AMOUNT_799_MONEY, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        final int AMOUNT_1200_MONEY = 1200;
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(AMOUNT_1200_MONEY));
    }

}
