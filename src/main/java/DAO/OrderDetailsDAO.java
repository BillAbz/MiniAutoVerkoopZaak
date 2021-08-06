package DAO;

import model.OrderDetails;
import model.Payments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderDetailsDAO {
    private EntityManagerFactory emf;

    public OrderDetailsDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addOrderDetail(OrderDetails orderDetails){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (orderDetails);
        em.getTransaction ().commit ();
    }

    public void updateOrderDetail(OrderDetails orderDetails){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (orderDetails);
        em.getTransaction ().commit ();
    }

    public void deleteOrderDetail(OrderDetails orderDetails){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (OrderDetails.class, orderDetails.getId ()));
        em.getTransaction ().commit ();
    }
}
