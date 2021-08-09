package DAO;

import Entities.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO {
    private EntityManagerFactory emf;

    public CustomerDAO(){
        emf = EMFactory.getEMF ();
    }


    public Costumer getCostumerByCostumerNumber(int costumerNumber) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Costumer.class , costumerNumber);
    }

    public List<Costumer> getAllCostumers() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from Country");
        List<Costumer> countList = query.getResultList();
        return countList;
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
