package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private static final int DEPOSIT_INITIAL_BALANCE = 1000;
    private static final int AMOUNT_1200_MONEY = 1200;
    private static final int WITHDRAW_FOR_NEGATIVE_BALANCE = 1500;
    private CoreBankAccount account;
    private CoreBankAccount goldAccount;
    private CoreBankAccount bronzeAccount;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount(new SilverBankAccount());
        this.goldAccount = new CoreBankAccount(new GoldBankAccount());
        this.bronzeAccount = new CoreBankAccount(new BronzeBankAccount());
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
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(AMOUNT_1200_MONEY));
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
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        assertThrows(IllegalStateException.class, () -> this.bronzeAccount.withdraw(AMOUNT_1200_MONEY));
    }

}
