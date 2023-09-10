package osemes.javapro.dz30;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        // Конфігурація Hibernate та отримання SessionFactory
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        // Створення нового студента та налаштування його даних
        Student student = new Student();
        student.setName("John");
        student.setEmail("john@example.com");

        // Отримання сесії Hibernate
        Session session = sessionFactory.openSession();

        // Початок транзакції
        Transaction transaction = session.beginTransaction();

        // Збереження студента в базі даних
        session.save(student);

        // Завершення транзакції та закриття сесії
        transaction.commit();
        session.close();

        // Закриття SessionFactory після завершення роботи
        sessionFactory.close();
    }
}
