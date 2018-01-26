package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;

public class ChangeSubjectMenu {

	private JFrame frmAddToSubjects;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSubjectMenu window = new ChangeSubjectMenu();
					window.frmAddToSubjects.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeSubjectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddToSubjects = new JFrame();
		frmAddToSubjects.setTitle("Add/Modify Subject");
		frmAddToSubjects.setBounds(100, 100, 500, 517);
		frmAddToSubjects.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(12, 422, 132, 35);
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(319, 423, 136, 33);
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(20, 93, 65, 29);
		lblNewLabel.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(20, 138, 65, 24);
		lblNewLabel_1.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("Correlative");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(20, 183, 109, 29);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Hs/Week");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(20, 228, 109, 25);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(140, 93, 228, 25);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(140, 138, 228, 25);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(141, 183, 228, 25);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(141, 228, 228, 25);
		textField_3.setColumns(10);
		
		JLabel lblcode = new JLabel("(Code,Code,etc)");
		lblcode.setBounds(376, 186, 93, 16);
		lblcode.setVerticalAlignment(SwingConstants.BOTTOM);
		lblcode.setForeground(new Color(128, 128, 128));
		frmAddToSubjects.getContentPane().setLayout(null);
		frmAddToSubjects.getContentPane().add(lblNewLabel_2);
		frmAddToSubjects.getContentPane().add(lblNewLabel_3);
		frmAddToSubjects.getContentPane().add(textField_3);
		frmAddToSubjects.getContentPane().add(textField_2);
		frmAddToSubjects.getContentPane().add(lblNewLabel_1);
		frmAddToSubjects.getContentPane().add(lblNewLabel);
		frmAddToSubjects.getContentPane().add(textField);
		frmAddToSubjects.getContentPane().add(textField_1);
		frmAddToSubjects.getContentPane().add(lblcode);
		frmAddToSubjects.getContentPane().add(btnNewButton);
		frmAddToSubjects.getContentPane().add(btnNewButton_1);
		
		JLabel lblFirstMark = new JLabel("First Mark");
		lblFirstMark.setEnabled(false);
		lblFirstMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblFirstMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstMark.setBounds(20, 273, 109, 25);
		frmAddToSubjects.getContentPane().add(lblFirstMark);
		
		JLabel lblSecondMark = new JLabel("Second Mark");
		lblSecondMark.setEnabled(false);
		lblSecondMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblSecondMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondMark.setBounds(20, 318, 121, 25);
		frmAddToSubjects.getContentPane().add(lblSecondMark);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(141, 273, 228, 25);
		frmAddToSubjects.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(141, 318, 228, 25);
		frmAddToSubjects.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSelectASubject = new JLabel("Select a subject");
		lblSelectASubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSelectASubject.setBounds(18, 31, 179, 38);
		frmAddToSubjects.getContentPane().add(lblSelectASubject);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(204, 37, 198, 27);
		frmAddToSubjects.getContentPane().add(comboBox);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setEnabled(false);
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(20, 363, 109, 22);
		frmAddToSubjects.getContentPane().add(lblStatus);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(141, 363, 228, 25);
		frmAddToSubjects.getContentPane().add(comboBox_1);
	}
}
