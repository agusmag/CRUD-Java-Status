package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StatusMenu {

	private JFrame frmStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusMenu window = new StatusMenu();
					window.frmStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatusMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatus = new JFrame();
		frmStatus.setTitle("Status");
		frmStatus.setBounds(100, 100, 794, 305);
		frmStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatus.setLocationRelativeTo(null);
		
		JButton btnCarrer = new JButton("Carrer");
		btnCarrer.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btn = new JButton("Show Status");
		btn.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		JButton btnSubjets = new JButton("Subjects");
		btnSubjets.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
		lblNewLabel.setBackground(new Color(102, 205, 170));
		
		JLabel lblAvg = new JLabel("Average");
		lblAvg.setEnabled(false);
		lblAvg.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setBackground(new Color(102, 205, 170));
		
		JLabel lblSubjetsIn = new JLabel("Subjects IN");
		lblSubjetsIn.setEnabled(false);
		lblSubjetsIn.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSubjetsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjetsIn.setBackground(new Color(102, 205, 170));
		
		JLabel lblYearsIn = new JLabel("Years IN");
		lblYearsIn.setEnabled(false);
		lblYearsIn.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblYearsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearsIn.setBackground(new Color(102, 205, 170));
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setBackground(new Color(102, 205, 170));
		
		JLabel label_1 = new JLabel("");
		label_1.setEnabled(false);
		label_1.setBackground(new Color(102, 205, 170));
		
		JLabel label_2 = new JLabel("");
		label_2.setEnabled(false);
		label_2.setBackground(new Color(102, 205, 170));
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frmStatus.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSubjets, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCarrer, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAvg, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSubjetsIn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYearsIn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCarrer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(btnSubjets, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblYearsIn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGap(33))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAvg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSubjetsIn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
							.addGap(124)
							.addComponent(btnNewButton)))
					.addGap(21))
		);
		frmStatus.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmStatus() {
		return frmStatus;
	}

	public void setFrmStatus(JFrame frmStatus) {
		this.frmStatus = frmStatus;
	}
	
}
