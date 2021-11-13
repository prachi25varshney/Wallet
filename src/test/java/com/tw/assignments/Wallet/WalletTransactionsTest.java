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
    public void shouldEquateTotalMoneyInRupees() {

        Money rupee = Money.createRupee(50);
        Money dollar = Money.createDollar(1);
        WalletTransactions wallet =  new WalletTransactions();

        wallet.addMoney(rupee);
        wallet.addMoney(dollar);

        assertThat(124.85,is(equalTo(wallet.totalMoneyInWallet())));
    }
}
