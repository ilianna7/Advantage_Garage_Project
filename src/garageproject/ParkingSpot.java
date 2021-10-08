/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import java.util.concurrent.TimeUnit;

public class ParkingSpot {

    private boolean empty;
    private int parkedBy;
    private Vehicle vehicleParked;
    private int spotID;
    private long timeParked;
    private int ownerID;

    //Constractors
    public ParkingSpot() {
    }

    public ParkingSpot(int spotID) {
        this.spotID = spotID;
        this.empty = true;
    }

    //Park car to spot
    public int parkVehicle(Vehicle vehicle, int employeeID, int ownerID) {
        this.empty = false;
        this.vehicleParked = vehicle;
        this.parkedBy = employeeID;
        this.timeParked = System.currentTimeMillis();
        this.ownerID = ownerID;
        return this.spotID;
    }

    public int parkVehicleD(Vehicle vehicle, int employeeID, int ownerID) {
        this.empty = false;
        this.vehicleParked = vehicle;
        this.parkedBy = employeeID;
        this.timeParked = System.currentTimeMillis() + 30 * 60 * 60;
        this.ownerID = ownerID;
        return this.spotID;
    }

    //Unpark car from spot
    public int removeVehicle() {
        this.empty = true;
        long timeLeft = System.currentTimeMillis();
        int totalTime = (int) (timeLeft - timeParked);
        return totalTime;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getParkedBy() {
        return parkedBy;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }

    public int getSpotID() {
        return spotID;
    }

    public int getTimeParked() {
        long timeLeft = System.currentTimeMillis();
        long totalTime = timeLeft - timeParked;
        if (totalTime < 0) {
            totalTime = 0;
        }

        return (int) totalTime;
    }

    public int getOwnerID() {
        return ownerID;
    }

}
