package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import zqu.eqms.domain.User;

public class UserMessage extends JInternalFrame {
	private JTextField UserNumtextField;
	private JTextField UserNametextField_1;
	private JTextField PositiontextField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMessage frame = new UserMessage(new User());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMessage(User us) {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel UserNumNewLabel = new JLabel("用户编号：");
		UserNumNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		UserNumNewLabel.setBounds(106, 83, 114, 26);
		getContentPane().add(UserNumNewLabel);
		
		JLabel UserNameNewLabel_1 = new JLabel("用户名称：");
		UserNameNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		UserNameNewLabel_1.setBounds(106, 160, 114, 26);
		getContentPane().add(UserNameNewLabel_1);
		
		UserNumtextField = new JTextField();
		UserNumtextField.setEditable(false);
		UserNumtextField.setBounds(206, 83, 140, 26);
		getContentPane().add(UserNumtextField);
		UserNumtextField.setColumns(10);
		
		UserNametextField_1 = new JTextField();
		UserNametextField_1.setEditable(false);
		UserNametextField_1.setColumns(10);
		UserNametextField_1.setBounds(206, 160, 140, 26);
		getContentPane().add(UserNametextField_1);
		
		JLabel UserPositionNewLabel_1_1 = new JLabel("用户职位：");
		UserPositionNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		UserPositionNewLabel_1_1.setBounds(106, 238, 114, 26);
		getContentPane().add(UserPositionNewLabel_1_1);
		
		PositiontextField_2 = new JTextField();
		PositiontextField_2.setEditable(false);
		PositiontextField_2.setColumns(10);
		PositiontextField_2.setBounds(206, 238, 140, 26);
		getContentPane().add(PositiontextField_2);
		setTitle("登录用户信息");
		setBounds(100, 100, 526, 396);
		
		UserNumtextField.setText(us.getEmpNum());
		UserNametextField_1.setText(us.getEmpName());
		PositiontextField_2.setText(us.getSvONot());
	}

}
