package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel �ngel y Manuel
 *
 */
public interface Controlador {
	public void setModelo(Modelo modelo);

	public void setVistaLog(VistaLogin vistaLog);

	public void setVistaSign(VistaSign_In vistaSign);

	public void setVistaWel(VistaWelcome vistaWel);

	public void pedirLog();

	public void pedirRegis();

	public void ventanaLoginSign();

	public void ventanaLoginWel();
	
	public void cargarTabla();

}
