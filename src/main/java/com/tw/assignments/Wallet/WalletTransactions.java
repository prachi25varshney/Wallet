package com.tw.assignments.Wallet;

public class WalletTransactions implements Wallet {

    boolean isMoneyWithdrawn;
    boolean isMoneyAdded;

    public WalletTransactions() {
    }

    @Override
    public void addMoney(Money amount) {
        isMoneyAdded =true;
    }

    @Override
    public void withdrawMoney(Money amount) {
        isMoneyWithdrawn = true;
    }
}
