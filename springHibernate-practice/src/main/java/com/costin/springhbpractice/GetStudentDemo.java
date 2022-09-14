package com.costin.springhbpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        System.out.println("Factory build succesfully...");

        Session session = factory.getCurrentSession();
        System.out.println("Session created succesfully...");

        try {
            Student theStudent = new Student(
                    "Costin",
                    "Cinjau",
                    "cinjau.costin@yahoo.com"
            );

            // start a transaction
            session.beginTransaction();
            System.out.println("Transaction started...");

            // save the student
            session.save(theStudent);
            System.out.println("Saving student in database...");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Transaction commited...");

            session.close();
            System.out.println("Session closed...");

            // start new session and a new transaction
            session = factory.getCurrentSession();
            System.out.println("Session created succesfully...");

            session.beginTransaction();
            System.out.println("Transaction started...");

            // search for the student in database
            System.out.println("Searching for the student in database...");
            // Student studentRetrieved = session.get(Student.class, theStudent.getId());
            // System.out.println(studentRetrieved);

            session.getTransaction().commit();
            System.out.println("Transaction commited...");

            session.close();
            System.out.println("Session closed...");
        } finally {
            session.close();
            System.out.println("SessionFactory closed...");
        }
    }

}
