/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import java.util.ArrayList;

public class Garage {

    private ArrayList<ParkingSpot> spotsList = new ArrayList<ParkingSpot>();
    private ArrayList<String> licenses = new ArrayList<String>();
    private int chargeCar;
    private int chargeMoto;
    private int emptySpots;
    private int spots;
    private int moneyTotal;

    //Garage Constractor
    public Garage(int chargeCar, int chargeMoto, int spots) {
        this.chargeCar = chargeCar;
        this.chargeMoto = chargeMoto;
        this.spots = spots;
        this.emptySpots = spots;

        for (int i = 1; i < spots + 1; i++) {
            spotsList.add(new ParkingSpot(i));
        }
        this.moneyTotal = 0;
    }

    //Check if vehicle can be parked, 
    //If yes park it
    //Else print error msg
    public String parkVehicle(Vehicle vehicle, int driverID, int employeeID) {

        //Find a free parking spot and park the vehicle 
        int spotID = 0;
        for (ParkingSpot spot : spotsList) {
            if (spot.isEmpty()) {
                spotID = spot.parkVehicle(vehicle, employeeID, driverID);
                break;
            }
        }
        emptySpots--;
        licenses.add(Integer.toString(driverID));
        return "Vehicle " + vehicle.getPlate() + " parked in spot " + spotID + ".";
    }

    //With discount
    public String parkVehicleD(Vehicle vehicle, int driverID, int employeeID) {

        //Find a free parking spot and park the vehicle 
        int spotID = 0;
        for (ParkingSpot spot : spotsList) {
            if (spot.isEmpty()) {
                spotID = spot.parkVehicleD(vehicle, employeeID, driverID);
                break;
            }
        }
        emptySpots--;
        licenses.add(Integer.toString(driverID));
        return "Vehicle " + vehicle.getPlate() + " parked in spot " + spotID + ".";
    }

    //Vehicle leaves the garage
    public String removeVehicle(String plate) {

        //Look where the vehicle was parked
        ParkingSpot parkingSpot = new ParkingSpot();
        for (ParkingSpot spot : spotsList) {
            if (spot.getVehicleParked().getPlate().equalsIgnoreCase(plate)) {
                parkingSpot = spot;
                break;
            }
        }

        int minutes = parkingSpot.removeVehicle() / 1000;

        //check for discount
        int hours = minutes / 60;
        if (minutes % 60 != 0) {
            hours++;
        }

        int totalCost;

        //Charge different amounts depending on vehicle type
        if (parkingSpot.getVehicleParked().getType() == 1) {

            totalCost = hours * chargeCar;

        } else {
            totalCost = hours * chargeMoto;
        }
        moneyTotal += totalCost;
        emptySpots++;

        licenses.remove(Integer.toString(parkingSpot.getOwnerID()));

        return "Vehicle " + plate + " was removed from garage. \nIt is charged for " + hours + " hours with the total cost of: " + totalCost + " euros.";

    }

    public int getEmptySpots() {
        return emptySpots;
    }

    public int getSpots() {
        return spots;
    }

    public int getMoneyTotal() {
        return moneyTotal;
    }

    public boolean isFull() {
        if (emptySpots == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Set Parking Spots of Garage
    public void setSpots(int spots) {
        this.spots = spots;
        this.emptySpots = spots;
    }

    public void setCarCharge(int charge) {
        this.chargeCar = charge;
    }

    public void setMotoCharge(int charge) {
        this.chargeMoto = charge;
    }

    //Checks if customer has already left a car
    public boolean hasCustomerComeBy(int driverID) {

        boolean flag = false;
        String temp;
        for (String idl : licenses) {
            temp = Integer.toString(driverID);
            if (idl.equals(temp)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

//Check if garage is full
    public boolean garagefull() {

        if (emptySpots == 0) {
            System.out.println("Vehicle can't be parked, garage is full.");
            System.out.println("The customer left");

            return true;
        }
        return false;
    }
}
