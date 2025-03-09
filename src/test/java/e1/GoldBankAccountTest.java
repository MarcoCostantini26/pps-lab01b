package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest{
    private BankAccount goldAccount;
    private static final int DEPOSIT_INITIAL_BALANCE = 1000;
    private static final int WITHDRAW_FOR_NEGATIVE_BALANCE = 1500;

    @BeforeEach
    void init(){
        this.goldAccount = new GoldBankAccount();
    }

    @Test
    public void testGoldAccountFee(){
        final int AMOUNT_990_MONEY = 990;
        final int AMOUNT_10_MONEY = 10;
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(AMOUNT_10_MONEY);
        assertEquals(AMOUNT_990_MONEY, this.goldAccount.getBalance());
    }

    @Test
    public void testNegativeBalanceGoldAccount(){
        final int NEGATIVE_BALANCE = -500;
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(WITHDRAW_FOR_NEGATIVE_BALANCE);
        assertAll(
                () -> assertEquals(NEGATIVE_BALANCE, goldAccount.getBalance()),
                () -> assertThrows(IllegalStateException.class, () -> goldAccount.withdraw(WITHDRAW_FOR_NEGATIVE_BALANCE))
        );
    }
}
