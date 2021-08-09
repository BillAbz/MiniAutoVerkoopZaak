package DAO;

import Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ProductDAO {
    private EntityManagerFactory emf;

    public ProductDAO(){
        emf = EMFactory.getEMF ();
    }


    public void addProduct(Product product){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (product);
        em.getTransaction ().commit ();
    }

    public void updateProduct(Product product){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (product);
        em.getTransaction ().commit ();
    }

    public void deleteProduct(Product product){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
//        em.remove (em.find (Product.class, product.getId ()));
        em.getTransaction ().commit ();
    }
}
