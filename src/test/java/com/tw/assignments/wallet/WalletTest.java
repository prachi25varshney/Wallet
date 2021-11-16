package com.tw.assignments.wallet;

import com.tw.assignments.wallet.exceptions.WalletAmountIsInsufficientException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    @Test
    public void shouldReturnTrueWhenMoneyAddedInWallet() {

        Wallet wallet = new Wallet();
        Money rupee = Money.createRupee(1);
        Money dollar = Money.createDollar(1);
        Money money = new Money(75.85);

        wallet.add(rupee);
        wallet.add(dollar);

        assertThat(money, is(equalTo(wallet.balance(Currency.Rupee))));
    }

    @Test
    public void shouldReturnTrueWhenMoneyWithdrawnFromWallet() {

        Wallet wallet = new Wallet();
        Money rupee = Money.createRupee(1);
        Money money = new Money(0);

        wallet.add(rupee);
        wallet.withdraw(rupee);

        assertThat(money, is(equalTo(wallet.balance(Currency.Rupee))));
    }

    @Test
    void shouldReturnWhenAbleToWithdrawTenRupeesFromWallet() {
        Money rupee = Money.createRupee(10);
        Money dollar = Money.createDollar(1);
        Money money = new Money(64.85);
        Wallet wallet = new Wallet();

        wallet.add(dollar);
        wallet.withdraw(rupee);

        assertThat(money, is(equalTo(wallet.balance(Currency.Rupee))));

    }

    @Test
    public void shouldEquateTotalMoneyInRupeesWhenPreferredCurrencyIsRupees() {

        Money rupee = Money.createRupee(50);
        Money dollar = Money.createDollar(1);
        Money balance = new Money(124.85);
        Wallet wallet = new Wallet();

        wallet.add(rupee);
        wallet.add(dollar);

        assertThat(balance, is(equalTo(wallet.balance(Currency.Rupee))));
    }

    @Test
    public void shouldEquateTotalMoneyInDollars() {
        Money firstRupee = Money.createRupee(74.85);
        Money dollar = Money.createDollar(1);
        Money secondRupee = Money.createRupee(149.7);
        Money balance = new Money(4.0);
        Wallet wallet = new Wallet();

        wallet.add(firstRupee);
        wallet.add(dollar);
        wallet.add(secondRupee);

        assertThat(balance, is(equalTo(wallet.balance(Currency.Dollar))));
    }

    @Test
    void shouldThrowWalletAmountIsInsufficientExceptionWhenWithdrawAmountIsMoreThanTotalInWallet() {
        Money rupee = Money.createRupee(10);
        Money dollar = Money.createDollar(1);
        Wallet wallet = new Wallet();

        wallet.add(rupee);

        Assertions.assertThrows(WalletAmountIsInsufficientException.class, () -> wallet.withdraw(dollar));
    }
}
