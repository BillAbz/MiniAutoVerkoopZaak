package service;

import Entities.Employee;
import Entities.Office;
import Entities.OrderDetail;

import java.util.Set;

public interface OfficeService {
    void addOffice(Office office);

    Office getOfficeById(String id);

    Set<Office> getAllOffices();

    void updateOffice(Office office);

    void deleteOffice(Office office);
}
