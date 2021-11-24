package com.tw.assignments.wallet;

public class Wallet {

    private Money balance;

    public Wallet() {
        balance = new Money(0, Currency.Rupee);
    }

    public void add(Money money) {
        balance = Money.addMoney(balance, money);
    }

    public void withdraw(Money money) {

        balance = Money.withdrawMoney(balance, money);
    }

    public Money balance(Currency preferredCurrency) {
        return Money.moneyInPreferredCurrency(balance, preferredCurrency);
    }
}
