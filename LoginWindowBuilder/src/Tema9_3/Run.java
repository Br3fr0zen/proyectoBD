package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public class Run {
	public static void main(String[] args) {
		VistaLogin vLog = new VistaImpLogin();
		VistaSign_In vSign = new VistaImpSign_In();
		VistaWelcome vWel = new VistaImpWelcome();
		Modelo modelo = new ModeloImp();
		Controlador controlador = new ControladorImp();

		modelo.setVista(vLog);
		modelo.setVistaSign(vSign);

		vLog.setControlador(controlador);
		vLog.setModelo(modelo);

		vSign.setControlador(controlador);
		vSign.setModelo(modelo);

		vWel.setControlador(controlador);
		vWel.setModelo(modelo);

		controlador.setModelo(modelo);
		controlador.setVistaLog(vLog);
		controlador.setVistaSign(vSign);
		controlador.setVistaWel(vWel);

		vLog.Visibilidad();
	}
}