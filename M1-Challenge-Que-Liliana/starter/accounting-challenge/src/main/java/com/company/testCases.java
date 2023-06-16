package com.company;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class testCases {
    @Test
    void getBalanceTest(){
        Customer celebrity = new Customer();
        AccountRecord andrewsRecord=new AccountRecord();
        andrewsRecord.setCharge(100000);
        celebrity.getCharges().add(andrewsRecord);
        assertEquals(100000, celebrity.getBalance());

    }

    @Test
    void toStringTest() {
        Customer celebrity = new Customer();
        celebrity.setId(Integer.parseInt("100"));
        celebrity.setName("Andrew Garfield");

        AccountRecord andrewsRecord=new AccountRecord();
        andrewsRecord.setCharge(1000000);
        celebrity.getCharges().add(andrewsRecord);
        assertEquals(("Customer ID: "+ 100 + " Name: "+ "Andrew Garfield " + "Balance: 1000000"), celebrity.toString());
    }

        }
