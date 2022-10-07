/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author athap
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       Student std1 = new Student(1, "Mike", 3.58);
//       Student std2 = new Student(2, "Sara", 3.88);
        Student std1 = new Student(1, "Mike", 3.58);
        Student std2 = new Student(2, "Sara", 3.88);
        persist(std1);
        persist(std2);
       //StudentTable.insertStudent(std1);
       //StudentTable.insertStudent(std2);
       //Employee emp;
       //emp = EmployeeTable.findEmployeeById(1);
       //if (emp != null) {
       //    emp.setName("Jack");
           //EmployeeTable.removeEmployee(emp);
       //    EmployeeTable.updateEmployee(emp);
       //}
       //List<Employee> empList = EmployeeTable.findEmployeeByName("Marry"); 
       List<Student> stdList = StudentTable.findAllStudent();
       printAllStudent(stdList);
    }
    public static void printAllStudent(List<Student> studentList) {
        for(Student std : studentList) {
           System.out.print(std.getId() + " ");
           System.out.print(std.getName() + " ");
           System.out.println(std.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

