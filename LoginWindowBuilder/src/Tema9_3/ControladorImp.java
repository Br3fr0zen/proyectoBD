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
	private VistaConfiguration vistaConf;
	private String usu, pwd, user, mail, pass, passRep;

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
	public void setVistaConf(VistaConfiguration vistaConf) {
		this.vistaConf = vistaConf;
	}

	@Override
	public void pedirLog() {
		usu = vistaLog.getUser();
		pwd = vistaLog.getPassword();
		model.setUserPwd(usu, pwd);
		if(model.Login()){
			ventanaLoginWel();
		}

	}

	@Override
	public void pedirRegis() {
		user = vistaSign.getUser();
		mail = vistaSign.getCorreo();
		pass = vistaSign.getPassword();
		passRep = vistaSign.getPasswordRep();
		model.setSign(user, mail, pass, passRep);
		if(model.Sign()){
			model.ConsultaSign();
			ventanaLoginSign();
		}
		
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
	
	public void ventanaConf() {
		vistaLog.Visibilidad();
		vistaWel.Visibilidad();

	}

	@Override
	public void cargarTabla() {
		model.cargarTabla();
		
	}

	@Override
	public void ventanaWelConf() {
		vistaWel.Visibilidad();
		vistaConf.Visibilidad();
		
	}
}
