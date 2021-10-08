/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

public class Vehicle {

    private String plate;
    private int type;
    private int parked;

    public Vehicle() {
    }

    ;
    
    public Vehicle(String plate, int type) {
        this.plate = plate;
        this.type = type;
        this.parked = 0;

    }

    public String getPlate() {
        return plate;
    }

    public int getType() {
        return type;
    }

    public int getParked() {
        return parked;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setParked(int parked) {
        this.parked = parked;
    }

}
