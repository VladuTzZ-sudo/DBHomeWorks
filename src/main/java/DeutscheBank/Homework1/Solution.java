package DeutscheBank.Homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

abstract class Vehicle implements Comparable<Vehicle> {
    private String color;
    private boolean functional;

    public Vehicle() {
        color = null;
        functional = false;
    }

    public Vehicle(String color, boolean functional) {
        this.color = color;
        this.functional = functional;
    }

    public String getColor() {
        return color;
    }

    public boolean getFunctional() {
        return functional;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    public abstract void charge();

    public abstract float profit();

    public abstract void display();

    @Override
    public int compareTo(Vehicle o) {
        return (int) (profit() - o.profit());
    }
}

class Bus extends Vehicle {
    private int noPassengers;
    private float ticketPrice;

    public Bus() {
        super();
        noPassengers = 0;
        ticketPrice = 0;
    }

    public Bus(String color, boolean functional) {
        super(color, functional);
    }

    public Bus(int noPassengers, float ticketPrice) {
        super();
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public Bus(String color, boolean functional, int noPassengers, float ticketPrice) {
        super(color, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void charge() {
        if (getFunctional()) {
            noPassengers++;
        }
    }

    @Override
    public float profit() {
        return (getTicketPrice() * (float) getNoPassengers()) / 4;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    @Override
    public String toString() {
        return "Bus {" + '\t' +
                "color='" + getColor() + '\'' + '\t' +
                ", functional=" + getFunctional() + '\t' +
                ", noPassengers=" + getNoPassengers() + '\t' +
                ", ticketPrice=" + getTicketPrice() + '\t' +
                ", profit=" + profit() + '\t' +
                '}';
    }
}

class Taxi extends Vehicle {
    private int noPassengers;
    private float ticketPrice;

    public Taxi() {
        super();
        noPassengers = 0;
        ticketPrice = 0;
    }

    public Taxi(String color, boolean functional) {
        super(color, functional);
    }

    public Taxi(int noPassengers, float ticketPrice) {
        super();
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    public Taxi(String color, boolean functional, int noPassengers, float ticketPrice) {
        super(color, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public void charge() {
        if (getFunctional()) {
            noPassengers++;
        }
    }

    @Override
    public float profit() {
        return (getTicketPrice() * (float) getNoPassengers()) / 4;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getNoPassengers() {
        return noPassengers;
    }

    @Override
    public String toString() {
        return "Taxi {" + '\t' +
                "color='" + getColor() + '\'' + '\t' +
                ", functional=" + getFunctional() + '\t' +
                ", noPassengers=" + getNoPassengers() + '\t' +
                ", ticketPrice=" + getTicketPrice() + '\t' +
                ", profit=" + profit() + '\t' +
                '}';
    }
}

class BusStation {
    private final ArrayList<Vehicle> vehicles;

    public BusStation() {
        vehicles = new ArrayList<Vehicle>();
    }

    public void showAllVehicles() {
        System.out.println("All Vehicles");
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
        }
    }

    public void showTotalProfit() {
        float total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.profit();
        }

        System.out.println("Total profit: " + total);
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    public void sortVehicles() {
        Collections.sort(vehicles);
    }
}

public class Solution {
    public static void main(String[] args) {
        BusStation busStation = new BusStation();

        busStation.addVehicle(new Taxi("red", true, 4, 5));
        busStation.addVehicle(new Bus("blue", false, 0, 12));
        busStation.addVehicle(new Bus("purple", true, 7, 8));
        busStation.addVehicle(new Taxi("black", true, 1, 30));

        busStation.showAllVehicles();
        System.out.println();

        busStation.showTotalProfit();
        System.out.println();

        busStation.getVehicle(0).charge();
        busStation.getVehicle(2).charge();
        busStation.getVehicle(0).charge();
        busStation.getVehicle(1).charge();

        busStation.showAllVehicles();
        System.out.println();

        busStation.showTotalProfit();
        System.out.println();

        Bus bus = new Bus();
        bus.setColor("yellow");
        bus.setFunctional(false);
        bus.setNoPassengers(20);
        bus.setTicketPrice(2);

        busStation.addVehicle(bus);

        busStation.sortVehicles();

        busStation.showAllVehicles();
        System.out.println();

        busStation.showTotalProfit();
        System.out.println();

        Taxi taxi = new Taxi();
        taxi.setColor("orange");
        taxi.setFunctional(true);
        taxi.setNoPassengers(2);
        taxi.setTicketPrice(10);

        busStation.addVehicle(taxi);

        busStation.sortVehicles();

        busStation.showAllVehicles();
        System.out.println();

        busStation.showTotalProfit();
        System.out.println();
    }
}
