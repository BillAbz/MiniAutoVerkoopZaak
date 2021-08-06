package DAO;

import model.Offices;
import model.Payments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OfficesDAO {
    private EntityManagerFactory emf;

    public OfficesDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addOffices(Offices offices){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (offices);
        em.getTransaction ().commit ();
    }

    public void updateOffices(Offices offices){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (offices);
        em.getTransaction ().commit ();
    }

    public void deleteOffices(Offices offices){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Offices.class, offices.getId ()));
        em.getTransaction ().commit ();
    }
}
