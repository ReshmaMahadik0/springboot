package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.internal.TransactionImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Teacher teacher = new Teacher();
        teacher.setTeacherName("Mr. xyz");

        Course course = new Course();
        course.setCourseName("Hibernate");
        course.setTeacher(teacher);

        Department department = new Department();
        department.setDepartmentName("computer science");

        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setAddress("pune");
        studentProfile.setPhone("232433322");

        Student student = new Student();
        student.setName("Ram");
        student.setStudentProfile(studentProfile);
        student.setDepartment(department);
        student.getCourses().add(course);

        session.save(teacher);
        session.save(course);
        session.save(department);
        session.save(student);


        transaction.commit();
        session.close();
    }
}
