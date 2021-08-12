package DAO;

import Entities.Product;
import Entities.ProductLine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ProductLineDAO {
    private EntityManagerFactory emf;

    public ProductLineDAO(){
        emf = EMFactory.getEMF ();
    }

    public ProductLine getProductLinesByLine(String line){
        EntityManager em = emf.createEntityManager ();
        return em.find (ProductLine.class, line);
    }

    public ProductLine getProductByProductCode(String productCode) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(ProductLine.class , productCode);
    }

    public List<ProductLine> getAllProducts() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from ProductLine");
        List<ProductLine> productLineList = query.getResultList();
        return productLineList;
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
        em.remove (em.find (ProductLine.class, productLine.getProductLine ()));
        em.getTransaction ().commit ();
    }
}
