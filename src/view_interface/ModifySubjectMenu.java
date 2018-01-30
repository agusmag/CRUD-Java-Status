package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Student;
import model.Subject;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifySubjectMenu {

	private JFrame frmChangeOrDelete;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JComboBox subjectsCombo;
	private JComboBox statusCombo;
	
	private Student std;
	private Subject sbj;

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
		frmChangeOrDelete = new JFrame();
		frmChangeOrDelete.setTitle("Change or Delete a Subject");
		frmChangeOrDelete.setBounds(100, 100, 503, 442);
		frmChangeOrDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangeOrDelete.getContentPane().setLayout(null);
		
		JLabel lblSelectASubject = new JLabel("Select a subject");
		lblSelectASubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSelectASubject.setBounds(18, 31, 179, 38);
		frmChangeOrDelete.getContentPane().add(lblSelectASubject);
		
		subjectsCombo = new JComboBox();
		subjectsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Codigo para cambiarle el estado a una materia o para eliminarla del estado de cursada.
			}
		});
		subjectsCombo.setBounds(204, 37, 198, 27);
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
		
		statusCombo = new JComboBox();
		statusCombo.setBounds(139, 272, 228, 25);
		frmChangeOrDelete.getContentPane().add(statusCombo);
		
		JButton btnChange = new JButton("Change");
		btnChange.setEnabled(false);
		btnChange.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnChange.setBounds(18, 348, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnDelete.setBounds(176, 348, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				sbMenu.setStd(std);
			}
		});
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnCancel.setBounds(336, 348, 132, 35);
		frmChangeOrDelete.getContentPane().add(btnCancel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(140, 93, 228, 24);
		frmChangeOrDelete.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(140, 138, 228, 25);
		frmChangeOrDelete.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(140, 183, 228, 25);
		frmChangeOrDelete.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(140, 228, 228, 25);
		frmChangeOrDelete.getContentPane().add(textField_3);
		
		JLabel lblcodecodeetc = new JLabel("(Code/Code/etc)");
		lblcodecodeetc.setEnabled(false);
		lblcodecodeetc.setBounds(371, 188, 97, 16);
		frmChangeOrDelete.getContentPane().add(lblcodecodeetc);
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
