package com.costin.hibernateproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeServiceImplementation
        implements EmployeeService{
    private SessionFactory sessionFactory;
    private Session session;

    public EmployeeServiceImplementation() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        System.out.println("Factory created succesfully...");
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("\n\nSave employee method");

        session = sessionFactory.getCurrentSession();
        System.out.println("Session created succesfully...");

        session.beginTransaction();
        System.out.println("Transaction started succesfully...");

        session.save(employee);
        System.out.println("Employee saved in the database...");

        session.getTransaction().commit();
        System.out.println("Transaction comitted succesfully...");

        session.close();
        System.out.println("Session closed...");
    }

    @Override
    public Employee retrieveEmployeeById(int id) {
        System.out.println("\n\nRetrieve the employee by id method");

        session = sessionFactory.getCurrentSession();
        System.out.println("Session created succesfully...");

        session.beginTransaction();
        System.out.println("Transaction started succesfully...");

        Employee theEmployee = session.get(Employee.class, id);
        System.out.println("Employee retrieved from the database...");

        session.getTransaction().commit();
        System.out.println("Transaction comitted succesfully...");

        session.close();
        System.out.println("Session closed...");

        return theEmployee;
    }

    @Override
    public List<Employee> queryObjectsByCompany(String companyName) {
        System.out.println("\n\nQuerying employees by company name method");

        session = sessionFactory.getCurrentSession();
        System.out.println("Session created succesfully...");

        session.beginTransaction();
        System.out.println("Transaction started succesfully...");

        List<Employee> theEmployees = session
                .createQuery("from Employee e" +
                        " where e.company=?1")
                .setParameter(1, companyName)
                        .getResultList();
        System.out.println("Employee saved in the database...");

        session.getTransaction().commit();
        System.out.println("Transaction comitted succesfully...");

        session.close();
        System.out.println("Session closed...");

        return theEmployees;
    }

    @Override
    public void deleteEmployeeById(int id) {
        System.out.println("\n\nDelete employee with given id method");

        session = sessionFactory.getCurrentSession();
        System.out.println("Session created succesfully...");

        session.beginTransaction();
        System.out.println("Transaction started succesfully...");

        session
                .createQuery("delete from Employee" +
                        " where id=?1")
                .setParameter(1, id)
                .executeUpdate();
        System.out.println("Employee deleted from database...");

        session.getTransaction().commit();
        System.out.println("Transaction comitted succesfully...");

        session.close();
        System.out.println("Session closed...");
    }

    @Override
    public void close() {
        sessionFactory.close();
        System.out.println("SessionFactory closed succesfully...");
    }

}
