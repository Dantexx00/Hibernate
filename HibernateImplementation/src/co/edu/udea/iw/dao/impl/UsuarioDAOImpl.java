package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOImpl implements UsuarioDAO {

	@Override
	public Usuario obtener(String login) throws MyException {
		
		Usuario usuario = null;
		Session session = null;
		try{
			session = DataSource.getInstance().getSession();
			usuario = (Usuario) session.get(Usuario.class,login);
		}catch(HibernateException e){
			throw new MyException("Error consultando usuarios",e);
		}
		return usuario;
	}

}
