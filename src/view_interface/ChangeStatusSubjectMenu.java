package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ChangeStatusSubjectMenu {

	private JFrame frmChangeStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeStatusSubjectMenu window = new ChangeStatusSubjectMenu();
					window.frmChangeStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeStatusSubjectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChangeStatus = new JFrame();
		frmChangeStatus.setTitle("Change Status");
		frmChangeStatus.setBounds(100, 100, 450, 230);
		frmChangeStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Current Subjetct");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JLabel lblAsd = new JLabel("");
		lblAsd.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pass");
		rdbtnNewRadioButton.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Final");
		rdbtnNewRadioButton_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Try Again");
		rdbtnNewRadioButton_2.setFont(new Font("Consolas", Font.PLAIN, 16));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frmChangeStatus.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_2))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAsd, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(20, Short.MAX_VALUE))
						.addComponent(rdbtnNewRadioButton_1)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAsd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(26)
									.addComponent(rdbtnNewRadioButton_2)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(rdbtnNewRadioButton)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		frmChangeStatus.getContentPane().setLayout(groupLayout);
	}
}
