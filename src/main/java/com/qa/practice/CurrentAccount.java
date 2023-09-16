package com.qa.practice;

public class CurrentAccount extends Account {

    public CurrentAccount(Customer accHolder) {
        super(accHolder);
        this.setAllowCards(true);
        this.setAllowWithdrawals(true);
        this.setAllowMinors(false);
    }
}
