package com.qa.practice;

import com.qa.practice.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {

    Customer peter = new Customer("Peter", "Flack", "1990-10-15");
    Customer anna = new Customer("Anna", "Flack", "2000-12-01");

    CurrentAccount accPeter = new CurrentAccount(peter);
    CurrentAccount accAnna = new CurrentAccount(anna);


    @Test
    void testDeposit500() {
        accPeter.deposit(5000);
        Assertions.assertEquals(5000, accPeter.getBalance());
    }

    @Test
    void testWithdraw400() {
        accPeter.deposit(5000);
        accPeter.withdrawal(500);
        Assertions.assertEquals(4500, accPeter.getBalance());
    }

    @Test
    void testAddAnnaAsAccountHolder() {
        accPeter.addAccountHolders(anna);
        Assertions.assertEquals(2, accPeter.getAccountHolders().size());
    }

    @Test
    void testTransfer500FromPeterToAnna_PetterBalance() {
        accPeter.deposit(5000);
        accPeter.transfer(accAnna, 500);
        Assertions.assertEquals(4500, accPeter.getBalance());
    }

    @Test
    void testTransfer500FromPeterToAnna_AnnaBalance() {
        accPeter.deposit(5000);
        accPeter.transfer(accAnna, 500);
        Assertions.assertEquals(500, accAnna.getBalance());
    }

}


