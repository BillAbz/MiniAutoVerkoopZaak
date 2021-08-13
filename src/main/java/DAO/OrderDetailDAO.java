package DAO;

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
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from OrderDetail");
        List<OrderDetail> orderDetailList = query.getResultList();
        return orderDetailList;
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
