package by.htp.springmvc.dao.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import by.htp.springmvc.Entity.User;

public class HibernateUtil {
//    private static final SessionFactory sessionFactory;
//    
//    static {
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable e) {
//            System.err.println("Initial SessionFactory creation failed. " + e);
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//     
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
    

	   public static SessionFactory newSessionFactory() {
		    Properties properties = new Properties();
		    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		    //log settings
		    properties.put("hibernate.hbm2ddl.auto", "create-drop");
		    properties.put("hibernate.show_sql", "true");
		    //driver settings
		    properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		    properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/yournews?useTimezone=true&amp;serverTimezone=UTC");
		    properties.put("hibernate.connection.username", "root");
		    properties.put("hibernate.connection.password", "root");
		    //c3p0 settings
		    properties.put("hibernate.c3p0.min_size", 1);
		    properties.put("hibernate.c3p0.max_size", 5);
		 
		    return new Configuration()
		            .addProperties(properties)
		            .addAnnotatedClass(User.class)
		            .buildSessionFactory(
		                    new StandardServiceRegistryBuilder()
		                            .applySettings(properties)
		                            .build()
		    );
		}
	
}
