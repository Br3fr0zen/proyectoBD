package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class VistaImpLogin implements VistaLogin {

	private JFrame frmLogin;
	private JTextField txtUsu;
	private JPasswordField pwdField;
	private Controlador controla;
	private Modelo model;
	private JLabel lblUsuarioYoContra;

	/**
	 * Create the application.
	 */
	public VistaImpLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 435, 303);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controla.pedirLog();
			}
		});

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controla.ventanaLoginSign();
			}
		});

		txtUsu = new JTextField();
		txtUsu.setColumns(10);

		pwdField = new JPasswordField();
		pwdField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(new String(pwdField.getPassword()));
			}
		});
		
		lblUsuarioYoContra = new JLabel("Usuario y/o contrase\u00F1a incorrectos");
		lblUsuarioYoContra.setForeground(Color.RED);
		lblUsuarioYoContra.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(69)
							.addComponent(lblUsuario)
							.addGap(12)
							.addComponent(txtUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblContrasea)
							.addGap(12)
							.addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblUsuarioYoContra)
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEntrar)
								.addComponent(btnRegistro))))
					.addGap(160))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUsuario))
						.addComponent(txtUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblContrasea))
						.addComponent(pwdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar)
						.addComponent(lblUsuarioYoContra))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRegistro))
		);
		frmLogin.getContentPane().setLayout(groupLayout);

	}

	public void Visibilidad() {
		if (frmLogin.isVisible()) {
			frmLogin.setVisible(false);
		} else {
			frmLogin.setVisible(true);
		}
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controla = controlador;

	}

	@Override
	public void setModelo(Modelo model) {
		this.model = model;

	}

	@Override
	public String getUser() {
		return txtUsu.getText();
	}

	@Override
	public String getPassword() {
		return new String(pwdField.getPassword());
	}
	
	public void setError(){
		lblUsuarioYoContra.setVisible(true);
	
	}
}