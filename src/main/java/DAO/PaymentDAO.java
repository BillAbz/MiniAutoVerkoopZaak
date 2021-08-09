package DAO;

import Entities.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PaymentDAO {
    private EntityManagerFactory emf;

    public PaymentDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addPayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (payment);
        em.getTransaction ().commit ();
    }

    public void updatePayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (payment);
        em.getTransaction ().commit ();
    }

    public void deletePayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (Payment.class, payment.getOderNumber ()));
        em.getTransaction ().commit ();
    }
}
