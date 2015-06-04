package Tema9_3;

/**
 * 
 * @author Javier Bravo, Miguel Ángel y Manuel
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaImpWelcome implements VistaWelcome {
	DefaultTableModel modelo;
	private JFrame frmWel;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtUsu;
	private JTextField txtPass;
	private JTable table;
	private int row = -1;
	private Controlador controla;
	private Modelo model;

	public VistaImpWelcome() {
		initialize();
	}

	public void initialize() {
		frmWel = new JFrame();
		frmWel.setTitle("Tabla de contenido");
		frmWel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWel.setBounds(100, 100, 652, 644);
		contentPane = new JPanel();
		frmWel.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Datos del usuario",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JLabel lblNombre = new JLabel("Email:");

		JLabel lblApellido = new JLabel("Usuario:");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		txtUsu = new JTextField();
		txtUsu.setColumns(10);

		JLabel lblNick = new JLabel("Password:");

		txtPass = new JTextField();
		txtPass.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(33)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblApellido)
												.addComponent(lblNombre)
												.addComponent(
														lblNick,
														GroupLayout.PREFERRED_SIZE,
														71,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addComponent(txtPass, 187,
														187, Short.MAX_VALUE)
												.addComponent(txtUsu)
												.addComponent(
														txtEmail,
														GroupLayout.PREFERRED_SIZE,
														399,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNombre)
												.addComponent(
														txtEmail,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblApellido)
												.addComponent(
														txtUsu,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblNick)
												.addComponent(
														txtPass,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			// no iguales y q distinga mayus de minus
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String usu = txtUsu.getText();
				String pass = txtPass.getText();
				if (!email.equals("") && !usu.equals("") && !pass.equals("")) {
					if (email.contains("@") && email.contains(".")) {
						Object datos[] = { email, usu, pass };
						modelo.addRow(datos);
						model.ConsultaNew(email, usu, pass);
						Limpiar();
					}
				}
			}
		});

		String Cabecera[] = { "Email", "Usuario", "Password" };
		String Datos[][] = {};
		modelo = new DefaultTableModel(Datos, Cabecera);
		frmWel.getComponents();
		// tb falla al modificar si ya hay una linea q la graba en blanco
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String usu = txtUsu.getText();
				String pass = txtPass.getText();
				if (!email.equals("") && !usu.equals("") && !pass.equals("")) {
					try {
						Object datos[] = new Object[3];
						datos[0] = email;
						datos[1] = usu;
						datos[2] = pass;
						model.ConsultaModi((String) modelo.getValueAt(row, 1),
								txtEmail.getText(), txtUsu.getText(),
								txtPass.getText());
						modelo.setValueAt(datos[0], row, 0);
						modelo.setValueAt(datos[1], row, 1);
						modelo.setValueAt(datos[2], row, 2);
						row = -1;
					} catch (ArrayIndexOutOfBoundsException err) {
						err.printStackTrace();
					}
				}
				Limpiar();
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (row > -1) {
						modelo.removeRow(row);
						model.ConsultaDel(txtUsu.getText());
						row = -1;
					}
				} catch (ArrayIndexOutOfBoundsException err) {
					err.printStackTrace();
				}
				Limpiar();
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controla.ventanaWelConf();
			}
		});

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addComponent(btnNuevo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModificar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(btnConfiguracion)
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevo)
						.addComponent(btnModificar)
						.addComponent(btnEliminar)
						.addComponent(btnSalir)
						.addComponent(btnConfiguracion))
					.addGap(59))
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				panel_2,
																				GroupLayout.PREFERRED_SIZE,
																				573,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(12)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								panel,
																								GroupLayout.PREFERRED_SIZE,
																								565,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								panel_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(49, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 361,
								Short.MAX_VALUE).addContainerGap()));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(450, 300));
		table.setSurrendersFocusOnKeystroke(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				row = table.getSelectedRow();
				if (row > -1) {
					txtEmail.setText((String) modelo.getValueAt(row, 0));
					txtUsu.setText((String) modelo.getValueAt(row, 1));
					txtPass.setText((String) modelo.getValueAt(row, 2));
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(modelo);
		contentPane.setLayout(gl_contentPane);

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
	public void Visibilidad() {
		if (frmWel.isVisible()) {
			frmWel.setVisible(false);
		} else {
			frmWel.setVisible(true);
		}

	}

	@Override
	public void cargaTabla(String mail, String usu, String pass) {
		Object data[] = { mail, usu, pass };
		modelo.addRow(data);

	}

	public String getMail() {
		return txtEmail.getText();
	}

	public String getUsu() {
		return txtUsu.getText();
	}

	public String getPass() {
		return txtPass.getText();
	}

	private void Limpiar() {
		txtEmail.setText("");
		txtUsu.setText("");
		txtPass.setText("");
	}

	public void initTable() {
		controla.cargarTabla();
	}

}
