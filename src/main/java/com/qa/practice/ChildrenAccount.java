package com.qa.practice;

public class ChildrenAccount extends Account{

    public ChildrenAccount(Customer children, Customer legalGuardian) {
        super(legalGuardian);
        this.setAllowCards(false);
        this.setAllowWithdrawals(false);
        this.setAllowMinors(true);
        this.addAccountHolders(children);
    }
}
