package DAO;

import Entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import java.util.HashSet;
import java.util.Set;

import java.util.List;


public class CustomerDAO {
    private EntityManagerFactory emf;

    public CustomerDAO() {
        emf = EMFactory.getEMF();
    }

    public void addCostumers(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public Customer getCostumerByCustomerNumber(int costumerNumber)  {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Customer.class , costumerNumber);
    }

    public Set<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Customer c");
        return new HashSet<>(query.getResultList());
    }

    public void updateCostumers(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }


    public void deleteCostumers(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove (em.find (Customer.class, customer.getCustomerNumber()));
        em.getTransaction().commit();
    }




}
