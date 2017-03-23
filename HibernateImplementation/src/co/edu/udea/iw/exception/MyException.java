package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

/**
 * @author Santiago Zapata Palacio
 * Clase que maneja la excepsiones del sistema
 **/
public class MyException extends Exception{

	Logger log = Logger.getLogger(this.getClass());
	
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		log.error(message, cause);
	}

	public MyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
