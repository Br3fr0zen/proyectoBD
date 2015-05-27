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

public class VistaImpLogin implements VistaLogin {

	private JFrame frmLogin;
	private JTextField txtUsu;
	private JPasswordField pwdField;
	private Controlador controla;
	private Modelo model;

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
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (controla.pedirLog()) {
					controla.ventanaLoginWel();
				}
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

		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addContainerGap(322, Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnRegistro)
														.addComponent(btnEntrar))
										.addGap(31))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(47)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblUsuario)
														.addComponent(
																lblContrasea))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																txtUsu,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																pwdField,
																GroupLayout.PREFERRED_SIZE,
																119,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(184, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(57)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUsuario)
														.addComponent(
																txtUsu,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblContrasea)
														.addComponent(
																pwdField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 65,
												Short.MAX_VALUE)
										.addComponent(btnEntrar)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(btnRegistro).addGap(24)));
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

}