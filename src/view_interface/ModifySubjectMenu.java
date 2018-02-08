package view_interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.Enrollment;
import model.Student;
import model.Subject;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hibernate.HibernateConfig;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ModifySubjectMenu {

	private JFrame frmChangeOrDelete;
	private JTextField txtName;
	private JTextField txtCode;
	private JTextField txtCorrelatives;
	private JTextField txtHsWeek;
	private JLabel lblMarkOne;
	private JLabel lblMarkTwo;
	private JLabel lblFinalMark;
	
	private JComboBox subjectsCombo;
	private JComboBox statusCombo;
	private JComboBox markCombo1;
	private JComboBox markCombo2;
	private JComboBox markCombo3;
	
	private JButton btnChange;
	
	private Student std;
	private Subject sbj;
	private Enrollment enrollment;
	private Enrollment parcialEnrollment;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNewLabel_1;
	
	private int xx;
	private int xy;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifySubjectMenu window = new ModifySubjectMenu();
					window.frmChangeOrDelete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifySubjectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		parcialEnrollment = new Enrollment();
		
		markCombo1 = new JComboBox();
		markCombo2 = new JComboBox();
		markCombo3 = new JComboBox();
		markCombo1.addItem("Select a mark");
		markCombo2.addItem("Select a mark");
		markCombo3.addItem("Select a mark");

		//Se cargan los markCombo
		
		for (int i = 1; i < 11; i++) {
			markCombo1.addItem(i);
			markCombo2.addItem(i);
			markCombo3.addItem(i);
		}
		
		subjectsCombo = new JComboBox();
		subjectsCombo.addItem("                                  Subject");
		subjectsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (subjectsCombo.getSelectedIndex() != 0) {
					//Codigo para cambiarle el estado a una materia o para eliminarla del estado de cursada.
					Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.name = :name");
					query.setParameter("name",subjectsCombo.getSelectedItem());
					sbj = (Subject) query.uniqueResult();
					
					//Una vez obtenida la materia se rellenan los campos.
					enrollment = std.getEnrollment(sbj.getName());
					btnChange.setEnabled(true);
					txtName.setText(sbj.getName());
					txtCode.setText(String.valueOf(sbj.getCode()));
					txtCorrelatives.setText(sbj.getCorrelatives());
					txtHsWeek.setText(String.valueOf(sbj.getHoursWeek()));
					markCombo1.setSelectedIndex(0);
					markCombo2.setSelectedIndex(0);
					statusCombo.setSelectedItem(enrollment.getStatus());
					markCombo1.setSelectedIndex(Integer.parseInt(String.valueOf((int)enrollment.getMarkOne())));
					markCombo2.setSelectedIndex(Integer.parseInt(String.valueOf((int)enrollment.getMarkTwo())));
				} else {
					txtName.setText("");
					btnChange.setEnabled(false);
					txtCode.setText("");
					txtCorrelatives.setText("");
					txtHsWeek.setText("");
					statusCombo.setSelectedItem(0);
					panel_1.setVisible(false);
				}
			}
		});
		subjectsCombo.setBounds(114, 66, 304, 71);
		
		frmChangeOrDelete = new JFrame();
		frmChangeOrDelete.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				frmChangeOrDelete.setLocation(x - xx, y - xy);
			}
		});
		frmChangeOrDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		frmChangeOrDelete.getContentPane().setBackground(new Color(0, 0, 0));
		frmChangeOrDelete.setUndecorated(true);
		frmChangeOrDelete.setTitle("Change or Delete a Subject");
		frmChangeOrDelete.setBounds(100, 100, 503, 592);
		frmChangeOrDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangeOrDelete.getContentPane().setLayout(null);
		frmChangeOrDelete.setLocationRelativeTo(null);
		
		frmChangeOrDelete.getContentPane().add(subjectsCombo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(51, 204, 51));
		lblName.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblName.setBounds(32, 162, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblName);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setForeground(new Color(51, 204, 51));
		lblCode.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCode.setBounds(32, 207, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblCode);
		
		JLabel labelCorrelatives = new JLabel("Correlative");
		labelCorrelatives.setForeground(new Color(51, 204, 51));
		labelCorrelatives.setFont(new Font("LLPixel", Font.PLAIN, 18));
		labelCorrelatives.setBounds(32, 249, 109, 29);
		frmChangeOrDelete.getContentPane().add(labelCorrelatives);
		
		JLabel lblHsweek = new JLabel("Hs/Week");
		lblHsweek.setForeground(new Color(51, 204, 51));
		lblHsweek.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblHsweek.setBounds(32, 297, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblHsweek);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(51, 204, 51));
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setBounds(32, 343, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblStatus);
		
		lblMarkOne = new JLabel("First Mark");
		lblMarkOne.setForeground(new Color(51, 204, 51));
		lblMarkOne.setVisible(false);
		lblMarkOne.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarkOne.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblMarkOne.setBounds(64, 400, 109, 22);
		
		lblMarkTwo = new JLabel("Second Mark");
		lblMarkTwo.setForeground(new Color(51, 204, 51));
		lblMarkTwo.setVisible(false);
		lblMarkTwo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarkTwo.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblMarkTwo.setBounds(64, 441, 119, 22);
		
		lblFinalMark = new JLabel("Final Mark");
		lblFinalMark.setForeground(new Color(51, 204, 51));
		lblFinalMark.setHorizontalTextPosition(SwingConstants.LEFT);
		lblFinalMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblFinalMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblFinalMark.setVisible(false);
		lblFinalMark.setBounds(64, 482, 109, 22);
		
		frmChangeOrDelete.getContentPane().add(lblMarkOne);
		frmChangeOrDelete.getContentPane().add(lblMarkTwo);
		frmChangeOrDelete.getContentPane().add(lblFinalMark);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		JRadioButton rdbtnNo = new JRadioButton("No");
		JLabel lblRetrieve = new JLabel("Retrieve?");
		
		statusCombo = new JComboBox();
		statusCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!statusCombo.getSelectedItem().equals("Waiting Subject")) {
					if (String.valueOf(statusCombo.getSelectedItem()).equals("FINAL")) {
						lblFinalMark.setVisible(true);
						markCombo3.setVisible(true);
						markCombo3.setSelectedIndex(Integer.parseInt(String.valueOf((int)enrollment.getAverage())));
						markCombo1.setEnabled(false);
						markCombo2.setEnabled(false);
						panel_1.setVisible(true);
						lblRetrieve.setVisible(true);
						rdbtnNo.setVisible(true);
						rdbtnYes.setVisible(true);
					} else if (!String.valueOf(statusCombo.getSelectedItem()).equals("APROBADA")) {
						if (!String.valueOf(statusCombo.getSelectedItem()).equals("CURSANDO")) {
							panel_1.setVisible(true);
							lblRetrieve.setVisible(true);
							rdbtnNo.setVisible(true);
							rdbtnYes.setVisible(true);
						}
					}
					
					lblMarkOne.setVisible(true);
					lblMarkTwo.setVisible(true);
					markCombo1.setVisible(true);
					markCombo2.setVisible(true);
				}
					
			}
		});
		statusCombo.setEnabled(false);
		statusCombo.setBounds(152, 334, 228, 46);
		statusCombo.addItem("Waiting Subject");
		statusCombo.addItem("CURSANDO");
		statusCombo.addItem("APROBADA");
		statusCombo.addItem("FINAL");
		statusCombo.addItem("DESAPROBADA");
		statusCombo.setSelectedIndex(0);
		frmChangeOrDelete.getContentPane().add(statusCombo);
		
		btnChange = new JButton("");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChange.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnChange.setBackground(new Color(153, 153, 153));
			}
		});
		btnChange.setIcon(new ImageIcon(ModifySubjectMenu.class.getResource("/background/if_User_Interface-04_2044281.png")));
		btnChange.setBackground(new Color(153, 153, 153));
		btnChange.setBorderPainted(false);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se almacenan los datos en el estudiante y se modifica la Base de Datos
				//Se completa el enrollment con los datos actuales para subirse a la Base de Datos
				//Si la materia esta desaprobada, se queda almacenada en cursando para que se modifiquen los valores o se elimine
				enrollment.setMarkOne(parcialEnrollment.getMarkOne());
				enrollment.setMarkTwo(parcialEnrollment.getMarkTwo());
				enrollment.setAverage(parcialEnrollment.getAverage());
				enrollment.setStatus(String.valueOf(statusCombo.getSelectedItem()));
				enrollment.setSubject(sbj);
				std.setEnrollment(enrollment);
				enrollment.setStudent(std);
				
				try {
					Session sesion = HibernateConfig.getCurrentSession();
					sesion.beginTransaction();
					sesion.save(enrollment);
					sesion.getTransaction().commit();
					sesion.close();
					
					JOptionPane.showMessageDialog(null, "La materia se modifico correctamente.");
					exit();
				} catch (Exception m) {
					JOptionPane.showMessageDialog(null, "Error al modificar/eliminar la materia.");
				}
				
			}
		});
		btnChange.setEnabled(false);
		btnChange.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnChange.setBounds(77, 544, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnChange);
		
		JButton btnCancel = new JButton("");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setBackground(new Color(153, 153, 153));
			}
		});
		btnCancel.setIcon(new ImageIcon(ModifySubjectMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		btnCancel.setBackground(new Color(153, 153, 153));
		btnCancel.setBorderPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnCancel.setBounds(275, 544, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnCancel);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setBounds(152, 153, 228, 46);
		frmChangeOrDelete.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setColumns(10);
		txtCode.setBounds(152, 198, 228, 46);
		frmChangeOrDelete.getContentPane().add(txtCode);
		
		txtCorrelatives = new JTextField();
		txtCorrelatives.setEnabled(false);
		txtCorrelatives.setColumns(10);
		txtCorrelatives.setBounds(152, 243, 228, 46);
		frmChangeOrDelete.getContentPane().add(txtCorrelatives);
		
		txtHsWeek = new JTextField();
		txtHsWeek.setEnabled(false);
		txtHsWeek.setColumns(10);
		txtHsWeek.setBounds(152, 288, 228, 46);
		frmChangeOrDelete.getContentPane().add(txtHsWeek);
		
		JLabel lblcodecodeetc = new JLabel("(Code/Code/etc)");
		lblcodecodeetc.setEnabled(false);
		lblcodecodeetc.setBounds(392, 258, 97, 16);
		frmChangeOrDelete.getContentPane().add(lblcodecodeetc);
		
		markCombo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (markCombo1.getSelectedIndex() != 0) {
					if (markCombo2.getSelectedIndex() != 0) {
						float avg = 0;
						if (Integer.parseInt(String.valueOf(markCombo1.getSelectedItem())) < 4
								|| Integer.parseInt(String.valueOf(markCombo2.getSelectedItem())) < 4) {
							statusCombo.setSelectedItem("DESAPROBADA");
						} else {
							avg = (Float.parseFloat(String.valueOf(markCombo1.getSelectedItem()))
									+ Integer.parseInt(String.valueOf(markCombo2.getSelectedItem()))) / 2;
							if (avg >= 4 && avg < 7) {
								statusCombo.setSelectedItem("FINAL");
							} else if (avg >= 7) {
								statusCombo.setSelectedItem("APROBADA");
							}
						}
						parcialEnrollment.setAverage(avg);
					}
					parcialEnrollment.setMarkOne(Integer.parseInt(String.valueOf(markCombo1.getSelectedItem())));
				} else if (enrollment.getMarkOne() == 0) {
					parcialEnrollment.setMarkOne(0);
				}
			}
		});
		markCombo1.setVisible(false);
		markCombo1.setBounds(204, 400, 109, 22);
		frmChangeOrDelete.getContentPane().add(markCombo1);
		
		markCombo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (markCombo2.getSelectedIndex() != 0) {
					if (markCombo1.getSelectedIndex() != 0) {
						float avg = 0;
						if (Integer.parseInt(String.valueOf(markCombo1.getSelectedItem())) < 4
								|| Integer.parseInt(String.valueOf(markCombo2.getSelectedItem())) < 4) {
							statusCombo.setSelectedItem("DESAPROBADA");
						} else {
							avg = (Integer.parseInt(String.valueOf(markCombo1.getSelectedItem()))
									+ Integer.parseInt(String.valueOf(markCombo2.getSelectedItem()))) / 2;
							if (avg >= 4 && avg < 7) {
								statusCombo.setSelectedItem("FINAL");
							} else if (avg >= 7) {
								statusCombo.setSelectedItem("APROBADA");
							}
						}
						parcialEnrollment.setAverage(avg);
					}
					parcialEnrollment.setMarkTwo(Integer.parseInt(String.valueOf(markCombo2.getSelectedItem())));
				} else if (enrollment.getMarkTwo() == 0) {
					parcialEnrollment.setMarkTwo(0);
				}
			}
		});
		markCombo2.setVisible(false);
		markCombo2.setBounds(204, 441, 109, 22);
		frmChangeOrDelete.getContentPane().add(markCombo2);
		
		markCombo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (markCombo3.getSelectedIndex() != 0) {
					if (Integer.parseInt(String.valueOf(markCombo3.getSelectedItem())) < 4) {
						statusCombo.setSelectedItem("DESAPROBADA");
					} else {
						if (Integer.parseInt(String.valueOf(markCombo3.getSelectedItem())) >= 4) {
							statusCombo.setSelectedItem("APROBADA");
						}
					}
					parcialEnrollment.setAverage(Integer.parseInt(String.valueOf(markCombo3.getSelectedItem())));
				} else
					parcialEnrollment.setAverage(0);
			}
		});
		markCombo3.setVisible(false);
		markCombo3.setBounds(204, 482, 109, 22);
		frmChangeOrDelete.getContentPane().add(markCombo3);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 503, 53);
		frmChangeOrDelete.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(153, 153, 153));
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ModifySubjectMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setBounds(459, 13, 32, 32);
		panel.add(lblNewLabel);
		
		label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmChangeOrDelete.setState(Frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(153, 153, 153));
			}
		});
		label.setIcon(new ImageIcon(ModifySubjectMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		label.setOpaque(true);
		label.setBackground(new Color(153, 153, 153));
		label.setBounds(413, 13, 32, 32);
		panel.add(label);
		
		lblNewLabel_1 = new JLabel("Modify Subject");
		lblNewLabel_1.setForeground(new Color(51, 204, 51));
		lblNewLabel_1.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel_1.setBounds(12, 18, 258, 27);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(325, 400, 164, 104);
		frmChangeOrDelete.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnNo.setBounds(12, 61, 127, 25);
		panel_1.add(rdbtnNo);
		rdbtnNo.setForeground(new Color(255, 255, 255));
		rdbtnNo.setBackground(new Color(51, 51, 51));

		rdbtnYes.setBounds(12, 31, 127, 25);
		panel_1.add(rdbtnYes);
		rdbtnYes.setForeground(new Color(255, 255, 255));
		rdbtnYes.setBackground(new Color(51, 51, 51));
		
		lblRetrieve.setBounds(12, 0, 140, 22);
		panel_1.add(lblRetrieve);
		lblRetrieve.setForeground(new Color(51, 204, 51));
		lblRetrieve.setVisible(false);
		lblRetrieve.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblRetrieve.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnYes.setVisible(false);
		rdbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				markCombo1.setEnabled(true);
				markCombo2.setEnabled(true);
				markCombo3.setVisible(false);
				lblFinalMark.setVisible(false);
				rdbtnNo.setSelected(false);
			}
		});
		rdbtnNo.setVisible(false);
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!String.valueOf(statusCombo.getSelectedItem()).equals("DESAPROBADA")) {
					lblMarkOne.setEnabled(false);
					markCombo1.setEnabled(false);
					lblMarkTwo.setEnabled(false);
					markCombo2.setEnabled(false);
					if (String.valueOf(statusCombo.getSelectedItem()).equals("FINAL")) {
						markCombo3.setVisible(true);
						lblFinalMark.setVisible(true);
					} else {
						markCombo3.setVisible(false);
						lblFinalMark.setVisible(false);
					}
				} else {
					lblMarkOne.setEnabled(false);
					markCombo1.setEnabled(false);
					lblMarkTwo.setEnabled(false);
					markCombo2.setEnabled(false);
				}
				rdbtnYes.setSelected(false);
			}
		});
	}

	protected void exit() {
		SubjectsMenu sbMenu = new SubjectsMenu();
		sbMenu.setStd(std);
		frmChangeOrDelete.dispose();
		sbMenu.getFrmSubjects().setVisible(true);
	}

	public JFrame getFrame() {
		return frmChangeOrDelete;
	}

	public void setFrame(JFrame frame) {
		this.frmChangeOrDelete = frame;
	}

	public JComboBox getSubjectsCombo() {
		return subjectsCombo;
	}

	public void setSubjectsCombo(JComboBox subjectsCombo) {
		this.subjectsCombo = subjectsCombo;
	}

	public JComboBox getStatusCombo() {
		return statusCombo;
	}

	public void setStatusCombo(JComboBox statusCombo) {
		this.statusCombo = statusCombo;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public Subject getSbj() {
		return sbj;
	}

	public void setSbj(Subject sbj) {
		this.sbj = sbj;
	}
}
