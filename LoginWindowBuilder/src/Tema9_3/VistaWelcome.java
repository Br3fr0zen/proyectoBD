package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel �ngel y Manuel
 *
 */
public interface VistaWelcome {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo model);

	public void Visibilidad();
	
	public void cargaTabla(String mail, String usu, String pass);
	
	public void initTable();
}
