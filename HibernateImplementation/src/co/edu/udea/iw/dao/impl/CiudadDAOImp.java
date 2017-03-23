package co.edu.udea.iw.dao.impl;

/*
 *@Author: Santiago Zapata Palacio
 *Clase que realiza las consultas a la tabla Ciudades 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImp implements CiudadDAO {

	//Metodo que devuelve todas las ciudades
	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		}catch(HibernateException e){
			e.printStackTrace();
			throw new MyException("Error consultando ciudades",e);
		}
		return lista;
	}

	public Ciudad obtener(long codigo) throws MyException{
		Ciudad ciudad = null;
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
			ciudad = (Ciudad) session.get(Ciudad.class,codigo);
		}catch(HibernateException e){
			throw new MyException("Error consultando ciudades",e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyException{
		Transaction tx = null;
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.save(ciudad);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Error consultando ciudades",e);
		}
	}

}
