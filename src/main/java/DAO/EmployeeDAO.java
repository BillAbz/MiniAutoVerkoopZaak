package DAO;

import Entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EmployeeDAO {
        private EntityManagerFactory emf;

        public EmployeeDAO(){
                emf = EMFactory.getEMF ();
        }


        public void addEmployees(Employee employee){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
                em.persist (employee);
                em.getTransaction ().commit ();
        }

        public void updateEmployees(Employee employee){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
                em.merge (employee);
                em.getTransaction ().commit ();
        }

        public void deleteEmployees(Employee employee){
                EntityManager em = emf.createEntityManager ();
                em.getTransaction ().begin ();
        em.remove (em.find (Employee.class, employee.getEmployeeNumber ()));
                em.getTransaction ().commit ();
        }
        }
