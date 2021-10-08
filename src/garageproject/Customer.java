/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import java.util.ArrayList;

/**
 *
 * @author ilian
 */
public class Customer extends Human {
    
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private int licenseID;
    
    
    //Constractors
    public Customer(){}
    public Customer(String fname, String lname, int id,Vehicle vehicle){
        super(fname, lname);
        this.licenseID = id;
        
        vehicleList.add(vehicle);
    
    }
    
    //Get amount of vehicles the customer owns

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public int getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(int licenseID) {
        this.licenseID = licenseID;
    }
    
    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
    
}
