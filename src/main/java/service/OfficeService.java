package service;

import Entities.Employee;
import Entities.Office;
import Entities.OrderDetail;

import java.util.Set;

public interface OfficeService {
    void addOrderDetail(Office office);

    Office getOrderDetailById(long id);

    Set<Office> getAllOrderDetail();

    void updateOrderDetail(Office office);

    void deleteOrderDetail(Office office);
}
