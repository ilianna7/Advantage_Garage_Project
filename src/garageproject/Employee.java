/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

/**
 *
 * @author ilian
 */
public class Employee extends Human {

    private int ID;

    //Constractors
    public Employee() {
        super();
    }

    public Employee(String fname, String lname, int ID) {
        super(fname, lname);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void printStaffInfo() {

        System.out.println("Employee ID: " + ID + " - " + fName + " " + lName + ".");

    }
}
