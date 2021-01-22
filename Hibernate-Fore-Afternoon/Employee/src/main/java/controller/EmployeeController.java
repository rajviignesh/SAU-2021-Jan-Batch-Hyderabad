package controller;

import entity.addressData;
import entity.courseData;
import entity.employeeData;
import entity.personalEmpData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeController {
    
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(employeeData.class)
                .addAnnotatedClass(personalEmpData.class)
                .addAnnotatedClass(addressData.class)
                .addAnnotatedClass(courseData.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        
        employeeData emp1 = new employeeData("Raj","Vignesh");
        employeeData emp2 = new employeeData("Kesav","Ravi");
        
        //OnetoOne
        personalEmpData personalEmp1 = new personalEmpData("8939635828","raj@accolite.com",emp1);
        personalEmpData personalEmp2 = new personalEmpData("9812718232","kesav@accolite.com",emp2);
        
        //OneToMany
        addressData add1 = new addressData("Nanganallur","Chennai","600114", emp1);
        addressData add2 = new addressData("Kalavakkam","Chennai","601123", emp1);

        addressData add3 = new addressData("Valasaravakkam","Chennai","600023", emp2);
        
        emp1.getAddList().add(add1);
        emp1.getAddList().add(add2);
        emp2.getAddList().add(add3);
        
        //ManyToMany
        courseData course1 = new courseData("Hibernate");
        courseData course2 = new courseData("JavaScript");
        
        emp1.addCourse(course1);
        emp1.addCourse(course2);
        emp2.addCourse(course1);
        emp2.addCourse(course2);
        
        try{
            session.beginTransaction();

            session.save(emp1);
            session.save(emp2);
            session.save(personalEmp1);
            session.save(personalEmp2);

            session.getTransaction().commit();
            session.close();

            session = sessionFactory.openSession();
            employeeData empGetDB = session.get(employeeData.class, 1);
            session.close();
            
            System.out.println(empGetDB.getFirstName());
            
        }
        finally {
            
        }



    }
}
