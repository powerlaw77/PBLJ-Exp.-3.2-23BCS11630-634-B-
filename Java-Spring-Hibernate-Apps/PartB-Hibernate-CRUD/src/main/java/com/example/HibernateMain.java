package com.example;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student("Alice", "alice@gmail.com");
        session.save(s1);
        tx.commit();
        System.out.println("Student added successfully!");

        Student s = session.get(Student.class, s1.getId());
        System.out.println("Fetched: " + s.getName() + " - " + s.getEmail());

        tx = session.beginTransaction();
        s.setEmail("alice_new@gmail.com");
        session.update(s);
        tx.commit();
        System.out.println("Student updated!");

        tx = session.beginTransaction();
        session.delete(s);
        tx.commit();
        System.out.println("Student deleted!");

        session.close();
        factory.close();
    }
}