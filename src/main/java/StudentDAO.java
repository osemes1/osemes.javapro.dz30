package osemes.javapro.dz30;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    private final SessionFactory sessionFactory = HibernateSession.getSessionFactory();

    // Метод для збереження студента в базі даних
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Метод для оновлення інформації про студента
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Метод для видалення студента за його ID
    public void deleteStudent(int studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Метод для отримання студента за його ID
    public Student getStudentById(int studentId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Student.class, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    // Метод для отримання списку всіх студентів
    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        try {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
