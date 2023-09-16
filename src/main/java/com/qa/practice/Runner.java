package com.qa.practice;

import com.qa.practice.exceptions.InsufficientFundsException;
import com.qa.practice.exceptions.MinorsNotAllowedException;
import com.qa.practice.exceptions.WithdrawalNotAllowedException;

public class Runner {


    public static void main(String[] args) {
        // Creation of customers and accounts for out bank
        try {
        Customer peter = new Customer("Peter", "Flack", "1990-10-15");
        Customer anna = new Customer("Anna", "Flack", "2000-12-01");
        Customer baby = new Customer("Sandra", "Flack", "2020-03-10");

        CurrentAccount accPeter = new CurrentAccount(peter);
        CurrentAccount accAnna = new CurrentAccount(anna);
        ChildrenAccount accBaby = new ChildrenAccount(baby, anna);

        System.out.println("Petter's balance: " + accPeter.getBalance());
        System.out.println("Anna's balance: " + accAnna.getBalance());
        System.out.println("Baby's balance: " + accBaby.getBalance());

        accPeter.deposit(5000);
        accPeter.transfer(accAnna, 1500);
        accAnna.transfer(accBaby, 300);
        System.out.println("Petter's balance: " + accPeter.getBalance());
        System.out.println("Anna's balance: " + accAnna.getBalance());
        System.out.println("Baby's balance: " + accBaby.getBalance());
        System.out.println("\n");

        // accBaby.withdrawal(50);
        // accAnna.transfer(accBaby, 4000);
        accBaby.printAccountHolders();

        System.out.println("\n");

        accPeter.addAccountHolders(anna);
        accPeter.printAccountHolders();
        accPeter.addAccountHolders(baby);
        accPeter.printAccountHolders();

        } catch (MinorsNotAllowedException mnae) {
            System.out.println("Minors not allowed in this type of account.\nOperation not executed");
        } catch (InsufficientFundsException ife) {
            System.out.println("Insufficient funds to proceed, overdrafts not allowed.");
        } catch (WithdrawalNotAllowedException wnae) {
            System.out.println("Withdrawals not allowed from this type of accounts.");
        }
    }
}