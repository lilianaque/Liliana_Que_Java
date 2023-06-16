package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this
        List<Customer> allCustomers = customerRecord(customerData);
        System.out.println("Positive accounts:");
        for (Customer individual : allCustomers ){
            if(individual.getBalance()>0){
                System.out.println(individual);
            }
        }
        System.out.println("Negative accounts:");
        for (Customer individual : allCustomers ){
            if(individual.getBalance()<0){
                System.out.println(individual);
            }
        }
    }
    private static List<Customer> customerRecord(List<String[]> customerData) {
        List<Customer> individualCustomer = new ArrayList<>();
        //int amountCharged = 0;
        //String dateCharged = null;
        for (String[] customerInfo : customerData) {
            //customerInfo is a singular string array that we want to parse through and it's amongst numerous other arrays.
            int id = Integer.parseInt(customerInfo[0]);
            String name = customerInfo[1];
            int charge = Integer.parseInt(customerInfo[2]);
            String dateCharged = customerInfo[3];


            AccountRecord record = new AccountRecord();
            record.setCharge(charge);
            record.setChargeDate(dateCharged);

            /*
                person is a new variable of type Customer and it calls the findExistingCustomer class
                Here we check if the customer already exists in our records and if not, we create a new customer
             */
            Customer person = existingCustomer(individualCustomer,id);
            if (person == null) {
                person = new Customer();
                person.setId(id);
                person.setName(name);
                individualCustomer.add(person);
            }
            person.getCharges().add(record);
        }
        return individualCustomer;
    }

    private static Customer existingCustomer(List<Customer> individualCustomer, int id) {
        for (Customer person : individualCustomer){
            if(person.getId()==id){
                return person;
            }
        }
        return null;
    }
}

/*
I want to convert the customerData which is a List<String[]> to something
that allows each customer to have their own unique customer record
I need a class that allows me to do this.
This class would extract every detail in customerData: The first number = id, name, amount charged, and
date charged would be taken from this String array and moves them to different
objects I've made.
Maybe I could do this with a for loop that goes through the customerData

for (String[] customerInfo:customerData) because customerData is a String[]
String name = customerInfo[1]
for id I may need to do some conversion but for now
String id=customerInfo[0]
String amountCharged = customerInfo[2]
String dateCharged=customerInfo[3]
I'll do conversions in my actual code
 */

