package com.qa.practice;

import com.qa.practice.exceptions.InsufficientFundsException;
import com.qa.practice.exceptions.MinorsNotAllowedException;
import com.qa.practice.exceptions.WithdrawalNotAllowedException;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private double balance;
    private boolean allowCards;
    private boolean allowWithdrawals;

    private boolean allowMinors;
    private double interest;
    private List<Customer> accountHolders= new ArrayList<>();

    // Constructor
    public Account(Customer accHolder) {
        this.balance = 0;
        this.interest = 0;
        if (allowMinors) {
            this.accountHolders.add(accHolder);
        } else {
            if (accHolder.getAge() >= 18) {
                this.accountHolders.add(accHolder);
            } else {
                throw new MinorsNotAllowedException("Under 18 years old not allowed in this account.");
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isAllowCards() {
        return allowCards;
    }

    public void setAllowCards(boolean allowCards) {
        this.allowCards = allowCards;
    }

    public boolean isAllowWithdrawals() {
        return allowWithdrawals;
    }

    public void setAllowWithdrawals(boolean allowWithdrawals) {
        this.allowWithdrawals = allowWithdrawals;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public boolean isAllowMinors() {
        return allowMinors;
    }

    public void setAllowMinors(boolean allowMinors) {
        this.allowMinors = allowMinors;
    }

    public List<Customer> getAccountHolders() {
        return accountHolders;
    }

    public void printAccountHolders() {
        System.out.println("Account holders:");
        for (Customer c:accountHolders) {
            System.out.println("id: " + c.getCustomerID() + " Customer: " + c.getFullName());
        }
    }

    public void addAccountHolders(Customer accHolder) {
        if (allowMinors) {
            this.accountHolders.add(accHolder);
        } else {
            if (accHolder.getAge() >= 18) {
                this.accountHolders.add(accHolder);
            } else {
                throw new MinorsNotAllowedException("Under 18 years old not allowed in this account.");
            }
        }
    }

    public boolean transfer(Account accTransferTO, double amount) {
        if (this.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in the account, transfer aborted.");
        } else {
            this.balance -= amount;
            accTransferTO.balance += amount;
            System.out.println("Transfer executed.");
            return true;
        }
    }

    public void withdrawal(double amount) {
        if (!this.allowWithdrawals) {
            throw new WithdrawalNotAllowedException("Withdrawals not allowed from this account.");
        } else if (this.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds, overdraft not allowed. Withdrawal aborted.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal executed.");
        }
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
