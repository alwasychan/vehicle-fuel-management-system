package cseproject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Vehicle {
    private String id;
    private String model;
    private double fuelCapacity;
    private double currentFuel;

    public Vehicle(String id, String model, double fuelCapacity, double currentFuel) {
        this.id = id;
        this.model = model;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public double getFuelCapacity() { return fuelCapacity; }
    public double getCurrentFuel() { return currentFuel; }

    public void setCurrentFuel(double currentFuel) { this.currentFuel = currentFuel; }

    public abstract void displayInfo();

    public void refuel(double amount) throws Exception {
        if(amount <= 0) throw new Exception("Fuel amount must be greater than zero.");
        if(currentFuel + amount > fuelCapacity) throw new Exception("Cannot refuel. Fuel capacity exceeded.");
        currentFuel += amount;
    }

    public void consumeFuel(double amount) throws Exception {
        if(amount <= 0) throw new Exception("Fuel usage must be greater than zero.");
        if(amount > currentFuel) throw new Exception("Not enough fuel.");
        currentFuel -= amount;
    }
}

class Car extends Vehicle {
    private int seats;

    public Car(String id, String model, double fuelCapacity, double currentFuel, int seats) {
        super(id, model, fuelCapacity, currentFuel);
        this.seats = seats;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car");
        System.out.println("ID: " + getId());
        System.out.println("Model: " + getModel());
        System.out.println("Seats: " + seats);
        System.out.println("Fuel Capacity: " + getFuelCapacity() + " L");
        System.out.println("Current Fuel: " + getCurrentFuel() + " L");
        System.out.println("-----------------------------");
    }
}

class Bike extends Vehicle {
    private String type;

    public Bike(String id, String model, double fuelCapacity, double currentFuel, String type) {
        super(id, model, fuelCapacity, currentFuel);
        this.type = type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike");
        System.out.println("ID: " + getId());
        System.out.println("Model: " + getModel());
        System.out.println("Type: " + type);
        System.out.println("Fuel Capacity: " + getFuelCapacity() + " L");
        System.out.println("Current Fuel: " + getCurrentFuel() + " L");
        System.out.println("-----------------------------");
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String id, String model, double fuelCapacity, double currentFuel, double loadCapacity) {
        super(id, model, fuelCapacity, currentFuel);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck");
        System.out.println("ID: " + getId());
        System.out.println("Model: " + getModel());
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Fuel Capacity: " + getFuelCapacity() + " L");
        System.out.println("Current Fuel: " + getCurrentFuel() + " L");
        System.out.println("-----------------------------");
    }
}

class FuelManagementSystem {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Vehicle findVehicle(String id) throws Exception {
        for(Vehicle v : vehicles) {
            if(v.getId().equals(id)) return v;
        }
        throw new Exception("Vehicle with ID " + id + " not found.");
    }

    public void showAll() {
        for(Vehicle v : vehicles) v.displayInfo();
    }
}

public class Cseproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuelManagementSystem system = new FuelManagementSystem();

        system.addVehicle(new Car("C1", "Toyota", 50, 20, 5));
        system.addVehicle(new Bike("B1", "Yamaha", 15, 8, "Sport"));
        system.addVehicle(new Truck("T1", "Volvo", 150, 90, 12));

        while(true) {
            System.out.println("\n===== Vehicle Fuel Management System =====");
            System.out.println("1. Show All Vehicles");
            System.out.println("2. Refuel a Vehicle");
            System.out.println("3. Use Fuel");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                if(choice == 1) {
                    System.out.println("\n--- Vehicle List ---");
                    system.showAll();
                }
                else if(choice == 2) {
                    System.out.print("\nEnter Vehicle ID (C1/B1/T1): ");
                    String id = sc.nextLine();
                    Vehicle v = system.findVehicle(id);

                    System.out.print("Enter fuel amount to add (in liters): ");
                    double amt = sc.nextDouble();
                    v.refuel(amt);

                    System.out.println("Refuel successful.");
                    System.out.println("Updated Fuel: " + v.getCurrentFuel() + " L");
                }
                else if(choice == 3) {
                    System.out.print("\nEnter Vehicle ID (C1/B1/T1): ");
                    String id = sc.nextLine();
                    Vehicle v = system.findVehicle(id);

                    System.out.print("Enter fuel amount to use (in liters): ");
                    double amt = sc.nextDouble();
                    v.consumeFuel(amt);

                    System.out.println("Fuel usage successful.");
                    System.out.println("Updated Fuel: " + v.getCurrentFuel() + " L");
                }
                else if(choice == 4) {
                    System.out.println("Exiting system...");
                    break;
                }
                else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Please enter numbers only.");
                sc.nextLine();
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
         