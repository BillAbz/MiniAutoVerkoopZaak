package DAO;

import model.Orders;
import model.Payments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrdersDAO {
    private EntityManagerFactory emf;

    public OrdersDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addOrder(Orders orders){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (orders);
        em.getTransaction ().commit ();
    }

    public void updateOrder(Orders orders){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (orders);
        em.getTransaction ().commit ();
    }

    public void deleteOrder(Orders orders){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Orders.class, orders.getId ()));
        em.getTransaction ().commit ();
    }
}
