package DAO;

import model.Payments;
import model.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PaymentsDAO {
    private EntityManagerFactory emf;

    public PaymentsDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addPayment(Payments payments){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (payments);
        em.getTransaction ().commit ();
    }

    public void updatePayment(Payments payments){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (payments);
        em.getTransaction ().commit ();
    }

    public void deletePayment(Payments payments){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Payments.class, payments.getId ()));
        em.getTransaction ().commit ();
    }
}
