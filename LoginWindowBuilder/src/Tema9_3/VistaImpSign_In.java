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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class VistaImpSign_In implements VistaSign_In {

	private JFrame frmSignIn;
	private JTextField txtUsu;
	private JTextField txtCorreo;
	private JTextField txtNombre;
	private JPasswordField pwdContra;
	private JPasswordField pwdRepet;
	private Controlador controlador;
	private Modelo model;

	/**
	 * Create the application.
	 */
	public VistaImpSign_In() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignIn = new JFrame();
		frmSignIn.getContentPane().setBackground(SystemColor.control);
		frmSignIn.setTitle("Sign In");
		frmSignIn.setBounds(100, 100, 519, 321);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblCorreo = new JLabel("Correo:");

		JLabel lblContrasea = new JLabel("Password:");

		JLabel lblRepetir = new JLabel("Repetir password:");

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pedirRegis();
			}
		});

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		txtUsu = new JTextField();
		txtUsu.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);

		pwdContra = new JPasswordField();

		pwdRepet = new JPasswordField();
		
		JLabel lblUsuarioCorreoContrasea = new JLabel("Usuario, correo, password y repetir son campos obligatorios");
		GroupLayout groupLayout = new GroupLayout(frmSignIn.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCorreo)
								.addComponent(lblContrasea)
								.addComponent(lblUsuario)
								.addComponent(lblRepetir)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNombre)
								.addComponent(txtCorreo, 312, 312, Short.MAX_VALUE)
								.addComponent(pwdRepet)
								.addComponent(pwdContra, 312, 312, Short.MAX_VALUE)
								.addComponent(txtUsu)
								.addComponent(btnAlta, Alignment.TRAILING)))
						.addComponent(lblUsuarioCorreoContrasea))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorreo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdContra, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdRepet, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRepetir))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnAlta)
							.addContainerGap(46, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblUsuarioCorreoContrasea)
							.addGap(32))))
		);
		frmSignIn.getContentPane().setLayout(groupLayout);
	}

	public void Visibilidad() {
		if (frmSignIn.isVisible()) {
			frmSignIn.setVisible(false);
		} else {
			frmSignIn.setVisible(true);
		}
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void setModelo(Modelo model) {
		this.model = model;

	}

	public String getUser() {
		return txtUsu.getText();
	}

	public String getCorreo() {
		return txtCorreo.getText();
	}

	public String getPassword() {
		return new String(pwdContra.getPassword());
	}

	public String getPasswordRep() {
		return new String(pwdRepet.getPassword());
	}
}