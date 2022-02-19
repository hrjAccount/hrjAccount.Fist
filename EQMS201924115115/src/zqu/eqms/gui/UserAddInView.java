package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import zqu.eqms.dao.Depadao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class UserAddInView extends JInternalFrame {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField NametextField;
	private JTextField PassWordtextField;
	private JTextField PhonetextField;
	private JTextField DepaNumtextField;
	private Userdao ud = new Userdao();
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInView frame = new UserAddInView();
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
	public UserAddInView() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("员工添加");
		setIconifiable(true);
		setClosable(true);
		setToolTipText("");
		setBounds(100, 100, 764, 592);
		
		JLabel EmpNameNewLabel = new JLabel("员工姓名：");
		EmpNameNewLabel.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/姓名20.png")));
		EmpNameNewLabel.setBounds(125, 72, 154, 27);
		EmpNameNewLabel.setFont(new Font("宋体", Font.BOLD, 24));
		
		JLabel EmpPassNewLabel = new JLabel("员工密码：");
		EmpPassNewLabel.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/密码20.png")));
		EmpPassNewLabel.setBounds(125, 129, 154, 27);
		EmpPassNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JLabel EmpPhoneNewLabel = new JLabel("员工电话：");
		EmpPhoneNewLabel.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/电话20.png")));
		EmpPhoneNewLabel.setBounds(125, 189, 154, 27);
		EmpPhoneNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(488, 129, 163, 80);
		panel.setBorder(new TitledBorder(null, "\u804C\u4F4D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel EmpNameNewLabel_1_1_1 = new JLabel("所属部门编号：");
		EmpNameNewLabel_1_1_1.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/编号20.png")));
		EmpNameNewLabel_1_1_1.setBounds(74, 251, 205, 27);
		EmpNameNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 24));
		
		NametextField = new JTextField();
		NametextField.setBounds(283, 72, 125, 21);
		NametextField.setColumns(10);
		
		PassWordtextField = new JTextField();
		PassWordtextField.setBounds(283, 129, 125, 27);
		PassWordtextField.setColumns(10);
		
		PhonetextField = new JTextField();
		PhonetextField.setBounds(283, 189, 125, 27);
		PhonetextField.setColumns(10);
		
		DepaNumtextField = new JTextField();
		DepaNumtextField.setBounds(283, 255, 125, 27);
		DepaNumtextField.setColumns(10);
		
		JRadioButton ManNewRadioButton = new JRadioButton("管理员");
		ManNewRadioButton.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(ManNewRadioButton);
		
		JRadioButton NomalNewRadioButton = new JRadioButton("普通员工");
		NomalNewRadioButton.setBackground(Color.LIGHT_GRAY);
		NomalNewRadioButton.setSelected(true);
		buttonGroup.add(NomalNewRadioButton);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ManNewRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
						.addComponent(NomalNewRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(ManNewRadioButton)
					.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
					.addComponent(NomalNewRadioButton)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(null);
		getContentPane().add(EmpNameNewLabel);
		getContentPane().add(NametextField);
		getContentPane().add(EmpPassNewLabel);
		getContentPane().add(PassWordtextField);
		getContentPane().add(panel);
		getContentPane().add(EmpNameNewLabel_1_1_1);
		getContentPane().add(EmpPhoneNewLabel);
		getContentPane().add(DepaNumtextField);
		getContentPane().add(PhonetextField);
		
		JButton ResetNewButton = new JButton("重置");
		ResetNewButton.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/重置18.png")));
		ResetNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		ResetNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resetvalueaction(e);
			}
		});
		ResetNewButton.setBounds(155, 359, 97, 23);
		getContentPane().add(ResetNewButton);
		
		JButton AddNewButton_1 = new JButton("添加");
		AddNewButton_1.setIcon(new ImageIcon(UserAddInView.class.getResource("/zqu/eqms/img/添加18.png")));
		AddNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		AddNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean selection = false;
				if(ManNewRadioButton.isSelected()) {
					selection = true;
				}
				UserAddActionperformed(e,selection);
				
			}
		});
		AddNewButton_1.setBounds(506, 359, 97, 23);
		getContentPane().add(AddNewButton_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(84, 288, 227, 39);
		getContentPane().add(comboBox);
		try {
			this.FillJCB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 添加员工信息
	 * @param e
	 */
	protected void UserAddActionperformed(ActionEvent evt,boolean selection) {
		// TODO Auto-generated method stub
		String Username = NametextField.getText();
		String Userpass = PassWordtextField.getText();
		String Userphone = PhonetextField.getText();
		String Depanum = DepaNumtextField.getText();
		String ManIsNot = "";
		if(StringUtil.IsEmpty(Username)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		if(StringUtil.IsEmpty(Userpass)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
//		if(StringUtil.IsEmpty(Depanum)) {
//			JOptionPane.showMessageDialog(this, "所属部门不能为空");
//			return;
//		}
		if(selection) {
			ManIsNot = "管理员";
		}else {
			ManIsNot = "普通员工";
		}
		User us = new User();
		us.setEmpName(Username);
		us.setEmpPass(Userpass);
		us.setEmpPhone(Userphone);
		us.setDepaNum(Depanum);
		us.setSvONot(ManIsNot);
		Connection conn = null;
		
		try {
			conn = new JobUtil().getConnection();
			int result = ud.addUser(conn, us);
			if(result==1) {
				JOptionPane.showMessageDialog(this, "添加成功");
			}else {
				JOptionPane.showMessageDialog(this, "添加失败1");
			}
		}catch( Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "添加失败2");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	/**
	 * 刷新重置
	 * @param e
	 */
	private void Resetvalueaction(ActionEvent evt) {
		// TODO Auto-generated method stub
		NametextField.setText("");
		PassWordtextField.setText("");
		PhonetextField.setText("");
		DepaNumtextField.setText("");
	}
	
	//JCB
	private void FillJCB() throws SQLException {
		Connection conn = JobUtil.getConnection();
		ResultSet rs = new Depadao().list(conn, new Depa());
		
		
		while(rs.next()) {
			Depa dp1 = new Depa();
			dp1.setDepaNum(rs.getString("DepaNum"));
			dp1.setDepaName(rs.getString("DepaName"));
			dp1.setEmpNum(rs.getString("EmpNum"));
			String s ="编号" + dp1.getDepaNum() + " 名称" + dp1.getDepaName() + " 主管" + dp1.getEmpNum();
			this.comboBox.addItem(s);
		}
	}
}

