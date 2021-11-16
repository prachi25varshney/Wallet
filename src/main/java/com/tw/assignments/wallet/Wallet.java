package com.tw.assignments.wallet;

import com.tw.assignments.wallet.exceptions.WalletAmountIsInsufficientException;

public class Wallet extends RuntimeException {

    private Money balance;

    public Wallet() {
        balance = new Money(0);
    }

    public void add(Money money) {
        setBalance(new Money(balance.getAmount() + money.getAmount()));
    }

    public void withdraw(Money money) {
        if (balance.getAmount() < money.getAmount())
            throw new WalletAmountIsInsufficientException("Total Amount In Wallet is less than Withdrawing amount.");
        setBalance(new Money(balance.getAmount() - money.getAmount()));
    }

    public Money balance(Currency preferredCurrency) {
        return new Money(balance.getAmount() / preferredCurrency.baseFactor);
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
