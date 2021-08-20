package DAO;

import Entities.Customer;
import Entities.Employee;
import Entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDAO {
        private EntityManagerFactory emf;

        public EmployeeDAO(){
                emf = EMFactory.getEMF ();
        }

        public Employee getEmployeeByEmployeeNumber(int employeeNumber) {
                EntityManager entityManager = emf.createEntityManager();
                return entityManager.find(Employee.class , employeeNumber);
        }

        public List<Employee> getAllEmployees() {
                EntityManager em = emf.createEntityManager();
                return em.createQuery("FROM employees", Employee.class).getResultList();
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
