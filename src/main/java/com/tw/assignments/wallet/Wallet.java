package com.tw.assignments.wallet;

public class Wallet {

    private Money balance;

    public Wallet() {
        balance = new Money(0, Currency.Rupee);
    }

    public void add(Money money) {
        balance = balance.addMoney(money);
    }

    public void withdraw(Money money) {

        balance = balance.withdrawMoney(money);
    }

    public Money balance(Currency preferredCurrency) {
        return balance.moneyInPreferredCurrency(preferredCurrency);
    }
}
