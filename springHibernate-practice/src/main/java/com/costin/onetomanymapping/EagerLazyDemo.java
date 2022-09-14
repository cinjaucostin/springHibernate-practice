package com.costin.onetomanymapping;

import com.costin.onetoonemapping.Instructor;
import com.costin.onetoonemapping.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerLazyDemo {
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

            /*
            int instructorId = 1;
            Instructor instructor = session.get(Instructor.class, instructorId);

             */

            int instructorId = 1;
            Query<Instructor> query = session.createQuery(
                    "select i from Instructor i"
                    + " JOIN FETCH i.courses"
                    + " where i.id=:theInstructorId",
                    Instructor.class
            ).setParameter("theInstructorId", instructorId);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor: " + instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Instructor courses: " + instructor.getCourses());

            /*
            Course theCourse = session.get(Course.class, 11);
            System.out.println(theCourse.getInstructor().getCourses());
             */



            System.out.println("Operation done!");
        } finally {
            factory.close();
            System.out.println("SessionFactory closed...");
        }
    }

}
