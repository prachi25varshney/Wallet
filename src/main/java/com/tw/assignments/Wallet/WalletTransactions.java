package com.tw.assignments.Wallet;

public class WalletTransactions implements Wallet {

    boolean isMoneyWithdrawn;
    boolean isMoneyAdded;
    private int totalAmount;

    public WalletTransactions() {
    }

    @Override
    public void addMoney(int amount) {
        totalAmount+=amount;
        isMoneyAdded =true;
    }

    @Override
    public void withdrawMoney(int amount) {
        totalAmount-=amount;
        isMoneyWithdrawn = true;
    }
}
