package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public interface VistaLogin {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo model);

	public String getUser();

	public String getPassword();

	public void Visibilidad();

}
