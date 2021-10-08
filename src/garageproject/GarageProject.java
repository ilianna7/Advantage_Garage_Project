/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import java.util.ArrayList;
import java.util.Random;

public class GarageProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Local 'Database'
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        //Create Default Garage
        Garage garage = new Garage(5, 3, 5);

        //Create Default Vehicles & Customers
        Vehicle vehicle = new Vehicle("ABC1234", 1);
        Customer customer = new Customer("Maria", "Papa", 12345, vehicle);
        customerList.add(customer);
        vehicleList.add(vehicle);

        vehicle = new Vehicle("DEF5678", 1);
        customer = new Customer("Panagiotis", "Xaralabou", 87654, vehicle);
        customerList.add(customer);
        vehicleList.add(vehicle);
        vehicle = new Vehicle("DEK5678", 2);
        vehicleList.add(vehicle);
        customer.addVehicle(vehicle);

        vehicle = new Vehicle("GHI9012", 1);
        customer = new Customer("Fotis", "Kouros", 67890, vehicle);
        customerList.add(customer);
        vehicleList.add(vehicle);

        vehicle = new Vehicle("JKL3456", 2);
        customer = new Customer("Manos", "Papadopoulos", 23459, vehicle);
        customerList.add(customer);
        vehicleList.add(vehicle);

        vehicle = new Vehicle("MNO7890", 2);
        customer = new Customer("Anna", "Kara", 56789, vehicle);
        customerList.add(customer);
        vehicleList.add(vehicle);

        //Create Default Employees
        Employee employee = new Employee("Tom", "Riddle", 12345);
        employeeList.add(employee);

        employee = new Employee("Tony", "Peters", 67890);
        employeeList.add(employee);

        employee = new Employee("Lisa", "Marks", 34567);
        employeeList.add(employee);

        UserMenu menu = new UserMenu(employeeList, customerList, vehicleList);
        menu.mainMenu(garage);

    }

    static public int getRandom(int max, int min) {
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }

}
