package co.edu.udea.iw.dao;

import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.edu.udea.iw.exception.MyException;

public class DataSource{
	
	private static DataSource dataSource = null;
	private SessionFactory factory = null;
	private Configuration config = new Configuration();
	
	private DataSource() { }
	
	//Metodo con el que se obtiene la instancia del DataSource
	public static DataSource getInstance()
	{
		if(dataSource == null)
		{
			dataSource = new DataSource();
		}
		return dataSource;
	}
	
	public Session getSession() throws MyException{
		try{
		
			if(factory == null){
				config.configure("co/edu/udea/iw/configFiles/hibernate.cfg.xml");
				factory = config.buildSessionFactory();
			}
		
			return factory.openSession();
		}
		catch(HibernateException e){
			throw new MyException("Error configurando la sesión",e);
		}
	}
	
}
