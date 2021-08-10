package DAO;

import Entities.Employee;
import Entities.Office;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class OfficeDAO {
    private EntityManagerFactory emf;

    public OfficeDAO(){
        emf = EMFactory.getEMF ();
    }

    public Office getOfficeByOfficeCode(int officeCode) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Office.class , officeCode);
    }

    public List<Office> getAllOffice() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from Office");
        List<Office> officeList = query.getResultList();
        return officeList;
    }


    public void addOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (office);
        em.getTransaction ().commit ();
    }

    public void updateOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (office);
        em.getTransaction ().commit ();
    }

    public void deleteOffices(Office office){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (Office.class, office.getOfficeCode ()));
        em.getTransaction ().commit ();
    }
}
