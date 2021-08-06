package DAO;

import model.Employees;
import model.Payments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EmployeesDAO {
        private EntityManagerFactory emf;

        public EmployeesDAO(){
                emf = EMFactory.getEMF ();
        }


        public void addEmployees(Employees employees){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
                em.persist (employees);
                em.getTransaction ().commit ();
        }

        public void updateEmployees(Employees employees){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
                em.merge (employees);
                em.getTransaction ().commit ();
        }

        public void deleteEmployees(Employees employees){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
//        em.remove (em.find (Employees.class, employees.getId ()));
                em.getTransaction ().commit ();
        }
        }
