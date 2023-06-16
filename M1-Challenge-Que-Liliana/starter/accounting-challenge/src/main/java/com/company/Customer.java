package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;

    /*
    List of AccountRecord objects
    charges is of type List<AccountRecord>
    each object of type Customer will have their own list of charges individually
     */
    private List<AccountRecord> charges = new ArrayList<>();
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //getBalance() method
    /*
    This method adds each AccountRecord object in the charges list we defined above.
    All of this totals the total balance which is returned.
     */
    public int getBalance() {
        int balance =0;
        for(AccountRecord records:charges){
            balance+= records.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {

        return charges;
    }

    @Override
    public String toString() {
        return "Customer ID: "+ id + " Name: "+ name + " Balance: " + getBalance();

    }
}
