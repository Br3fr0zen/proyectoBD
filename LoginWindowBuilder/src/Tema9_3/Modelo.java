package Tema9_3;

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
}
