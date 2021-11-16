package com.tw.assignments.wallet;

import com.tw.assignments.wallet.exceptions.WalletAmountIsInsufficientException;

import java.util.Objects;

public class Wallet extends RuntimeException {

    private Money balance;

    public Wallet() {
        balance = new Money(0);
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public void add(Money money) { //add
        setBalance(new Money(balance.getAmount() + money.getAmount()));
    }

    public void withdraw(Money money) { //withdraw
        if (balance.getAmount() < money.getAmount())
            throw new WalletAmountIsInsufficientException("Total Amount In Wallet is less than Withdrawing amount.");
        setBalance(new Money(balance.getAmount() - money.getAmount()));
    }

    public Money balance() {
        return balance;
    }

}
