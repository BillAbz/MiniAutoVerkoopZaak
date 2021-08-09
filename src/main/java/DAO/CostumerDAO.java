package DAO;

import Entities.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CostumerDAO {
    private EntityManagerFactory emf;

    public CostumerDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addCostumers(Costumer costumer){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (costumer);
        em.getTransaction ().commit ();
    }

    public void updateCostumers(Costumer costumer){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (costumer);
        em.getTransaction ().commit ();
    }

    public void deleteCostumers(Costumer costumer){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (Costumer.class, costumer.getCustomerNumber ()));
        em.getTransaction ().commit ();
    }


}
