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

        assertThat(true,is(equalTo(addMoney.isMoneyAdded)));
    }

    @Test
    public void shouldReturnTrueAbleToTakeMoneyFromWallet() {

        WalletTransactions withdrawMoney = new WalletTransactions();
        Money rupee = new Money(10,Currency.Rupee);

        withdrawMoney.withdrawMoney(rupee);

        assertThat(true, is(equalTo(withdrawMoney.isMoneyWithdrawn)));
    }
}
