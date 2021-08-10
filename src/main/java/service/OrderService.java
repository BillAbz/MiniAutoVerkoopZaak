package service;

import Entities.Office;
import Entities.Order;

import java.util.Set;

public interface OrderService {

    void addOrder(Order order);

    Order getOrderById(long id);

    Set<Order> getAllOrders();

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
