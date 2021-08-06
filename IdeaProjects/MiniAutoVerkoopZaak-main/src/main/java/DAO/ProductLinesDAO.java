package DAO;

import model.ProductLines;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductLinesDAO {
    private EntityManagerFactory emf;

    public ProductLinesDAO(){
        emf = EMFactory.getEMF ();
    }

    public ProductLines getProductLinesByLine(String line){
        EntityManager em = emf.createEntityManager ();
        return em.find (ProductLines.class, line);
    }

    public void addProductLines(ProductLines productLines){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (productLines);
        em.getTransaction ().commit ();
    }

    public void updateProductLines(ProductLines productLines){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (productLines);
        em.getTransaction ().commit ();
    }

    public void deleteProductLines(ProductLines productLines){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (ProductLines.class, productLines.getId ()));
        em.getTransaction ().commit ();
    }
}
