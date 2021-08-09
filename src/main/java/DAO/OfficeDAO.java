package DAO;

import Entities.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OfficeDAO {
    private EntityManagerFactory emf;

    public OfficeDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (office);
        em.getTransaction ().commit ();
    }

    public void updateOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (office);
        em.getTransaction ().commit ();
    }

    public void deleteOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Office.class, office.getId ()));
        em.getTransaction ().commit ();
    }
}
