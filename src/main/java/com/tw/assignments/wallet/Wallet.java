package com.tw.assignments.wallet;

public interface Wallet {
    public void addMoney(Money amount);

    public void withdrawMoney(Money amount);

    public double totalMoneyInWallet();
}
