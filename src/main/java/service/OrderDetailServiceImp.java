package service;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import Entities.Order;
import Entities.OrderDetail;

import java.util.Scanner;
import java.util.Set;

public class OrderDetailServiceImp implements OrderDetailService {

    OrderDetailDAO orderDetailDAO;
    OrderDAO orderDAO;
    ProductDAO productDAO;
    Scanner scanner;

    public OrderDetailServiceImp() {
        this.orderDetailDAO = new OrderDetailDAO();
        this.orderDAO = new OrderDAO();
        this.productDAO = new ProductDAO();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.addOrderDetail(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetailById(int id) {
        return null; //todo DAO has to be finished
    }

    @Override
    public Set<OrderDetail> getAllOrderDetail() {
        return null; //todo DAO has to be finished
    }

    @Override
    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.updateOrderDetail(orderDetail);
    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.deleteOrderDetail(orderDetail);
    }
}
