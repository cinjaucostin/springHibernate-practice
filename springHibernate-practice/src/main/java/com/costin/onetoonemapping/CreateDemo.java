package com.costin.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
//
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Instructor.class)
//                .addAnnotatedClass(InstructorDetail.class)
//                .buildSessionFactory();
//
//        Session session = factory.getCurrentSession();
//
//        try {
//            /*
//            Instructor instructor = new Instructor(
//                    "Costin",
//                    "Cinjau",
//                    "cinjau.costin@yahoo.com"
//            );
//
//            InstructorDetail instructorDetail = new InstructorDetail(
//                    "www.youtube.com/channel=cacaoculapte",
//                    "football"
//            );
//
//
//            Instructor instructor = new Instructor(
//                    "Claudiu",
//                    "Cinjau",
//                    "cinjau.claudiu@yahoo.com"
//            );
//
//            InstructorDetail instructorDetail = new InstructorDetail(
//                    "www.youtube.com/channel=cacaoculapte2",
//                    "football"
//            );
//
//            instructor.setInstructorDetail(instructorDetail);
//
//             */
//
//            session.beginTransaction();
//
//    // session.save(instructor);
//
//    InstructorDetail instructorDetail = session.get(
//            InstructorDetail.class,
//            3
//    );
//
//        if(instructorDetail != null) {
//        instructorDetail.getInstructor().setInstructorDetail(null);
//        session.delete(instructorDetail);
//    }
//
//            /*
//            session
//                    .createQuery("update InstructorDetail set hobby='gaming'"
//                    + " where id=2")
//                            .executeUpdate();
//             */
//
//            /*
//            Instructor theInstructor = session.get(Instructor.class, 1);
//
//            if(theInstructor != null) {
//                session.delete(theInstructor);
//            }
//             */
//
//        session.getTransaction().commit();
//
//        session.close();
//
//        System.out.println("Operation done!");
//} finally {
//        factory.close();
//        System.out.println("SessionFactory closed...");
//        }
//        }
        }
