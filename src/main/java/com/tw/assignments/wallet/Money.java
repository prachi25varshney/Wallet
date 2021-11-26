package com.tw.assignments.wallet;

import com.tw.assignments.wallet.exceptions.WalletAmountIsInsufficientException;

enum Currency {
    Rupee(1), Dollar(74.85);

    private final double baseFactor;

    Currency(double baseFactor) {
        this.baseFactor = baseFactor;
    }

    public double convertMoney(double amount) {
        return amount * this.baseFactor;
    }

    public double getAmountInPreferredCurrency(double totalBalance, Currency preferredCurrency) {
        return totalBalance / preferredCurrency.baseFactor;
    }
}

public class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money createRupee(double rupee) {
        return new Money(rupee, Currency.Rupee);
    }

    public static Money createDollar(double dollar) {
        return new Money(dollar, Currency.Dollar);
    }

    public Money addMoney(Money money) {
        double currentBalance =this.currency.convertMoney(this.amount);
        double moneyToAdd = money.currency.convertMoney(money.amount);
        return new Money(currentBalance+ moneyToAdd , Currency.Rupee);
    }

    public Money withdrawMoney(Money money) {
        double currentBalance = this.currency.convertMoney(this.amount);
        double moneyToWithdraw = money.currency.convertMoney(money.amount);
        if (currentBalance < moneyToWithdraw)
            throw new WalletAmountIsInsufficientException("Total Amount In Wallet is less than Withdrawing amount.");
        return new Money(currentBalance - moneyToWithdraw, Currency.Rupee);
    }

    public Money moneyInPreferredCurrency(Currency preferredCurrency) {
        double totalBalance = this.currency.convertMoney(this.amount);
        return new Money(preferredCurrency.getAmountInPreferredCurrency(totalBalance, preferredCurrency), preferredCurrency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.amount == money.amount;
    }

}
