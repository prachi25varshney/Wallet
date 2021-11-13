package com.tw.assignments.Wallet;

enum Currency{
    Rupee(1), Dollar(74.85);

    private double baseFactor;

    Currency(double baseFactor){
        this.baseFactor = baseFactor;
    }
    public double multiplyWithBaseFactor(double value){
        return value*baseFactor;
    }
}
public class Money {
    private double money;
    private Currency currency;

    public Money(double money, Currency currency) {
        this.money = money;
        this.currency = currency;
    }

    public static Money createRupee(double rupee) {
        return new Money(rupee, Currency.Rupee);
    }


    public static Money createDollar(double dollar) {
        return new Money(dollar, Currency.Dollar);
    }
}
