package DAO;

import Entities.Employee;
import Entities.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO {
        private EntityManagerFactory emf;

        public EmployeeDAO(){
                emf = EMFactory.getEMF ();
        }

        public Employee getEmployeeByEmployeeNumber(int employeeNumber) throws SQLException {
                EntityManager entityManager = emf.createEntityManager();
                return entityManager.find(Employee.class , employeeNumber);
        }

        public List<Employee> getAllEmployee() throws SQLException {
                EntityManager entityManager = emf.createEntityManager();
                Query query = entityManager.createQuery("Select * from Employee");
                List<Employee> employeeList = query.getResultList();
                return employeeList;
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
