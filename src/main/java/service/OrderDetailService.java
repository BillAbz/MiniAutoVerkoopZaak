package service;

import Entities.Employee;
import Entities.OrderDetail;

import java.util.Set;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail orderDetail);

    OrderDetail getOrderDetailById(long id);

    Set<OrderDetail> getAllOrderDetail();

    void updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetail orderDetail);
}
