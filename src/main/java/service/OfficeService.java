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
        return new Office();
    }

    public void updateAnOffice() {

    }

    public void deleteAnOffice() {

    }

}
