package com.company;

public class Taxi {
    private static int taxiCount=0;
    private static int maxTaxiCount=5;
    private int id;
    private int location = 1;
    private int earning = 0;
    private boolean isBusy = false;

    public Taxi() {
        if(taxiCount > maxTaxiCount){
            System.out.println("Max taxi's limit is reached. Cannot add new Taxi's");
            return;
        }
        taxiCount++;
        this.id = taxiCount;
    }

    public static void setMaxTaxiCount(int maxTaxiCount) {
        Taxi.maxTaxiCount = maxTaxiCount;
    }

    public int getLocation() {
        return location;
    }

    public int getEarning() {
        return earning;
    }

    public int getId(){
        return id;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void addEarning(int add) {
        this.earning += add;
    }
}
