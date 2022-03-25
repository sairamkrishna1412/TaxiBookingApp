package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int noOfTaxis;
        Taxi[] taxis;
        Taxi newTaxi;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer activeCustomer = null;
        Booking booking = null;
        ArrayList<Booking> bookings = new ArrayList<Booking>();
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of taxis : ");
        noOfTaxis = Integer.parseInt(sc.nextLine());
        Taxi.setMaxTaxiCount(noOfTaxis);
        taxis = new Taxi[noOfTaxis];
        for(int i=0; i<noOfTaxis; i++){
            newTaxi = new Taxi();
            taxis[i] = newTaxi;
        }

        askQuestion(activeCustomer, customers, booking, bookings, taxis);
//        if(activeCustomer == null){
//            int ch;
//            do{
//                String email, password, name;
//                System.out.println("\nWelcome to Taxii : ");
//                System.out.println("1.Login\n2.Signup\n3.Exit");
//                ch = Integer.parseInt(sc.nextLine());
//                switch (ch){
//                    case 1:
//                        System.out.println("Enter email : ");
//                        email = sc.nextLine().trim();
//                        System.out.println("Enter password : ");
//                        password = sc.nextLine().trim();
//                        activeCustomer = Customer.Login(email, password, customers);
//                        break;
//                    case 2:
//                        System.out.println("Enter name : ");
//                        name = sc.nextLine().trim();
//                        System.out.println("Enter email : ");
//                        email = sc.nextLine().trim();
//                        System.out.println("Enter password : ");
//                        password = sc.nextLine().trim();
//                        activeCustomer = new Customer(name, email, password, customers);
//                        break;
//                    case 3:
//                        System.out.println("Logging out");
//                        activeCustomer = null;
//                        booking = null;
//                        bookings.clear();
//                        break;
//                }
//            }while (ch != 3 && activeCustomer == null);
//        }
//
//        if(activeCustomer != null){
//            System.out.println("Logged in as "+ activeCustomer.getCustomerName());
//            if(activeCustomer.isBusy()){
//                System.out.println("You are currently on a ride");
//            }else {
//                System.out.println("You are not travelling. Please book a ride.");
//            }
//
//            int ch;
//            do{
//                System.out.println("1. Booking\n2. Details\n3.Logout\n4. Exit");
//                ch = Integer.parseInt(sc.nextLine());
//                switch (ch){
//                    case 1:
//                        int pickup, drop, pickupTime;
//                        if(activeCustomer.isBusy()){
//                            System.out.println("You are already on a ride.");
//                            break;
//                        }
//                        System.out.println("Enter pickup point : ");
//                        pickup = Integer.parseInt(sc.nextLine());
//                        System.out.println("Enter drop point : ");
//                        drop = Integer.parseInt(sc.nextLine());
//                        System.out.println("Enter pickup time : ");
//                        pickupTime = Integer.parseInt(sc.nextLine());
//                        booking = new Booking(activeCustomer, taxis, pickup, drop, pickupTime);
//
//                        if(booking != null){
//                            bookings.add(booking);
//                            System.out.println("Booking successful");
//                            System.out.println("Taxi : " + booking.getTaxi().getId());
//                            System.out.println("Pickup point : " + booking.getPickupPoint());
//                            System.out.println("Drop point : " + booking.getDropPoint());
//                            System.out.println("Pickup time : " + booking.getPickupTime());
//                            System.out.println("Drop time : " + booking.getDropTime());
//                            System.out.println("Duration : " + booking.getDuration());
//                            System.out.println("Distance : " + booking.getDistance());
//                            System.out.println("Fare : " + booking.getFare());
//                        }
//                        break;
//
//                    case 2:
//                        Booking.details(bookings);
//                        break;
//                    case 3:
//                        activeCustomer = null;
//                        break;
//                }
//            }while (ch != 4 && activeCustomer != null);
//        }
//      if not logged in
//      choices are 1.login 2.signup
//      if logged in
//      choices are 1.booking 2.details 3.exit
    }

    public static void askQuestion(Customer activeCustomer, ArrayList<Customer> customers, Booking booking, ArrayList<Booking> bookings, Taxi[] taxis){
        Scanner sc = new Scanner(System.in);
        if(activeCustomer == null){
            int ch;
            do{
                String email, password, name;
                System.out.println("\nWelcome to Taxii : ");
                System.out.println("1.Login\n2.Signup\n3.Exit");
                ch = Integer.parseInt(sc.nextLine());
                switch (ch){
                    case 1:
                        System.out.println("Enter email : ");
                        email = sc.nextLine().trim();
                        System.out.println("Enter password : ");
                        password = sc.nextLine().trim();
                        activeCustomer = Customer.Login(email, password, customers);
                        break;
                    case 2:
                        System.out.println("Enter name : ");
                        name = sc.nextLine().trim();
                        System.out.println("Enter email : ");
                        email = sc.nextLine().trim();
                        System.out.println("Enter password : ");
                        password = sc.nextLine().trim();
                        activeCustomer = new Customer(name, email, password, customers);
                        if(activeCustomer != null){
//                            System.out.println("Adding new customer" + activeCustomer.getCustomerName());
                            customers.add(activeCustomer);
//                            System.out.println("Size after adding" + customers.size());
                        }
                        break;
                    case 3:
                        System.out.println("Closing app");
                        activeCustomer = null;
                        booking = null;
                        bookings.clear();
                        break;
                }
            }while (ch != 3 && activeCustomer == null);
        }

        if(activeCustomer != null){
            System.out.println("Logged in as "+ activeCustomer.getCustomerName());
            if(activeCustomer.isBusy()){
                System.out.println("You are currently on a ride");
            }else {
                System.out.println("You are not travelling. Please book a ride.");
            }

            int ch;
            do{
                System.out.println("1.Booking\n2.Details\n3.Logout\n4.Exit");
                ch = Integer.parseInt(sc.nextLine());
                switch (ch){
                    case 1:
                        int pickup, drop, pickupTime;
                        if(activeCustomer.isBusy()){
                            System.out.println("You are already on a ride.");
                            break;
                        }
                        System.out.println("Enter pickup point : ");
                        pickup = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter drop point : ");
                        drop = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter pickup time : ");
                        pickupTime = Integer.parseInt(sc.nextLine());
                        booking = new Booking(activeCustomer, taxis, pickup, drop, pickupTime);
                        System.out.println(booking);
                        if(booking != null && booking.getCustomer() != null && booking.getTaxi() != null){
                            bookings.add(booking);
                            System.out.println("Booking successful");
                            System.out.println("Taxi : " + booking.getTaxi().getId());
                            System.out.println("Pickup point : " + booking.getPickupPoint());
                            System.out.println("Drop point : " + booking.getDropPoint());
                            System.out.println("Pickup time : " + booking.getPickupTime());
                            System.out.println("Drop time : " + booking.getDropTime());
                            System.out.println("Duration : " + booking.getDuration());
                            System.out.println("Distance : " + booking.getDistance());
                            System.out.println("Fare : " + booking.getFare());
                        }
                        break;

                    case 2:
                        Booking.details(bookings);
                        break;
                    case 3:
                        activeCustomer = null;
//                        customers.clear();
//                        booking.clearBooking();
//                        bookings.remove(booking);
                        booking=null;
                        break;
                    case 4:
                        System.out.println("Closing app");
                        activeCustomer = null;
                        booking = null;
                        bookings.clear();
                        break;
                }
            }while (ch < 3 && activeCustomer != null);

            if(ch==3){
                askQuestion(activeCustomer, customers, booking, bookings, taxis);
            }
        }
    }
}
