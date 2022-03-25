package com.company;

import java.util.ArrayList;

public class Booking {
    private static String[] locations = {"A", "B", "C", "D", "E", "F"};
    private static int[] numberedLocations = {1,2,3,4,5,6};
    private Customer customer;
    private Taxi taxi;
    private int pickupPoint;
    private int dropPoint;
    private int pickupTime;
    private int dropTime;
    private int duration;
    private int distance;
    private int fare;

    public Booking(Customer customer, Taxi taxi, int pickupPoint, int dropPoint, int pickupTime, int fare){
        if(isAnyBusy(taxi, customer)){
            return;
        } else if(isValidPickAndDrop(pickupPoint, dropPoint) == false){
            return;
        }
        taxi.setBusy(true);
        customer.setBusy(true);
        this.customer = customer;
        this.taxi = taxi;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.distance = calculateDistance(pickupPoint, dropPoint);
        this.fare = calculateFare();
        setDropTimeAndDuration();
    }

    public Booking(Customer customer, Taxi[] taxis, int pickupPoint, int dropPoint, int pickupTime){
        if(isValidPickAndDrop(pickupPoint, dropPoint) == false){
            return;
        }
        Taxi closestFreeTaxi = getFreeTaxi(taxis, pickupPoint);
        if(closestFreeTaxi == null){
            return;
        }
        closestFreeTaxi.setBusy(true);
        customer.setBusy(true);
        this.customer = customer;
        this.taxi = closestFreeTaxi;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.distance = calculateDistance(pickupPoint, dropPoint);
        this.fare = calculateFare();
        setDropTimeAndDuration();

        this.taxi.addEarning(fare);
        this.taxi.setLocation(dropPoint);
    }

    public boolean isAnyBusy(Taxi t, Customer c){
        if(t.isBusy()){
            System.out.println("Taxi is busy");
            return true;
        }else if(c.isBusy()){
            System.out.println("Customer is already in ride");
            return true;
        }
        return false;
    }

    public boolean isValidPickAndDrop(int pickupPoint, int dropPoint){
        if(pickupPoint < 1 || pickupPoint > 6 || dropPoint < 1 || dropPoint > 6){
            System.out.println("Enter valid pickup and drop points in range of 1 to 6");
            return false;
        }
        return true;
    }

    public int calculateDistance(int pickupPoint, int dropPoint){
        int distance = dropPoint > pickupPoint ? (dropPoint - pickupPoint) : (pickupPoint - dropPoint);
//        System.out.println("Distance is : " + distance);
        distance = distance*15;
        return distance;
    }

    public int calculateFare(){
        if(this.distance > 5){
            return 100 + (this.distance - 5) * 10;
        }else{
            return 100;
        }
    }

    private void setDropTimeAndDuration(){
        this.duration = this.distance/15;
        this.dropTime = this.pickupTime + this.duration;
    }

    private Taxi getFreeTaxi(Taxi[] taxis, int pickupPoint){
        Taxi closestFreeTaxi = null;
        int distance;
        int closestDistance = Integer.MAX_VALUE;
        for(Taxi t : taxis){
            distance = calculateDistance(pickupPoint, t.getLocation());
            if(t.isBusy() == false && distance <= closestDistance){
                if(distance == closestDistance && closestFreeTaxi != null){
                    if(t.getEarning() < closestFreeTaxi.getEarning()){
                        closestDistance = distance;
                        closestFreeTaxi = t;
                    }
                }else{
                    closestDistance = distance;
                    closestFreeTaxi = t;
                }
            }
        }

        if(closestFreeTaxi == null){
            System.out.println("No Free taxi at the moment. Please try again.");
        }
        return closestFreeTaxi;
    }

    public static void details(ArrayList<Booking> bookings){
        System.out.println("Booking ID\tCustomer\tTaxi\tPickup Point\tDrop Point\tPickup Time\tDrop Time\tDuration\tDistance\tFare");
        for(int i=0; i<bookings.size(); i++){
            Booking booking = bookings.get(i);
            System.out.println("\t" + i+1 + "\t\t\t" + booking.getCustomer().getCustomerName() + "\t\t" + booking.getTaxi().getId()+ "\t\t\t" + booking.getPickupPoint()
                    + "\t\t\t\t" + booking.getDropPoint() + "\t\t\t" + booking.getPickupTime() + "\t\t\t" + booking.getDropTime() + "\t\t\t" + booking.getDuration()
                    + "\t\t\t" + booking.getDistance() + "\t\t" + booking.getFare());
        }
    }

    public void clearBooking(){
        taxi.setBusy(false);
        customer.setBusy(false);
    }

//    GETTERS START
    public Customer getCustomer() {
        return customer;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public int getPickupPoint() {
        return pickupPoint;
    }

    public int getDropPoint() {
        return dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getDistance() {
        return distance;
    }

    public int getFare() {
        return fare;
    }
//    GETTERS END
}
