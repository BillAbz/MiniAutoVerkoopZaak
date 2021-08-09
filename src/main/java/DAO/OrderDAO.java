package DAO;

import Entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderDAO {
    private EntityManagerFactory emf;

    public OrderDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addOrder(Order order){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (order);
        em.getTransaction ().commit ();
    }

    public void updateOrder(Order order){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (order);
        em.getTransaction ().commit ();
    }

    public void deleteOrder(Order order){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Order.class, order.getId ()));
        em.getTransaction ().commit ();
    }
}
