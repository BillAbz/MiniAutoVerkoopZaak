package DAO;

import Entities.Customer;
import Entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class OrderDAO {
    private EntityManagerFactory emf;

    public OrderDAO() {
        emf = EMFactory.getEMF();
    }

    public Order getOrderByOrderNumber(int orderNumber) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Order.class, orderNumber);
    }

    public List<Order> getAllOrders() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM orders", Order.class).getResultList();
    }


    public void addOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }

    public void updateOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    public void deleteOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Order.class, order.getOrderNumber()));
        em.getTransaction().commit();
    }
}
