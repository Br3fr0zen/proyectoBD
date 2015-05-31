package Tema9_3;

import java.sql.Connection;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public interface Modelo {
	public void setVista(VistaLogin vistaLog);

	public void setVistaSign(VistaSign_In vistaSign);

	public void setVistaWel(VistaWelcome vistaWel);

	public void setUserPwd(String usuario, String password);

	public boolean Login();

	public boolean Sign();
	
	public void setSign(String user, String email, String pass, String passRep);
	
	public Connection getCon();
	
	public void Conection();

	public void ConsultaSign();
	
	public void cargarTabla();
	
	public void ConsultaNew(String email, String usuario ,String pass);
	
	public void ConsultaDel(String usu);
	
	public void ConsultaModi(String usu,String email, String usuario, String password);
}
