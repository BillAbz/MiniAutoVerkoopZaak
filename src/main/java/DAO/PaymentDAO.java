package DAO;

import Entities.Customer;
import Entities.OrderDetail;
import Entities.Payment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class PaymentDAO {
    private EntityManagerFactory emf;

    public PaymentDAO(){
        emf = EMFactory.getEMF ();
    }

    public Payment getPaymentByCheckNumber(int checkNumber) throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(Payment.class , checkNumber);
    }

    public List<Payment> getAllPayments() throws SQLException {
        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("Select * from Payment");
        List<Payment> paymentList = query.getResultList();
        return paymentList;
    }

    public void addPayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.persist (payment);
        em.getTransaction ().commit ();
    }

    public void updatePayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.merge (payment);
        em.getTransaction ().commit ();
    }

    public void deletePayment(Payment payment){
        EntityManager em = emf.createEntityManager ();
        em.getTransaction ().begin ();
        em.remove (em.find (Payment.class, payment.getCheckNumber()));
        em.getTransaction ().commit ();
    }
}
