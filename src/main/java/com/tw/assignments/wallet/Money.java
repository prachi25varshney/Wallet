package com.tw.assignments.wallet;

enum Currency {
    Rupee(1), Dollar(74.85);

    double baseFactor;

    Currency(double baseFactor) {
        this.baseFactor = baseFactor;
    }
}

public class Money {
    private final double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public static Money createRupee(double rupee) {
        return new Money(rupee*Currency.Rupee.baseFactor);
    }

    public static Money createDollar(double dollar) {
        return new Money(dollar*Currency.Dollar.baseFactor);
    }

    public double getAmount() {
        return amount;
    }

}
