package com.costin.springhbpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        System.out.println("Factory build succesfully...");

        Session session = factory.getCurrentSession();
        System.out.println("Session created succesfully...");

        try {
            Student student1 = new Student(
                    "Costin",
                    "Cinjau",
                    "cinjau.costin@yahoo.com"
            );

            Student student2 = new Student(
                    "Claudiu",
                    "Cinjau",
                    "cinjau.claudiu@yahoo.com"
            );

            Student student3 = new Student(
                    "Alessia",
                    "Cinjau",
                    "cinjau.alessia@yahoo.com"
            );

            // start a transaction
            session.beginTransaction();
            System.out.println("Transaction started...");

            // save the student
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("Saving students in database...");

            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Transaction commited...");
        } finally {
            session.close();
            System.out.println("SessionFactory closed...");
        }

    }
}
