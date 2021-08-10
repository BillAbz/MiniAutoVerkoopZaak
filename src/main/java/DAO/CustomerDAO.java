package DAO;

import Entities.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {
    private EntityManagerFactory emf;

    public CustomerDAO() {
        emf = EMFactory.getEMF();
    }


    public void addCostumers(Costumer costumer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(costumer);
        em.getTransaction().commit();
    }

    public void updateCostumers(Costumer costumer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(costumer);
        em.getTransaction().commit();
    }

    public void deleteCostumers(Costumer costumer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        em.remove (em.find (Costumer.class, costumer.getId ()));
        em.getTransaction().commit();
    }

    public Costumer getCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Costumer.class, id);
    }

    public Set<Costumer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Customer c");
        return new HashSet<>(query.getResultList());
    }


}