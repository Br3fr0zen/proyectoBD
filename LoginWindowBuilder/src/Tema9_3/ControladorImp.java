package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public class ControladorImp implements Controlador {
	private Modelo model;
	private VistaLogin vistaLog;
	private VistaSign_In vistaSign;
	private VistaWelcome vistaWel;
	private String usu, pwd;

	public ControladorImp() {
		super();
	}

	public void setModelo(Modelo modelo) {
		this.model = modelo;
	}

	@Override
	public void setVistaLog(VistaLogin vistaLog) {
		this.vistaLog = vistaLog;

	}

	@Override
	public void setVistaSign(VistaSign_In vistaSign) {
		this.vistaSign = vistaSign;

	}

	@Override
	public void setVistaWel(VistaWelcome vistaWel) {
		this.vistaWel = vistaWel;

	}

	@Override
	public boolean pedirLog() {
		usu = vistaLog.getUser();
		pwd = vistaLog.getPassword();
		model.setUserPwd(usu, pwd);
		return model.Login();

	}

	@Override
	public void pedirRegis() {

	}

	@Override
	public void ventanaLoginSign() {
		vistaLog.Visibilidad();
		vistaSign.Visibilidad();

	}

	@Override
	public void ventanaLoginWel() {
		vistaLog.Visibilidad();
		vistaWel.Visibilidad();

	}
}
