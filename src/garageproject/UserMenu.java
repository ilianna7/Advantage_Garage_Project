/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import static garageproject.GarageProject.getRandom;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ilian
 */
public class UserMenu {

    private int user_input, max, rn;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    //Constractor
    public UserMenu(ArrayList<Employee> employeeList, ArrayList<Customer> customerList, ArrayList<Vehicle> vehicleList) {

        this.customerList = customerList;
        this.vehicleList = vehicleList;
        this.employeeList = employeeList;
    }

    //User Interactive Menu
    public void mainMenu(Garage garage) {

        //Welcome Menu
        System.out.println("");
        System.out.println("Hello. Welcome to our Garage System.");
        System.out.println("Please choose if you would like to customise any of the following.");
        System.out.println("(For the entities you don't customise, the system is going to run with default values.)");

        System.out.println("1. Garage");
        System.out.println("2. Humans");
        System.out.println("3. Start Simulation");
        System.out.println("4. Quit");

        //Get user input
        Scanner s_in = new Scanner(System.in);
        user_input = getUserIntInput(s_in, 1, 4);

        //Customise Garage
        if (user_input == 1) {
            customiseGarageMenu(s_in, garage);

            //Customise Customers
        } else if (user_input == 2) {
            customiseHumans(s_in, garage);
            //Start Simulation
        } else if (user_input == 3) {
            startSimulation(s_in, garage);
            //Quit
        } else {
            System.out.println("Goodbye.");
        }
    }

    //Customise Garage User Menu
    private void customiseGarageMenu(Scanner s_in, Garage garage) {

        System.out.println("");
        System.out.println("What would you like to customise?");
        System.out.println("1. Parking Spaces              (Default: 50)");
        System.out.println("2. Charge for Cars             (Default: 5 E/h)");
        System.out.println("3. Charge for Motorcycles      (Default: 3 E/h)");
        System.out.println("4. Back");

        //Get User Input
        user_input = getUserIntInput(s_in, 1, 4);

        System.out.println("");
        //Set Parking Spaces
        if (user_input == 1) {

            System.out.println("Enter the number of parking spaces.");
            System.out.println("(Min: 2 - Max: Number of customers - Default: 5)");

            user_input = getUserIntInput(s_in, 2, customerList.size());

            garage.setSpots(user_input);

            customiseGarageMenu(s_in, garage);

            //Set Charge for Cars
        } else if (user_input == 2) {
            System.out.println("Enter the charge per hour.");
            System.out.println("(Min 2 - Max 100)");

            user_input = getUserIntInput(s_in, 2, 100);

            garage.setCarCharge(user_input);

            customiseGarageMenu(s_in, garage);

            //Set Charge for Motorcycles    
        } else if (user_input == 3) {
            System.out.println("Enter the charge per hour.");
            System.out.println("(Min 1 - Max 50)");

            user_input = getUserIntInput(s_in, 1, 50);

            garage.setMotoCharge(user_input);

            customiseGarageMenu(s_in, garage);

            //Go Back
        } else {
            mainMenu(garage);
        }

    }

    //Customise Humans
    private void customiseHumans(Scanner s_in, Garage garage) {
        System.out.println("");
        System.out.println("Choose your next action");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Employee");
        System.out.println("3. Back");

        //Get User Input
        user_input = getUserIntInput(s_in, 1, 3);

        //Add Customer
        if (user_input == 1) {

            //Randomise ID
            boolean flag = false;
            Customer cus = new Customer();
            do {
                int ID = getRandom(9, 0) * 10000 + getRandom(9, 0) * 1000 + getRandom(9, 0) * 100 + getRandom(9, 0) * 10 + getRandom(9, 0);
                for (Customer temp : customerList) {
                    if (temp.getLicenseID() == ID) {
                        flag = true;
                    }
                }
                if (!flag) {
                    cus.setLicenseID(ID);
                }
            } while (flag);

            Scanner str_in = new Scanner(System.in);

            System.out.println("");
            System.out.println("Enter Customer's first name.");
            String str = getUserStrInput(str_in);
            cus.setfName(str);

            System.out.println("");
            System.out.println("Enter Customer's last name.");

            str = getUserStrInput(str_in);
            cus.setlName(str);

            System.out.println("");
            System.out.println("How many vehicles does the customer have?.");
            System.out.println("(Max 2)");

            user_input = getUserIntInput(s_in, 1, 2);
            int counter = user_input;
            for (int i = 0; i < counter; i++) {

                Vehicle veh = new Vehicle();
                System.out.println("");
                System.out.println("What type of vehicle is it?");

                System.out.println("1. Car");
                System.out.println("2. Motorcycle");

                user_input = getUserIntInput(s_in, 1, 2);

                veh.setType(user_input);

                boolean flag2;
                String plt;

                do {
                    flag2 = false;
                    flag = false;
                    do {
                        flag = false;
                        System.out.println("");
                        System.out.println("Please enter the plate's three first letters");
                        str = getUserStrInput(str_in);

                        if (str.length() < 3 || str.length() > 3) {

                            System.out.println("");
                            System.out.println("Invalid Input");
                            flag = true;
                        }
                    } while (flag);

                    System.out.println("");
                    System.out.println("Please enter the plate's four numbers");
                    user_input = getUserIntInput(s_in, 1000, 9999);

                    plt = str.toUpperCase() + Integer.toString(user_input);
                    for (Vehicle v : vehicleList) {
                        if (plt.equals(v.getPlate())) {
                            System.out.println("");
                            System.out.println("No duplicate plates allowed. Try again.");
                            flag2 = true;
                        }
                    }

                } while (flag2);

                veh.setPlate(plt);
                veh.setParked(0);

                vehicleList.add(veh);
                cus.addVehicle(veh);

            }

            customerList.add(cus);
            customiseHumans(s_in, garage);

            //Add Employee
        } else if (user_input == 2) {

            //Randomise ID
            boolean flag = false;
            Employee emp = new Employee();
            do {
                int ID = getRandom(9, 0) * 10000 + getRandom(9, 0) * 1000 + getRandom(9, 0) * 100 + getRandom(9, 0) * 10 + getRandom(9, 0);
                for (Employee temp : employeeList) {
                    if (temp.getID() == ID) {
                        flag = true;
                    }
                }
                if (!flag) {
                    emp.setID(ID);
                }
            } while (flag);

            Scanner str_in = new Scanner(System.in);

            System.out.println("");
            System.out.println("Enter Employee's first name.");
            String str = getUserStrInput(str_in);
            emp.setfName(str);

            System.out.println("");
            System.out.println("Enter Employee's last name.");

            str = getUserStrInput(str_in);
            emp.setlName(str);

            employeeList.add(emp);
            customiseHumans(s_in, garage);

        } else {
            mainMenu(garage);
        }

    }

    //Run Simulation
    private void startSimulation(Scanner s_in, Garage garage) {

        System.out.println("");
        System.out.println("Choose your next action");
        System.out.println("1. Random event");
        System.out.println("2. Random event x times");
        System.out.println("3. New vehicle arrival");
        System.out.println("4. Vehicle retrival");
        System.out.println("5. View Stats");
        System.out.println("6. End");

        //Get User Input
        user_input = getUserIntInput(s_in, 1, 6);

        System.out.println("");
        //Random event
        if (user_input == 1) {

            if (garage.getEmptySpots() == garage.getSpots()) {
                rn = getRandom(100, 1);
                if (rn <= 55) {
                    newarrival(garage);
                } else {
                    pickup(garage);
                }
            } else {
                newarrival(garage);
            }
            startSimulation(s_in, garage);
            //Random event x times
        } else if (user_input == 2) {

            System.out.println("How many times?");
            System.out.println("Min 1 - Max 10");
            user_input = getUserIntInput(s_in, 1, 10);

            for (int i = 0; i < user_input; i++) {
                if (garage.getEmptySpots() == garage.getSpots()) {
                    rn = getRandom(100, 1);
                    if (rn <= 55) {
                        newarrival(garage);
                    } else {
                        pickup(garage);
                    }
                } else {
                    newarrival(garage);
                }
            }
            startSimulation(s_in, garage);

            //New vehicle arrival
        } else if (user_input == 3) {
            newarrival(garage);
            startSimulation(s_in, garage);

            //Vehicle retrival
        } else if (user_input == 4) {
            if (garage.getEmptySpots() == garage.getSpots()) {
                System.out.println("The garage is empty.");
            } else {
                pickup(garage);
            }
            startSimulation(s_in, garage);
            //View Stats
        } else if (user_input == 5) {
            questionsmenu(s_in, garage);

            //End
        } else {
            mainMenu(garage);
        }

    }

    public void pickup(Garage garage) {

        //Get Random Customer
        max = customerList.size() - 1;
        rn = getRandom(max, 0);
        System.out.println("");

        Customer customer = customerList.get(rn);

        //Check if customer has already come by
        if (garage.hasCustomerComeBy(customer.getLicenseID())) {

            System.out.println("Customer " + customer.getfName() + " " + customer.getlName() + " arrived.");
            System.out.println(garage.removeVehicle(customer.getVehicleList().get(0).getPlate()));
        } else {
            pickup(garage);
        }
    }

    public void newarrival(Garage garage) {

        //Get Random Customer
        max = customerList.size() - 1;
        rn = getRandom(max, 0);
        System.out.println("");

        Customer customer = customerList.get(rn);

        //Check if customer has already come by
        if (garage.hasCustomerComeBy(customer.getLicenseID())) {

                //Check if he has another car
            //No -> Get another random customer
            if (customer.getVehicleList().size() == 1) {
                newarrival(garage);
            }
                //yes leaves the other car 

            System.out.println("Customer " + customer.getfName() + " " + customer.getlName() + " arrived.");

            //Check if garage is full
            if (!garage.garagefull()) {

                //Get Random Employee
                max = employeeList.size() - 1;
                rn = getRandom(max, 0);

                Employee employee = employeeList.get(rn);
                System.out.println("Employee " + employee.getID() + " took the car to park it.");
                employee.printStaffInfo();
                System.out.println(garage.parkVehicleD(customer.getVehicleList().get(0), customer.getLicenseID(), employee.getID()));
            }

        } else {

            System.out.println("Customer " + customer.getfName() + " " + customer.getlName() + " arrived.");

            //Check if garage is full
            if (!garage.garagefull()) {

                //Get Random Employee
                max = employeeList.size() - 1;
                rn = getRandom(max, 0);

                Employee employee = employeeList.get(rn);
                System.out.println("Employee " + employee.getID() + " took the car to park it.");
                employee.printStaffInfo();
                System.out.println(garage.parkVehicle(customer.getVehicleList().get(0), customer.getLicenseID(), employee.getID()));

            }
        }
    }

    private void questionsmenu(Scanner s_in, Garage garage) {
        System.out.println("");
        System.out.println("Choose what to view");
        System.out.println("1. Garage Current Capacity");
        System.out.println("2. Garage Current Earnings");
        System.out.println("3. Back");

        //Get User Input
        user_input = getUserIntInput(s_in, 1, 3);

        System.out.println("");

        if (user_input == 1) {

            if (garage.getEmptySpots() == 0) {
                System.out.println("Garage is full.");
            }
            if (garage.getEmptySpots() == garage.getSpots()) {
                System.out.println("Garage is empty.");
            } else {
                System.out.println("Garage has " + (garage.getSpots() - garage.getEmptySpots()) + " free parking spaces out of " + garage.getSpots() + ".");
            }
            questionsmenu(s_in, garage);

        } else if (user_input == 2) {

            System.out.println("The garage has currently earned a total of " + garage.getMoneyTotal() + " euros.");
            questionsmenu(s_in, garage);

        } else {
            startSimulation(s_in, garage);
        }

    }

    //Get User Input for integers and check if valid
    private int getUserIntInput(Scanner s_in, int bottomRange, int topRange) {

        System.out.print("Enter: ");
        int user_input = 0;
        if (s_in.hasNextInt()) {
            user_input = s_in.nextInt();
        }

        //Check user input
        while (user_input < bottomRange || user_input > topRange) {

            System.out.println("");
            System.out.println("Please enter a valid option.");
            System.out.print("Enter: ");

            if (s_in.hasNextInt()) {
                user_input = s_in.nextInt();
            }
        }
        return user_input;

    }

    private String getUserStrInput(Scanner s_in) {

        System.out.print("Enter:");
        String str = s_in.nextLine();

        //Check name is valid
        if (str.matches(".*\\d.*")) {
            System.out.println("");
            System.out.println("Name can't contain numbers.");
            System.out.print("Enter: ");
            str = s_in.nextLine();

        }
        return str;
    }

}
