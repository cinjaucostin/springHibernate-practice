package com.costin.onetomanymapping;

import com.costin.onetoonemapping.Instructor;
import com.costin.onetoonemapping.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnotherDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            /*
            Instructor instructor = new Instructor(
                    "Costin",
                    "Cinjau",
                    "cinjau.costin@yahoo.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "www.smecherie.com",
                    "sa joace fotbal pana face batai in calcaie"
            );

            instructor.setInstructorDetail(instructorDetail);

            Course course1 = new Course("fotbal");
            Course course2 = new Course("programare");

            // instructor.add(course1);
            // instructor.add(course2);
             */
            session.beginTransaction();

            int instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);

            System.out.println("Instructor: " + instructor);

            System.out.println("Instructor courses: " + instructor.getCourses());

            /*
            Course theCourse = session.get(Course.class, 11);
            System.out.println(theCourse.getInstructor().getCourses());
             */

            session.getTransaction().commit();

            System.out.println("Operation done!");
        } finally {
            session.close();
            factory.close();
            System.out.println("SessionFactory closed...");
        }
    }
}
