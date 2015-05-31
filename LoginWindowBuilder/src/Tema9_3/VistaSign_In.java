package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public interface VistaSign_In {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo model);

	public String getUser();

	public String getCorreo();

	public String getPassword();

	public String getPasswordRep();

	public void Visibilidad();
}
