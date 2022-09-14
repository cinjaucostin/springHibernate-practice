package com.costin.manytomanymapping;

import com.costin.onetomanymapping.Course;
import com.costin.onetomanymapping.Review;
import com.costin.onetoonemapping.Instructor;
import com.costin.onetoonemapping.InstructorDetail;
import com.costin.springhbpractice.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int id = 2;
            Student student
                    = session.get(Student.class, id);

            session.delete(student);

            session.getTransaction().commit();
            session.close();

            System.out.println("Operation done!");
        } finally {
            factory.close();
            System.out.println("SessionFactory closed...");
        }
    }
}
