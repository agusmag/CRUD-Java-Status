package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Carrer;
import model.Student;
import model.Subject;

//CLASE SINGLETON

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	/*
	 * Crea la factoria de sesiones
	 */
	public static void buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Carrer.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
			      configuration.getProperties()).build();
			    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
	
	/**
	   * Abre una nueva sesión
	   */
	  public static void openSession() {
	    session = sessionFactory.openSession();
	  }
	
	  /**
	   * Devuelve la sesión actual
	   * @return
	   */
	  public static Session getCurrentSession() {
		//Devuelve la sesion actual, en caso de no encontrase ninguna abierta, la crea.
	    if ((session == null) || (!session.isOpen())) {
	    	openSession();
	    }
	    
	    return session;
	  }
	  
	  /**
	   * Cierra Hibernate
	   */
	  public static void closeSessionFactory() {
	 //Si hay alguna sesion abierta la cierra y luego siera la factoria.
	    if (session != null)
	      session.close();
	 
	    if (sessionFactory != null)
	      sessionFactory.close();
	  }
	
	/*
	 * Se desconecta de la Base de Datos y Libera el espacio de memoria de la sesion.
	 */
	private void disconnect(){
		this.sessionFactory.close();
		this.sessionFactory = null;
	}
	
	/*
	 * Sale de la aplicacion
	 */
	private void exit(){
		if (this.sessionFactory != null)
			disconnect();
		
		System.exit(0);
	}
	
}
