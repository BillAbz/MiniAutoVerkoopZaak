package service;

import DAO.OfficeDAO;
import Entities.Employee;
import Entities.Office;

import java.sql.SQLException;
import java.util.Scanner;

public class OfficeService {

    private OfficeDAO officeDAO;
    private Scanner scanner;

    public OfficeService() {
        officeDAO = new OfficeDAO();
        scanner = new Scanner(System.in);
    }

    public void showAllOffices() throws SQLException {
        if (officeDAO.getAllOffices() != null)
            officeDAO.getAllOffices().forEach(System.out::println);
        else
            System.out.println("No Offices to show.");
    }

    public void showOfficeByOfficeCode() throws SQLException {
        System.out.println("What is the id of the Office you want to lookup?");
        int input = scanner.nextInt();
        Office office =  officeDAO.getOfficeByOfficeCode(input);
        if (office != null)
            System.out.println(office);
        else
            System.out.println("Id does not match any of the Offices.");
    }


    public Office createAnOffice() {
        System.out.println("What city is the office located?");
        String city = scanner.nextLine();
        System.out.println("What is the phone number of the office?"); //TODO:: check for right phone number
        String phone = scanner.nextLine();
        System.out.println("What is the first addressline of the office?");
        String addressLine1 = scanner.nextLine();
        System.out.println("What's the second addressline of the office?");
        String addressLine2 = scanner.nextLine();
        System.out.println("What is the state of the office?");
        String state = scanner.nextLine();
        System.out.println("What is the Country of the office?");
        String country = scanner.nextLine();
        System.out.println("What is the postal code of the office?");
        String postalCode = scanner.nextLine();
        System.out.println("What is the territory of the office?");
        String territory = scanner.nextLine();
        Office office = new Office(city,phone,addressLine1,addressLine2,state,country,postalCode,territory);
        return office;
    }

    public void updateAnOffice() {

    }

    public void deleteAnOffice() {

    }

}
