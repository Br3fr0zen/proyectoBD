package Tema9_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class VistaConfigurationImp implements VistaConfiguration {
	private JFrame frmConf;
	private JPanel contentPane;
	private JTextField txtUrl;
	private JTextField txtUsu;
	private JTextField txtPass;
	private JButton btnVolver;
	private Controlador controla;
	private Modelo model;

	public VistaConfigurationImp() {
		initialize();
	}

	/**
	 * Create the frame.
	 */
	// public VistaConfigurationImp() {
	public void initialize() {
		frmConf = new JFrame();
		frmConf.setTitle("Configuracion");
		frmConf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConf.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		frmConf.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Configuración INI",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = txtUrl.getText();
				String usu = txtUsu.getText();
				String pass = txtPass.getText();
				try {
				Properties propiedades = new Properties();
				OutputStream salida = null;
				File miFichero = new File("src/Tema9_3/configuracion.ini");
				if (miFichero.exists() && !url.equals("") && !usu.equals("") && !pass.equals("")) {
					salida = new FileOutputStream(miFichero);
					propiedades.setProperty("url", txtUrl.getText());
					propiedades.setProperty("usuario", txtUsu.getText());
					propiedades.setProperty("password", txtPass.getText());
					propiedades.store(salida, "Comentario para el fichero");
				} else
					System.err.println("Fichero no encontrado");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
				Limpiar();
			}
			});
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controla.ventanaWelConf();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(121)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnVolver)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVolver)
						.addComponent(btnModificar))
					.addContainerGap(40, Short.MAX_VALUE))
		);

		JLabel lblUrl = new JLabel("Url:");

		JLabel lblUsuario = new JLabel("Usuario:");

		JLabel lblPassword = new JLabel("Password:");

		txtUrl = new JTextField();
		txtUrl.setColumns(10);
		

		txtUsu = new JTextField();
		txtUsu.setColumns(10);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(20)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addComponent(
																		lblPassword)
																.addGap(18)
																.addComponent(
																		txtPass))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addComponent(
																						lblUrl)
																				.addComponent(
																						lblUsuario))
																.addGap(27)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING,
																				false)
																				.addComponent(
																						txtUsu)
																				.addComponent(
																						txtUrl,
																						GroupLayout.DEFAULT_SIZE,
																						231,
																						Short.MAX_VALUE))))
								.addContainerGap(53, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblUrl)
												.addComponent(
														txtUrl,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(27)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblUsuario)
												.addComponent(
														txtUsu,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(27)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblPassword)
												.addComponent(
														txtPass,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(42, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}


	private void Limpiar() {
		txtUrl.setText("");
		txtUsu.setText("");
		txtPass.setText("");
	}

	public void Visibilidad() {
		if (frmConf.isVisible()) {
			frmConf.setVisible(false);
		} else {
			frmConf.setVisible(true);
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

}
