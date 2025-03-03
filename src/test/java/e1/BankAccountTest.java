package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    public static final int DEPOSIT_INITIAL_BALANCE = 1000;
    public static final int WITHDRAW_LESS_THAN_100 = 90;
    private static final int WITHDRAW_MORE_THAN_100 = 110;
    private SilverBankAccount account;
    private GoldBankAccount goldAccount;
    private BronzeBankAccount bronzeAccount;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount();
        this.goldAccount = new GoldBankAccount();
        this.bronzeAccount = new BronzeBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertEquals(DEPOSIT_INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Test
    public void testGoldAccountFee(){
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(10);
        assertEquals(990, this.goldAccount.getBalance());
    }

    @Test
    public void testNegativeBalanceGoldAccount(){
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(1500);
        assertAll(
                () -> assertEquals(-500, goldAccount.getBalance()),
                () -> assertThrows(IllegalStateException.class, () -> goldAccount.withdraw(500))
        );
    }

    @Test
    public void testBronzeAccountFeeLessThanOverdraft(){
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.bronzeAccount.withdraw(WITHDRAW_LESS_THAN_100);
        assertEquals(910, this.bronzeAccount.getBalance());
    }

    @Test
    public void testBronzeAccountFeeMoreThanOverdraft(){
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.bronzeAccount.withdraw(WITHDRAW_MORE_THAN_100);
        assertEquals(889, this.bronzeAccount.getBalance());
    }



}
