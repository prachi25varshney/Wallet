package com.tw.assignments.wallet.exceptions;

public class WalletAmountIsInsufficientException extends RuntimeException {
    public WalletAmountIsInsufficientException(String message) {
        super(message);
    }
}
