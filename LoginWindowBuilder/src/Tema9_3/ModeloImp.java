package Tema9_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
public class ModeloImp implements Modelo {
	private VistaLogin vistaLog;
	private VistaSign_In vistaSign;
	private VistaWelcome vistaWel;
	private VistaConfiguration vistaConf;
	private String usuario, email, password, passRep, url;
	private Connection conexion;

	public void Conection(String url, String usuario, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usuario, password);
			System.out
					.println("- Conexión a ORACLE establecida - , Bienvenido "
							+ usuario);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return conexion;
	}

	public void setCon(Connection con) {
		this.conexion = con;
	}

	public void cargarTabla() {
		String query = "SELECT * FROM BRAVO.USUARIO";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			ResultSet resul = pstmt.executeQuery();
			while (resul.next())
				vistaWel.cargaTabla(resul.getString(1), resul.getString(2),
						resul.getString(3));
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public String ConsultaUsu(String usu) {
		String query = "SELECT Password FROM BRAVO.USUARIO WHERE Usuario = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usu);
			ResultSet resul = pstmt.executeQuery();
			if (resul.next())
				return resul.getString(1);
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return "";
	}

	public void ConsultaSign() {
		String query = "INSERT INTO BRAVO.USUARIO VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, usuario);
			pstmt.setString(3, password);
			ResultSet resul = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void ConsultaNew(String email, String usuario, String password) {
		String query = "INSERT INTO BRAVO.USUARIO VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, usuario);
			pstmt.setString(3, password);
			ResultSet resul = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void ConsultaModi(String usu, String email, String usuario,
			String password) {
		String query = "UPDATE BRAVO.USUARIO SET CORREO = ?, USUARIO = ? , PASSWORD = ? WHERE USUARIO = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, usuario);
			pstmt.setString(3, password);
			pstmt.setString(4, usu);
			ResultSet resul = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void ConsultaDel(String usu) {
		String query = "DELETE FROM BRAVO.USUARIO WHERE USUARIO = ?";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usu);
			ResultSet resul = pstmt.executeQuery();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

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
	
	public void setVistaConf(VistaConfiguration vistaConf) {
		this.vistaConf = vistaConf;
	}

	@Override
	public void setUserPwd(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public void setSign(String user, String mail, String pass, String passRep) {
		this.usuario = user;
		this.email = mail;
		this.password = pass;
		this.passRep = passRep;
	}

	@Override
	public boolean Login() {
		if (this.ConsultaUsu(usuario).equals(password) && !usuario.equals("") && !password.equals("")) {
			return true;
		} else
			vistaLog.setError();
		return false;

	}

	@Override
	public boolean Sign() {
		boolean ch1 = false, ch2 = false;
		if (this.usuario.isEmpty() || this.password.isEmpty()
				|| this.passRep.isEmpty() || this.email.isEmpty()) {
			return false;
		} else if (this.password.equals(passRep)) {
			ch2 = true;
		}
		if (this.email.contains("@") && this.email.contains(".")) {
			ch1 = true;
		}
		if (ch1 && ch2) {
			return true;
		} else {
			return false;
		}
	}

	public void arrancarINI() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Tema9_3/configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				String url = propiedades.getProperty("url");
				String password = propiedades.getProperty("password");
				String usuario = propiedades.getProperty("usuario");
				this.Conection(url, usuario, password);
			} else
				System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
