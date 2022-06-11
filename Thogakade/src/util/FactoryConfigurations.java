package util;

import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class FactoryConfigurations {
    private static FactoryConfigurations factoryConfigurations;
    private final SessionFactory sessionFactory;

    private FactoryConfigurations() {
        Properties propertyFile = new Properties();
        propertyFile.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        propertyFile.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        propertyFile.setProperty("hibernate.connection.ur", "jdbc:mysql://localhost:3306/thogakade?createDatabaseIfNotExist=true");
        propertyFile.setProperty("hibernate.connection.username", "root");
        propertyFile.setProperty("hibernate.connection.password", "1234");
        propertyFile.setProperty("hibernate.show_sql", "true");
        propertyFile.setProperty("hibernate.hbm2ddl", "update");
        Configuration config = new Configuration().setProperties(propertyFile).configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class);
        sessionFactory = config.buildSessionFactory();
    }

    public static FactoryConfigurations getInstance() {
        return factoryConfigurations == null ? factoryConfigurations = new FactoryConfigurations() : factoryConfigurations;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
