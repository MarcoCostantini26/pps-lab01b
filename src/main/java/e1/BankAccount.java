package e1;

public interface BankAccount {
    /**
     * Get balance
     *
     * @return amount of balance
     */
    int getBalance();

    /**
     * Deposit amount in bank account
     *
     * @param amount amount of money deposited.
     */
    void deposit(int amount);

    /**
     * Amount of money to withdraw
     *
     * @param amount money to withdraw.
     */
    void withdraw(int amount);
}
