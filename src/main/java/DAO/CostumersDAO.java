package DAO;

import model.Costumers;
import model.Payments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CostumersDAO {
    private EntityManagerFactory emf;

    public CostumersDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addCostumers(Costumers costumers){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (costumers);
        em.getTransaction ().commit ();
    }

    public void updateCostumers(Costumers costumers){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (costumers);
        em.getTransaction ().commit ();
    }

    public void deleteCostumers(Costumers costumers){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Costumers.class, costumers.getId ()));
        em.getTransaction ().commit ();
    }


}
