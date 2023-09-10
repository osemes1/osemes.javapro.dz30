package osemes.javapro.dz30;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Ініціалізація конфігурації Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Student.class);

            // Повертаємо об'єкт SessionFactory
            return configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка ініціалізації Hibernate SessionFactory: " + e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
