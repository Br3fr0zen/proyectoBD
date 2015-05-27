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
		frmSignIn.setTitle("Sign In");
		frmSignIn.setBounds(100, 100, 519, 300);
		frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblCorreo = new JLabel("Correo:");

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");

		JLabel lblRepetir = new JLabel("Repetir:");

		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(pwdRepet.getPassword()).equals(new String(
						pwdContra.getPassword()))) {

					controlador.ventanaLoginSign();
				}
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
		GroupLayout groupLayout = new GroupLayout(frmSignIn.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap(18, Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCorreo)
																						.addComponent(
																								lblContrasea)
																						.addComponent(
																								lblUsuario)
																						.addComponent(
																								lblRepetir)
																						.addComponent(
																								lblNombre))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								txtNombre)
																						.addComponent(
																								txtCorreo,
																								312,
																								312,
																								Short.MAX_VALUE)
																						.addComponent(
																								pwdRepet)
																						.addComponent(
																								pwdContra,
																								312,
																								312,
																								Short.MAX_VALUE)
																						.addComponent(
																								txtUsu))
																		.addContainerGap(
																				83,
																				Short.MAX_VALUE))
														.addGroup(
																Alignment.TRAILING,
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnAlta)
																		.addGap(28)))));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(23)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNombre))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtUsu,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblUsuario))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtCorreo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCorreo))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																pwdContra,
																GroupLayout.PREFERRED_SIZE,
																21,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblContrasea))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																pwdRepet,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRepetir))
										.addGap(18).addComponent(btnAlta)
										.addContainerGap(25, Short.MAX_VALUE)));
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
}