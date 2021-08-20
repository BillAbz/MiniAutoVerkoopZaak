package DAO;

import Entities.Customer;
import Entities.Order;
import Entities.OrderDetail;
import Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAO {
    private EntityManagerFactory emf;

    public OrderDetailDAO(){
        emf = EMFactory.getEMF ();
    }

    public OrderDetail getProductByOrderNumber(Order orderNumber) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(OrderDetail.class , orderNumber);
    }

    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM orderdetails", OrderDetail.class).getResultList();
    }

    public void addOrderDetail(OrderDetail orderDetail){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (orderDetail);
        em.getTransaction ().commit ();
    }

    public void updateOrderDetail(OrderDetail orderDetail){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (orderDetail);
        em.getTransaction ().commit ();
    }

    public void deleteOrderDetail(OrderDetail orderDetail){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (OrderDetail.class, orderDetail.getOderNumber ()));
        em.getTransaction ().commit ();
    }
}
