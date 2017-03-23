package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDAOImplTest {

	@Test
	public void testObtener() {
		Usuario usuario = null;
		UsuarioDAO usuarioDao = null;
		try{
			usuarioDao = new UsuarioDAOImpl();
			usuario = usuarioDao.obtener("elver");
			assertNotNull(usuario);
			System.out.println(usuario.getLogin());
		}
		catch(MyException e)
		{
			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
