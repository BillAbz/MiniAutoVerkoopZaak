package DAO;

import Entities.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderDetailDAO {
    private EntityManagerFactory emf;

    public OrderDetailDAO(){
        emf = EMFactory.getEMF ();
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
//        em.remove (em.find (OrderDetail.class, orderDetail.getId ()));
        em.getTransaction ().commit ();
    }
}
