package Tema9_3;

import java.sql.Connection;

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
		VistaConfiguration vConf = new VistaConfigurationImp();
		Modelo modelo = new ModeloImp();
		Controlador controlador = new ControladorImp();
		Connection con  = modelo.getCon();
		
		modelo.arrancarINI();
		modelo.setVista(vLog);
		modelo.setVistaSign(vSign);
		modelo.setVistaWel(vWel);
		modelo.setVistaConf(vConf);
		
		vLog.setControlador(controlador);
		vLog.setModelo(modelo);

		vSign.setControlador(controlador);
		vSign.setModelo(modelo);

		vWel.setControlador(controlador);
		vWel.setModelo(modelo);
		
		vConf.setControlador(controlador);
		vConf.setModelo(modelo);

		controlador.setModelo(modelo);
		controlador.setVistaLog(vLog);
		controlador.setVistaSign(vSign);
		controlador.setVistaWel(vWel);
		controlador.setVistaConf(vConf);
		
		vWel.initTable();
		vLog.Visibilidad();
		
	}
}