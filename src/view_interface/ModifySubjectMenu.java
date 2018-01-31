package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.naming.MalformedLinkException;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Enrollment;
import model.Student;
import model.Subject;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.internal.util.MarkerObject;
import org.hibernate.query.Query;

import hibernate.HibernateConfig;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

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
	private Student stdBk;
	private Subject sbj;
	private Enrollment enrollment;

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
		
		subjectsCombo = new JComboBox();
		subjectsCombo.addItem("Select a Subject");
		
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
				}
			}
		});
		subjectsCombo.setBounds(204, 37, 198, 27);
		
		frmChangeOrDelete = new JFrame();
		frmChangeOrDelete.setTitle("Change or Delete a Subject");
		frmChangeOrDelete.setBounds(100, 100, 503, 562);
		frmChangeOrDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangeOrDelete.getContentPane().setLayout(null);
		frmChangeOrDelete.setLocationRelativeTo(null);
		
		JLabel lblSelectASubject = new JLabel("Select a subject");
		lblSelectASubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSelectASubject.setBounds(18, 31, 179, 38);
		frmChangeOrDelete.getContentPane().add(lblSelectASubject);
		
		frmChangeOrDelete.getContentPane().add(subjectsCombo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblName.setBounds(20, 93, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblName);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCode.setBounds(20, 138, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblCode);
		
		JLabel labelCorrelatives = new JLabel("Correlative");
		labelCorrelatives.setFont(new Font("LLPixel", Font.PLAIN, 18));
		labelCorrelatives.setBounds(20, 183, 109, 29);
		frmChangeOrDelete.getContentPane().add(labelCorrelatives);
		
		JLabel lblHsweek = new JLabel("Hs/Week");
		lblHsweek.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblHsweek.setBounds(20, 228, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblHsweek);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setBounds(20, 273, 109, 22);
		frmChangeOrDelete.getContentPane().add(lblStatus);
		
		lblMarkOne = new JLabel("First Mark");
		lblMarkOne.setVisible(false);
		lblMarkOne.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarkOne.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblMarkOne.setBounds(59, 323, 109, 22);
		
		lblMarkTwo = new JLabel("Second Mark");
		lblMarkTwo.setVisible(false);
		lblMarkTwo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarkTwo.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblMarkTwo.setBounds(59, 364, 119, 22);
		
		lblFinalMark = new JLabel("Final Mark");
		lblFinalMark.setHorizontalTextPosition(SwingConstants.LEFT);
		lblFinalMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblFinalMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblFinalMark.setVisible(false);
		lblFinalMark.setBounds(59, 411, 109, 22);
		
		frmChangeOrDelete.getContentPane().add(lblMarkOne);
		frmChangeOrDelete.getContentPane().add(lblMarkTwo);
		frmChangeOrDelete.getContentPane().add(lblFinalMark);
		
		statusCombo = new JComboBox();
		statusCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!statusCombo.getSelectedItem().equals("Waiting Subject")) {
					if (String.valueOf(statusCombo.getSelectedItem()).equals("FINAL")) {
						lblFinalMark.setVisible(true);
						markCombo3.setVisible(true);
						markCombo3.setSelectedIndex(Integer.parseInt(String.valueOf((int)enrollment.getAverage())));
					}
					
					lblMarkOne.setVisible(true);
					lblMarkTwo.setVisible(true);
					markCombo1.setVisible(true);
					markCombo2.setVisible(true);
				}
			}
		});
		statusCombo.setEnabled(false);
		statusCombo.setBounds(139, 272, 228, 25);
		statusCombo.addItem("Waiting Subject");
		statusCombo.addItem("CURSANDO");
		statusCombo.addItem("APROBADA");
		statusCombo.addItem("FINAL");
		statusCombo.addItem("DESAPROBADA");
		statusCombo.setSelectedIndex(0);
		frmChangeOrDelete.getContentPane().add(statusCombo);
		
		btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se almacenan los datos en el estudiante y se modifica la Base de Datos
				//Se completa el enrollment con los datos actuales para subirse a la Base de Datos
				enrollment.setStatus(String.valueOf(statusCombo.getSelectedItem()));
				std.setEnrollment(enrollment);
				enrollment.setStudent(std);
				enrollment.setSubject(sbj);
				
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
		btnChange.setBounds(72, 467, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnChange);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnCancel.setBounds(270, 467, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnCancel);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setBounds(140, 93, 228, 24);
		frmChangeOrDelete.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setColumns(10);
		txtCode.setBounds(140, 138, 228, 25);
		frmChangeOrDelete.getContentPane().add(txtCode);
		
		txtCorrelatives = new JTextField();
		txtCorrelatives.setEnabled(false);
		txtCorrelatives.setColumns(10);
		txtCorrelatives.setBounds(140, 183, 228, 25);
		frmChangeOrDelete.getContentPane().add(txtCorrelatives);
		
		txtHsWeek = new JTextField();
		txtHsWeek.setEnabled(false);
		txtHsWeek.setColumns(10);
		txtHsWeek.setBounds(140, 228, 228, 25);
		frmChangeOrDelete.getContentPane().add(txtHsWeek);
		
		JLabel lblcodecodeetc = new JLabel("(Code/Code/etc)");
		lblcodecodeetc.setEnabled(false);
		lblcodecodeetc.setBounds(371, 188, 97, 16);
		frmChangeOrDelete.getContentPane().add(lblcodecodeetc);
		
		markCombo1 = new JComboBox();
		markCombo1.addItem("Select a mark");
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
						enrollment.setAverage(avg);
					}
					
					enrollment.setMarkOne(Integer.parseInt(String.valueOf(markCombo1.getSelectedItem())));
				} else 
					enrollment.setMarkOne(0);
			}
		});
		markCombo1.setVisible(false);
		markCombo1.setBounds(199, 323, 109, 22);
		frmChangeOrDelete.getContentPane().add(markCombo1);
		
		markCombo2 = new JComboBox();
		markCombo2.addItem("Select a mark");
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
						
						enrollment.setAverage(avg);
					}

					enrollment.setMarkTwo(Integer.parseInt(String.valueOf(markCombo2.getSelectedItem())));
				} else
					enrollment.setMarkTwo(0);
			}
		});
		markCombo2.setVisible(false);
		markCombo2.setBounds(200, 364, 108, 22);
		frmChangeOrDelete.getContentPane().add(markCombo2);
		
		markCombo3 = new JComboBox();
		markCombo3.addItem("Select a mark");
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
					enrollment.setAverage(Integer.parseInt(String.valueOf(markCombo3.getSelectedItem())));
				} else
					enrollment.setAverage(0);
			}
		});
		markCombo3.setVisible(false);
		markCombo3.setBounds(199, 411, 109, 22);
		frmChangeOrDelete.getContentPane().add(markCombo3);

		
		for (int i = 1; i < 11; i++) {
			markCombo1.addItem(i);
			markCombo2.addItem(i);
			markCombo3.addItem(i);
		}
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
