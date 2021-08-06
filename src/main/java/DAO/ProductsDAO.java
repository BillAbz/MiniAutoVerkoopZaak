package DAO;

import model.ProductLines;
import model.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductsDAO {
    private EntityManagerFactory emf;

    public ProductsDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addProduct(Products products){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (products);
        em.getTransaction ().commit ();
    }

    public void updateProduct(Products products){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (products);
        em.getTransaction ().commit ();
    }

    public void deleteProduct(Products products){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Products.class, products.getId ()));
        em.getTransaction ().commit ();
    }
}
