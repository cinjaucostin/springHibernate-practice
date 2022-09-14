package com.costin.springhbpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

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
        } finally {
            session.close();
            System.out.println("SessionFactory closed...");
        }

    }

}
