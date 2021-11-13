package com.tw.assignments.wallet;

import com.tw.assignments.wallet.exceptions.WalletAmountIsInsufficientException;

public class WalletTransactions extends RuntimeException implements Wallet {

    private double totalMoney;
    private boolean isMoneyWithdrawn;
    private boolean isMoneyAdded;

    public WalletTransactions() {
    }

    @Override
    public void addMoney(Money amount) {
        isMoneyAdded = true;
        totalMoney += amount.getAmount();
    }

    @Override
    public void withdrawMoney(Money amount) {
        if (totalMoney < amount.getAmount())
            throw new WalletAmountIsInsufficientException("Total Amount In Wallet is less than Withdrawing amount.");
        isMoneyWithdrawn = true;
        totalMoney -= amount.getAmount();
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
        return totalMoneyInWallet() / 74.85;
    }
}
