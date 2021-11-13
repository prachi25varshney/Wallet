package com.tw.assignments.Wallet;

import org.hamcrest.Matcher;

public class WalletTransactions implements Wallet {

    private double totalMoney;
    private boolean isMoneyWithdrawn;
    private boolean isMoneyAdded;
    Currency currency;

    public WalletTransactions() {
    }

    @Override
    public void addMoney(Money amount) {
        isMoneyAdded =true;
        totalMoney+=amount.getAmount();
    }

    @Override
    public void withdrawMoney(Money amount) {
        isMoneyWithdrawn = true;
        totalMoney-= amount.getAmount();
    }

    @Override
    public double totalMoneyInWallet() {
        return totalMoney;
    }

    public boolean isMoneyAdded() {
        return isMoneyAdded;
    }

    public boolean isMoneyWithdrawn() {
        return isMoneyWithdrawn;
    }

    public double totalMoneyInWalletInDollars() {
        return totalMoneyInWallet()/74.85;
    }
}
