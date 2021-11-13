package com.tw.assignments.Wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTransactionsTest {

    @Test

    public void shouldReturnTrueWhenMoneyAddedInWallet() {

        WalletTransactions addMoney = new WalletTransactions();
        Money rupee = Money.createRupee(1);
        Money dollar = Money.createDollar(1);

        addMoney.addMoney(rupee);
        addMoney.addMoney(dollar);

        assertThat(true,is(equalTo(addMoney.isMoneyAdded())));
    }

    @Test
    public void shouldReturnTrueAbleToTakeMoneyFromWallet() {

        WalletTransactions withdrawMoney = new WalletTransactions();
        Money rupee = Money.createRupee(1);

        withdrawMoney.withdrawMoney(rupee);

        assertThat(true, is(equalTo(withdrawMoney.isMoneyWithdrawn())));
    }

    @Test
    void shouldReturnWhenAbleToWithdrawTenRupees() {
        Money rupee = Money.createRupee(10);
        Money dollar = Money.createDollar(1);
        WalletTransactions wallet =  new WalletTransactions();

        wallet.addMoney(dollar);
        wallet.withdrawMoney(rupee);

        assertThat(64.85,is(equalTo(wallet.totalMoneyInWallet())));
    }

    @Test
    public void shouldEquateTotalMoneyInRupees() {

        Money rupee = Money.createRupee(50);
        Money dollar = Money.createDollar(1);
        WalletTransactions wallet =  new WalletTransactions();

        wallet.addMoney(rupee);
        wallet.addMoney(dollar);

        assertThat(124.85,is(equalTo(wallet.totalMoneyInWallet())));
    }

    @Test
    public void shouldEquateTotalMoneyInDollars() {
        Money firstRupee = Money.createRupee(74.85);
        Money dollar = Money.createDollar(1);
        Money secondRupee = Money.createRupee(149.7);
        WalletTransactions wallet =  new WalletTransactions();

        wallet.addMoney(firstRupee);
        wallet.addMoney(dollar);
        wallet.addMoney(secondRupee);

        assertThat(4.0,is(equalTo(wallet.totalMoneyInWalletInDollars())));
    }
}
