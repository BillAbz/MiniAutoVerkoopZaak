package DAO;

import Entities.Costumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
=======
import java.sql.SQLException;
import java.util.List;
>>>>>>> 4d414ae56e624a3faba2a928ebe4a767f86fbcc4

public class CustomerDAO {
    private EntityManagerFactory emf;

    public CustomerDAO() {
        emf = EMFactory.getEMF();
    }


<<<<<<< HEAD
    public void addCostumers(Costumer costumer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(costumer);
        em.getTransaction().commit();
=======
    public Costumer getCostumerByCostumerNumber(int costumerNumber) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Costumer.class , costumerNumber);
    }

    public List<Costumer> getAllCostumers() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from Costumer");
        List<Costumer> countList = query.getResultList();
        return countList;
    }



    public void addCostumers(Costumer costumer){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (costumer);
        em.getTransaction ().commit ();
>>>>>>> 4d414ae56e624a3faba2a928ebe4a767f86fbcc4
    }

    public void updateCostumers(Costumer costumer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(costumer);
        em.getTransaction().commit();
    }

<<<<<<< HEAD
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
=======
    public void deleteCostumers(Costumer costumer){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (Costumer.class, costumer.getCustomerNumber ()));
        em.getTransaction ().commit ();
>>>>>>> 4d414ae56e624a3faba2a928ebe4a767f86fbcc4
    }


}
