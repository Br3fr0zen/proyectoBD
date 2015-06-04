package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public interface Controlador {
	public void setModelo(Modelo modelo);

	public void setVistaLog(VistaLogin vistaLog);

	public void setVistaSign(VistaSign_In vistaSign);

	public void setVistaWel(VistaWelcome vistaWel);
	
	public void setVistaConf(VistaConfiguration vistaConf);

	public void pedirLog();

	public void pedirRegis();

	public void ventanaLoginSign();

	public void ventanaLoginWel();
	
	public void ventanaWelConf();
	
	public void ventanaConf();
	
	public void cargarTabla();

}
