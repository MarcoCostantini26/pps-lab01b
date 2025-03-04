package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    public static final int DEPOSIT_INITIAL_BALANCE = 1000;
    public static final int WITHDRAW_LESS_THAN_100 = 90;
    private static final int WITHDRAW_MORE_THAN_100 = 110;
    public static final int INITIAL_BALANCE = 0;
    public static final int AMOUNT_200_MONEY = 200;
    public static final int AMOUNT_799_MONEY = 799;
    public static final int AMOUNT_1200_MONEY = 1200;
    public static final int AMOUNT_10_MONEY = 10;
    public static final int AMOUNT_990_MONEY = 990;
    public static final int WITHDRAW_FOR_NEGATIVE_BALANCE = 1500;
    public static final int NEGATIVE_BALANCE = -500;
    public static final int AMOUNT_910_MONEY = 910;
    public static final int AMOUNT_899_MONEY = 889;
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
        assertEquals(INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_INITIAL_BALANCE);
        assertEquals(DEPOSIT_INITIAL_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
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
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(AMOUNT_10_MONEY);
        assertEquals(AMOUNT_990_MONEY, this.goldAccount.getBalance());
    }

    @Test
    public void testNegativeBalanceGoldAccount(){
        this.goldAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.goldAccount.withdraw(WITHDRAW_FOR_NEGATIVE_BALANCE);
        assertAll(
                () -> assertEquals(NEGATIVE_BALANCE, goldAccount.getBalance()),
                () -> assertThrows(IllegalStateException.class, () -> goldAccount.withdraw(WITHDRAW_FOR_NEGATIVE_BALANCE))
        );
    }

    @Test
    public void testBronzeAccountFeeLessThanOverdraft(){
        this.bronzeAccount.deposit(DEPOSIT_INITIAL_BALANCE);
        this.bronzeAccount.withdraw(WITHDRAW_LESS_THAN_100);
        assertEquals(AMOUNT_910_MONEY, this.bronzeAccount.getBalance());
    }

    @Test
    public void testBronzeAccountFeeMoreThanOverdraft(){
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
