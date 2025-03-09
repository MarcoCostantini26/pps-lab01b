package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest {
    private BankAccount bronzeAccount;
    private static final int DEPOSIT_INITIAL_BALANCE = 1000;

    @BeforeEach
    void init(){
        this.bronzeAccount = new BronzeBankAccount();
    }

    @Test
    public void testBronzeAccountFeeLessThanOverdraft(){
        final int WITHDRAW_LESS_THAN_100 = 90;
        final int AMOUNT_910_MONEY = 910;
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.bronzeAccount.withdraw(WITHDRAW_LESS_THAN_100);
        assertEquals(AMOUNT_910_MONEY, this.bronzeAccount.getBalance());
    }

    @Test
    public void testBronzeAccountFeeMoreThanOverdraft(){
        final int WITHDRAW_MORE_THAN_100 = 110;
        final int AMOUNT_899_MONEY = 889;
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.bronzeAccount.withdraw(WITHDRAW_MORE_THAN_100);
        assertEquals(AMOUNT_899_MONEY, this.bronzeAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailableInBronzeAccount(){
        final int AMOUNT_1200_MONEY = 1200;
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.bronzeAccount.withdraw(AMOUNT_1200_MONEY));
    }
}
