package DAO;

import Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ProductDAO {
    private EntityManagerFactory emf;

    public ProductDAO(){
        emf = EMFactory.getEMF ();
    }

    public Product getProductByProductCode(int productCode) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Product.class , productCode);
    }

    public List<Product> getAllProducts() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from Product");
        List<Product> countList = query.getResultList();
        return countList;
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
        em.remove (em.find (Product.class, product.getProductCode ()));
        em.getTransaction ().commit ();
    }
}
