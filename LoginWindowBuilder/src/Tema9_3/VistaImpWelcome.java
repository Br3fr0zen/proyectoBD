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
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNick;
	private JTable table;
	private int row;
	private Controlador controla;
	private Modelo model;

	public VistaImpWelcome() {
		initialize();
	}

	public void initialize() {
		frmWel = new JFrame();
		frmWel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWel.setBounds(100, 100, 652, 644);
		contentPane = new JPanel();
		frmWel.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Datos del usuario",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JLabel lblNombre = new JLabel("Nombre:");

		JLabel lblApellido = new JLabel("Apellido:");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);

		JLabel lblNick = new JLabel("Nick:");

		txtNick = new JTextField();
		txtNick.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING, false)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(33)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING,
																				false)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblNombre)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										txtNombre,
																										GroupLayout.PREFERRED_SIZE,
																										187,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										lblApellido)
																								.addPreferredGap(
																										ComponentPlacement.UNRELATED)
																								.addComponent(
																										txtApellido))))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(50)
																.addComponent(
																		lblNick,
																		GroupLayout.PREFERRED_SIZE,
																		34,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		txtNick)))
								.addContainerGap(270, Short.MAX_VALUE)));
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
														txtNombre,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblApellido)
												.addComponent(
														txtApellido,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(
														txtNick,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNick))
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {

			public void Limpiar() {
				txtNombre.setText("");
				txtApellido.setText("");
				txtNick.setText("");
			}

			public void actionPerformed(ActionEvent e) {
				String nom = txtNombre.getText();
				String ape = txtApellido.getText();
				String nic = txtNick.getText();

				Object datos[] = { nom, ape, nic };
				modelo.addRow(datos);
				Limpiar();
			}
		});

		String Cabecera[] = { "Nombre", "Apellido", "Nick" };
		String Datos[][] = {};
		modelo = new DefaultTableModel(Datos, Cabecera);
		frmWel.getComponents();

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = txtNombre.getText();
				String ape = txtApellido.getText();
				String nic = txtNick.getText();

				Object datos[] = new Object[3];
				datos[0] = nom;
				datos[1] = ape;
				datos[2] = nic;
				modelo.setValueAt(datos[0], row, 0);
				modelo.setValueAt(datos[1], row, 1);
				modelo.setValueAt(datos[2], row, 2);
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeRow(table.getSelectedRow());
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_1.createSequentialGroup().addGap(125)
						.addComponent(btnNuevo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnModificar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnEliminar).addGap(7)
						.addComponent(btnSalir)
						.addContainerGap(111, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						gl_panel_1
								.createSequentialGroup()
								.addContainerGap(174, Short.MAX_VALUE)
								.addGroup(
										gl_panel_1
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnModificar)
												.addComponent(btnEliminar)
												.addComponent(btnSalir)
												.addComponent(btnNuevo))
								.addGap(59)));
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
																		.addGap(12)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								panel_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								panel,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				panel_2,
																				GroupLayout.PREFERRED_SIZE,
																				573,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(49, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(13)
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				row = table.getSelectedRow();
				if (row > -1) {
					txtNombre.setText((String) modelo.getValueAt(row, 0));
					txtApellido.setText((String) modelo.getValueAt(row, 1));
					txtNick.setText((String) modelo.getValueAt(row, 2));
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
}
