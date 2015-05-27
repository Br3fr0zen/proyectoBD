package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public class ModeloImp implements Modelo {
	private VistaLogin vistaLog;
	private VistaSign_In vistaSign;
	private VistaWelcome vistaWel;
	private String usu, passwd;

	@Override
	public void setVista(VistaLogin vistaLog) {
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
	public void setUserPwd(String usuario, String password) {
		this.usu = usuario;
		this.passwd = password;
	}

	@Override
	public boolean Login() {
		if (this.usu.equals(passwd)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean Sign() {
		return true;
	}

}
