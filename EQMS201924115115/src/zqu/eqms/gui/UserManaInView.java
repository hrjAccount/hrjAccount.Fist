package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.dao.Depadao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;

public class UserManaInView extends JInternalFrame {
	private JTextField EmpNumtextField;
	private JTextField EmpNametextField;
	private JTextField EmpPhonetextField;
	private JTextField EmpMantextField;
	private JTextField DepaNumtextField;
	private JButton SearchNewButton;
	private JButton ReSetNewButton;
	private JTable Usertable;
	private JTextField EmpPasstextField2;
	private JTextField EmpNametextField2;
	private JTextField EmpPhonetextField2;
	private JTextField DepaNumtextField2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private User us=null;
	private JobUtil ju=null;
	private JTextField EmpNumtextField2;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManaInView frame = new UserManaInView();
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
	public UserManaInView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("员工管理");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 838, 640);
		getContentPane().setLayout(null);
		
		JLabel EmpNumNewLabel = new JLabel("员工编号：");
		EmpNumNewLabel.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/编号18.png")));
		EmpNumNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		EmpNumNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpNumNewLabel.setBounds(10, 21, 137, 38);
		getContentPane().add(EmpNumNewLabel);
		
		JLabel EmpNameNewLabel = new JLabel("员工名称：");
		EmpNameNewLabel.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/名称18.png")));
		EmpNameNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpNameNewLabel.setBounds(21, 80, 126, 38);
		getContentPane().add(EmpNameNewLabel);
		
		JLabel EmpPhoneNewLabel = new JLabel("员工电话：");
		EmpPhoneNewLabel.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/电话20.png")));
		EmpPhoneNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		EmpPhoneNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpPhoneNewLabel.setBounds(10, 134, 137, 38);
		getContentPane().add(EmpPhoneNewLabel);
		
		JLabel ManOrNotNewLabel_3 = new JLabel("员工职位：");
		ManOrNotNewLabel_3.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/职位18.png")));
		ManOrNotNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		ManOrNotNewLabel_3.setBounds(21, 194, 126, 38);
		getContentPane().add(ManOrNotNewLabel_3);
		
		JLabel DepaNumNewLabel_4 = new JLabel("部门编号：");
		DepaNumNewLabel_4.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		DepaNumNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		DepaNumNewLabel_4.setBounds(21, 252, 126, 38);
		getContentPane().add(DepaNumNewLabel_4);
		
		EmpNumtextField = new JTextField();
		EmpNumtextField.setBounds(147, 27, 139, 32);
		getContentPane().add(EmpNumtextField);
		EmpNumtextField.setColumns(10);
		
		EmpNametextField = new JTextField();
		EmpNametextField.setColumns(10);
		EmpNametextField.setBounds(147, 86, 139, 32);
		getContentPane().add(EmpNametextField);
		
		EmpPhonetextField = new JTextField();
		EmpPhonetextField.setColumns(10);
		EmpPhonetextField.setBounds(147, 145, 139, 32);
		getContentPane().add(EmpPhonetextField);
		
		EmpMantextField = new JTextField();
		EmpMantextField.setColumns(10);
		EmpMantextField.setBounds(147, 200, 139, 32);
		getContentPane().add(EmpMantextField);
		
		DepaNumtextField = new JTextField();
		DepaNumtextField.setColumns(10);
		DepaNumtextField.setBounds(147, 258, 139, 32);
		getContentPane().add(DepaNumtextField);
		
		SearchNewButton = new JButton("查询");
		SearchNewButton.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/检查查询18.png")));
		SearchNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserSearchActionPerform(e);
			}
		});
		SearchNewButton.setBounds(36, 315, 111, 32);
		getContentPane().add(SearchNewButton);
		
		ReSetNewButton = new JButton("重置");
		ReSetNewButton.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/重置18.png")));
		ReSetNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		ReSetNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		ReSetNewButton.setBounds(175, 315, 111, 32);
		getContentPane().add(ReSetNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(296, 26, 507, 264);
		getContentPane().add(scrollPane);
		
		Usertable = new JTable();
		Usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UsertablemousePress(e);
			}
		});
		Usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u7F16\u53F7", "\u7528\u6237\u540D\u79F0", "\u7528\u6237\u5BC6\u7801", "\u7528\u6237\u7535\u8BDD", "\u7528\u6237\u804C\u4F4D", "\u6240\u5C5E\u90E8\u95E8\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Usertable.getColumnModel().getColumn(5).setPreferredWidth(86);
		scrollPane.setViewportView(Usertable);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "\u66F4\u65B0\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(296, 327, 507, 274);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel EmpPassNewLabel2 = new JLabel("员工密码：");
		EmpPassNewLabel2.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/密码18.png")));
		EmpPassNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EmpPassNewLabel2.setBounds(93, 25, 114, 24);
		panel.add(EmpPassNewLabel2);
		
		JLabel EmpNameNewLabel2 = new JLabel("员工姓名：");
		EmpNameNewLabel2.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/姓名18.png")));
		EmpNameNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EmpNameNewLabel2.setBounds(93, 59, 114, 24);
		panel.add(EmpNameNewLabel2);
		
		JLabel EmpPhoneNewLabel2 = new JLabel("员工电话：");
		EmpPhoneNewLabel2.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/电话18.png")));
		EmpPhoneNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EmpPhoneNewLabel2.setBounds(93, 93, 114, 24);
		panel.add(EmpPhoneNewLabel2);
		
		JLabel EmpManNewLabel2 = new JLabel("部门编号：");
		EmpManNewLabel2.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		EmpManNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EmpManNewLabel2.setBounds(93, 122, 114, 24);
		panel.add(EmpManNewLabel2);
		
		EmpPasstextField2 = new JTextField();
		EmpPasstextField2.setBounds(199, 25, 100, 23);
		panel.add(EmpPasstextField2);
		EmpPasstextField2.setColumns(10);
		
		EmpNametextField2 = new JTextField();
		EmpNametextField2.setColumns(10);
		EmpNametextField2.setBounds(199, 59, 100, 23);
		panel.add(EmpNametextField2);
		
		EmpPhonetextField2 = new JTextField();
		EmpPhonetextField2.setColumns(10);
		EmpPhonetextField2.setBounds(199, 93, 100, 23);
		panel.add(EmpPhonetextField2);
		
		DepaNumtextField2 = new JTextField();
		DepaNumtextField2.setColumns(10);
		DepaNumtextField2.setBounds(199, 124, 100, 23);
		panel.add(DepaNumtextField2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("管理员");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(334, 29, 127, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton ManNewRadioButton_1 = new JRadioButton("普通用户");
		ManNewRadioButton_1.setSelected(true);
		buttonGroup.add(ManNewRadioButton_1);
		ManNewRadioButton_1.setBounds(334, 63, 127, 23);
		panel.add(ManNewRadioButton_1);
		
		JButton ChangeNewButton = new JButton("修改");
		ChangeNewButton.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/修改18.png")));
		ChangeNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		ChangeNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean select = rdbtnNewRadioButton.isSelected();
				UserUpdateActionPerform(e,select);
			}
		});
		ChangeNewButton.setBounds(123, 241, 97, 23);
		panel.add(ChangeNewButton);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/删除18.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDeleteActionPerformed(e);
			}
			
		});
		btnNewButton_1.setBounds(312, 241, 97, 23);
		panel.add(btnNewButton_1);
		
		JLabel EmpNumNewLabel2 = new JLabel("员工编号：");
		EmpNumNewLabel2.setIcon(new ImageIcon(UserManaInView.class.getResource("/zqu/eqms/img/编号18.png")));
		EmpNumNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EmpNumNewLabel2.setBounds(93, 152, 114, 24);
		panel.add(EmpNumNewLabel2);
		
		EmpNumtextField2 = new JTextField();
		EmpNumtextField2.setEnabled(false);
		EmpNumtextField2.setColumns(10);
		EmpNumtextField2.setBounds(199, 154, 100, 23);
		panel.add(EmpNumtextField2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(103, 195, 239, 36);
		panel.add(comboBox);
		
		this.filltable(new User());
		try {
			this.FillJCB();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void UserDeleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String EmpNum = EmpNumtextField2.getText();
		if(StringUtil.IsEmpty(EmpNum)) {
			JOptionPane.showMessageDialog(this,"请选择需要删除的记录");
			return;
		}
		
		int Result = JOptionPane.showConfirmDialog(this, "是否需要删除该记录");
		if(Result==0) {
			Connection conn = null;
			try {
				conn = JobUtil.getConnection(); 
				int result = new Userdao().delete(conn, EmpNum);
				if(result==1) {
					JOptionPane.showMessageDialog(this,"删除成功");
					this.reset2ActionPerformed();
					this.filltable(new User() );
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新
	 * @param evt
	 */
	private void UserUpdateActionPerform(ActionEvent evt,boolean select) {
		// TODO Auto-generated method stub
		String EmpName = EmpNametextField2.getText();
		String EmpPass = EmpPasstextField2.getText();
		String EmpPhone = EmpPhonetextField2.getText();
		String DepaNum = DepaNumtextField2.getText();
		String EmpNum = EmpNumtextField2.getText();
		String SvOrNot = "";
		
		if(StringUtil.IsEmpty(EmpNum)) {
			JOptionPane.showMessageDialog(this,"请选择需要修改的记录");
			return;
		}
		if(StringUtil.IsEmpty(EmpName)) {
			JOptionPane.showMessageDialog(this,"员工名称不能为空");
			return;
		}
		if(StringUtil.IsEmpty(EmpPass)) {
			JOptionPane.showMessageDialog(this,"密码不能为空");
			return;
		}
		if(select==true) {
			SvOrNot="管理员";
		}
		else {
			SvOrNot="普通员工";
		}
		us =new User();
		us.setEmpName(EmpName);
		us.setEmpPass(EmpPass);
		us.setEmpPhone(EmpPhone);
		us.setDepaNum(DepaNum);
		us.setSvONot(SvOrNot);
		us.setEmpNum(EmpNum);
		
		
		
		Connection conn = null;
		try {
			conn = JobUtil.getConnection();
			int result = new Userdao().update(conn, us);
			if(result==1) {
				JOptionPane.showMessageDialog(this,"成功");
				this.filltable(new User());
				reset2ActionPerformed();
			}else {
				JOptionPane.showMessageDialog(this,"失败");
				reset2ActionPerformed();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 表格点击
	 * @param e
	 */
	private void UsertablemousePress(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = Usertable.getSelectedRow();
		
		EmpNametextField2.setText((String)Usertable.getValueAt(row, 1));
		EmpPasstextField2.setText((String)Usertable.getValueAt(row, 2));
		EmpPhonetextField2.setText((String)Usertable.getValueAt(row, 3));
		DepaNumtextField2.setText((String)Usertable.getValueAt(row, 5));
		EmpNumtextField2.setText((String)Usertable.getValueAt(row, 0));
	}

	/**
	 * 员工查询
	 * @param e
	 */
	private void UserSearchActionPerform(ActionEvent evt) {
		// TODO Auto-generated method stub
		String EmpNum = EmpNumtextField.getText();
		String EmpName = EmpNametextField.getText();
		String EmpPhone = EmpPhonetextField.getText();
		String EmpMan = EmpMantextField.getText();
		String DepaNum = DepaNumtextField.getText();
		User us = new User();
		us.setEmpNum(EmpNum);
		us.setEmpName(EmpName);
		us.setEmpPhone(EmpPhone);
		us.setSvONot(EmpMan);
		us.setDepaNum(DepaNum);
		this.filltable(us);
		
	}

	/**
	 * 重置
	 * @param e
	 */
	private void ResetActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		EmpNumtextField.setText("");
		EmpNametextField.setText("");
		EmpPhonetextField.setText("");
		EmpMantextField.setText("");
		DepaNumtextField.setText("");
	}
	/**
	 * 重置2
	 */
	private void reset2ActionPerformed() {
		EmpNametextField2.setText("");
		EmpPasstextField2.setText("");
		EmpPhonetextField2.setText("");
		DepaNumtextField2.setText("");
		EmpNumtextField2.setText("");
	}
	
	
	
	/**
	 * 初始化表单
	 */
	private void filltable(User us) {
		DefaultTableModel dtm = (DefaultTableModel)Usertable.getModel();
		dtm.setRowCount(0);//设置0行
		Connection conn = null;
		
		try {
			conn = JobUtil.getConnection();
			ResultSet rs = new Userdao().list(conn, us);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("EmpNum"));
				v.add(rs.getString("EmpName"));
				v.add(rs.getString("EmpPass"));
				v.add(rs.getString("EmpPhone"));
				v.add(rs.getString("SvOrNot"));
				v.add(rs.getString("DepaNum"));
				dtm.addRow(v);
				
			}
			
		}catch (Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库初始化失败");
			}
		}
		
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

