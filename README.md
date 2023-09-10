# osemes.javapro.dz30

Виконання ДЗ 30. Hibernate

1. Створити базу даних Student із атрибутами: id, name, email.
2. Створити сутність Student та додати до неї інструкції. Поле id має заповнюватись автоматично. Ця сутність повинна відображати представлення таблиці Student з БД.
3. Створити конфігураційний клас HibernateSession, в якому вказати властивості для підключення до БД та список класів з анотаціями Entity.
4. У класі HibernateSession додати статичний метод отримання об'єкт типу SessionFactory.
5. Створити DAO-клас для зберігання операцій: додавання, видалення, зміни сутності, отримання всіх записів та конкретної за ID.
6. Додати N-записів до таблиці Student.
7. Перевірити працездатність програми, виконати методи видалення, зміни, додавання записів, а також вибірки одного та всіх записів.

Проект компілюється та запускається без помилок:
C:\Users\User303\.jdks\corretto-16.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.3\lib\idea_rt.jar=53110:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.3\bin" -Dfile.encoding=UTF-8 -classpath C:\osem\Projects\osemes.javapro.dz30\target\classes;C:\Users\User303\.m2\repository\com\mysql\mysql-connector-j\8.0.33\mysql-connector-j-8.0.33.jar;C:\Users\User303\.m2\repository\com\google\protobuf\protobuf-java\3.21.9\protobuf-java-3.21.9.jar;C:\Users\User303\.m2\repository\org\hibernate\hibernate-core\5.6.15.Final\hibernate-core-5.6.15.Final.jar;C:\Users\User303\.m2\repository\org\jboss\logging\jboss-logging\3.4.3.Final\jboss-logging-3.4.3.Final.jar;C:\Users\User303\.m2\repository\javax\persistence\javax.persistence-api\2.2\javax.persistence-api-2.2.jar;C:\Users\User303\.m2\repository\net\bytebuddy\byte-buddy\1.12.18\byte-buddy-1.12.18.jar;C:\Users\User303\.m2\repository\antlr\antlr\2.7.7\antlr-2.7.7.jar;C:\Users\User303\.m2\repository\org\jboss\spec\javax\transaction\jboss-transaction-api_1.2_spec\1.1.1.Final\jboss-transaction-api_1.2_spec-1.1.1.Final.jar;C:\Users\User303\.m2\repository\org\jboss\jandex\2.4.2.Final\jandex-2.4.2.Final.jar;C:\Users\User303\.m2\repository\com\fasterxml\classmate\1.5.1\classmate-1.5.1.jar;C:\Users\User303\.m2\repository\javax\activation\javax.activation-api\1.2.0\javax.activation-api-1.2.0.jar;C:\Users\User303\.m2\repository\org\hibernate\common\hibernate-commons-annotations\5.1.2.Final\hibernate-commons-annotations-5.1.2.Final.jar;C:\Users\User303\.m2\repository\javax\xml\bind\jaxb-api\2.3.1\jaxb-api-2.3.1.jar;C:\Users\User303\.m2\repository\org\glassfish\jaxb\jaxb-runtime\2.3.1\jaxb-runtime-2.3.1.jar;C:\Users\User303\.m2\repository\org\glassfish\jaxb\txw2\2.3.1\txw2-2.3.1.jar;C:\Users\User303\.m2\repository\com\sun\istack\istack-commons-runtime\3.0.7\istack-commons-runtime-3.0.7.jar;C:\Users\User303\.m2\repository\org\jvnet\staxex\stax-ex\1.8\stax-ex-1.8.jar;C:\Users\User303\.m2\repository\com\sun\xml\fastinfoset\FastInfoset\1.2.15\FastInfoset-1.2.15.jar;C:\Users\User303\.m2\repository\org\hibernate\hibernate-entitymanager\5.6.15.Final\hibernate-entitymanager-5.6.15.Final.jar osemes.javapro.dz30.Main
вер. 10, 2023 12:16:33 ПП org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.15.Final
вер. 10, 2023 12:16:34 ПП org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
вер. 10, 2023 12:16:34 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
вер. 10, 2023 12:16:34 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: using driver [com.mysql.cj.jdbc.Driver] at URL [jdbc:mysql://localhost:3306/db_student]
вер. 10, 2023 12:16:34 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=root}
вер. 10, 2023 12:16:34 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
вер. 10, 2023 12:16:34 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
вер. 10, 2023 12:16:34 ПП org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
вер. 10, 2023 12:16:35 ПП org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@459b6c53] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
вер. 10, 2023 12:16:35 ПП org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
Hibernate: 
    insert 
    into
        Student
        (email, name) 
    values
        (?, ?)
вер. 10, 2023 12:16:35 ПП org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PoolState stop
INFO: HHH10001008: Cleaning up connection pool [jdbc:mysql://localhost:3306/db_student]

Process finished with exit code 0
