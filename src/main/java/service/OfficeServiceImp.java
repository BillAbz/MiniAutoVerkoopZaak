package service;

import DAO.EmployeeDAO;
import DAO.OfficeDAO;
import Entities.Office;

import java.util.Scanner;
import java.util.Set;

public class OfficeServiceImp implements OfficeService {

    OfficeDAO officeDAO;
    EmployeeDAO employeeDAO;
    Scanner scanner;

    public OfficeServiceImp() {
        this.officeDAO = new OfficeDAO();
        this.employeeDAO = new EmployeeDAO();
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void addOffice(Office office) {
        officeDAO.addOffices(office);
    }

    @Override
    public Office getOfficeById(String id) {
        return officeDAO.getOfficeByOfficeCode(id);
    }

    @Override
    public Set<Office> getAllOffices() {
        return officeDAO.getAllOffice();
    }

    @Override
    public void updateOffice(Office office) {
        officeDAO.updateOffices(office);
    }

    @Override
    public void deleteOffice(Office office) {
        officeDAO.deleteOffices(office);
    }
}
