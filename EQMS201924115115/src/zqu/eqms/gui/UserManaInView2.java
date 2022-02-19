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

import zqu.eqms.dao.Userdao;
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

public class UserManaInView2 extends JInternalFrame {
	private JTextField EmpNumtextField;
	private JTextField EmpNametextField;
	private JTextField EmpPhonetextField;
	private JTextField EmpMantextField;
	private JTextField DepaNumtextField;
	private JButton SearchNewButton;
	private JButton ReSetNewButton;
	private JTable Usertable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private User us=null;
	private JobUtil ju=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManaInView2 frame = new UserManaInView2();
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
	public UserManaInView2() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("员工管理");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 834, 444);
		getContentPane().setLayout(null);
		
		JLabel EmpNumNewLabel = new JLabel("员工编号：");
		EmpNumNewLabel.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/编号18.png")));
		EmpNumNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		EmpNumNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpNumNewLabel.setBounds(21, 21, 126, 38);
		getContentPane().add(EmpNumNewLabel);
		
		JLabel EmpNameNewLabel = new JLabel("员工名称：");
		EmpNameNewLabel.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/名称18.png")));
		EmpNameNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpNameNewLabel.setBounds(21, 80, 126, 38);
		getContentPane().add(EmpNameNewLabel);
		
		JLabel EmpPhoneNewLabel = new JLabel("员工电话：");
		EmpPhoneNewLabel.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/电话18.png")));
		EmpPhoneNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		EmpPhoneNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EmpPhoneNewLabel.setBounds(21, 134, 126, 38);
		getContentPane().add(EmpPhoneNewLabel);
		
		JLabel ManOrNotNewLabel_3 = new JLabel("员工职位：");
		ManOrNotNewLabel_3.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/职位18.png")));
		ManOrNotNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		ManOrNotNewLabel_3.setBounds(21, 194, 126, 38);
		getContentPane().add(ManOrNotNewLabel_3);
		
		JLabel DepaNumNewLabel_4 = new JLabel("部门编号：");
		DepaNumNewLabel_4.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/编号18 2.png")));
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
		SearchNewButton.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/检查查询18.png")));
		SearchNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserSearchActionPerform(e);
			}
		});
		SearchNewButton.setBounds(36, 315, 111, 32);
		getContentPane().add(SearchNewButton);
		
		ReSetNewButton = new JButton("重置");
		ReSetNewButton.setIcon(new ImageIcon(UserManaInView2.class.getResource("/zqu/eqms/img/重置18.png")));
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
		
//		Usertable.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"\u7528\u6237\u7F16\u53F7", "\u7528\u6237\u540D\u79F0", "\u7528\u6237\u5BC6\u7801", "\u7528\u6237\u7535\u8BDD", "\u7528\u6237\u804C\u4F4D", "\u6240\u5C5E\u90E8\u95E8\u7F16\u53F7"
//			}
//		) {
//			boolean[] columnEditables = new boolean[] {
//				false, false, true, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		Usertable.getColumnModel().getColumn(5).setPreferredWidth(86);
//		scrollPane.setViewportView(Usertable);
		
		Usertable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7528\u6237\u7F16\u53F7", "\u7528\u6237\u540D\u79F0", "\u7528\u6237\u7535\u8BDD", "\u7528\u6237\u804C\u4F4D", "\u6240\u5C5E\u90E8\u95E8\u7F16\u53F7"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			scrollPane.setViewportView(Usertable);
		
		this.filltable(new User());
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
//				v.add(rs.getString("EmpPass"));
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
	
}
