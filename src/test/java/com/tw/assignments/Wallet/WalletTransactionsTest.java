package com.tw.assignments.Wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTransactionsTest {

    @Test

    public void shouldReturnTrueWhenMoneyAddedInWallet() {

        WalletTransactions addMoney = new WalletTransactions();

        addMoney.addMoney(1);

        assertThat(true,is(equalTo(addMoney.isMoneyAdded)));
    }

    @Test
    public void shouldReturnTrueAbleToTakeMoneyFromWallet() {

        WalletTransactions withdrawMoney = new WalletTransactions();

        withdrawMoney.withdrawMoney(1);

        assertThat(true, is(equalTo(withdrawMoney.isMoneyWithdrawn)));
    }
}
