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
    public void addOrderDetail(Office office) {

    }

    @Override
    public Office getOrderDetailById(long id) {
        return null;
    }

    @Override
    public Set<Office> getAllOrderDetail() {
        return null;
    }

    @Override
    public void updateOrderDetail(Office office) {

    }

    @Override
    public void deleteOrderDetail(Office office) {

    }
}
