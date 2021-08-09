package DAO;

import Entities.ProductLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductLinesDAO {
    private EntityManagerFactory emf;

    public ProductLinesDAO(){
        emf = EMFactory.getEMF ();
    }

    public ProductLine getProductLinesByLine(String line){
        EntityManager em = emf.createEntityManager ();
        return em.find (ProductLine.class, line);
    }

    public void addProductLines(ProductLine productLine){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (productLine);
        em.getTransaction ().commit ();
    }

    public void updateProductLines(ProductLine productLine){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (productLine);
        em.getTransaction ().commit ();
    }

    public void deleteProductLines(ProductLine productLine){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (ProductLine.class, productLine.getId ()));
        em.getTransaction ().commit ();
    }
}
