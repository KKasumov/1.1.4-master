package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/*import java.sql.*;*/


public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/dbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    /*private static Connection connection;*/
    private static SessionFactory sessionFactory = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    /*
    public static Connection getConnection() throws SQLException {
         try {
             if (connection == null || connection.isClosed()) {
                 connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             }
             connection.setAutoCommit(false);
             connection.commit();
         } catch (SQLException e) {
             connection.rollback();
             throw e;
         }
         return connection;
     }
    */

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", DRIVER)
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username",USERNAME )
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass( User.class)
                    .setProperty("hibernate.c3p0.min_size", "5")
                    .setProperty("hibernate.c3p0.max_size", "200")
                    .setProperty("hibernate.c3p0.max_statements", "200");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch ( HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}



