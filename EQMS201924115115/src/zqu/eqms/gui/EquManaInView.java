package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.dao.Equidao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.Equi;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EquManaInView extends JInternalFrame {
	private JTextField EquNumtextField;
	private JTextField EquNametextField_1;
	private JTextField BuyTimeField_2;
	private JTextField EquLoctextField_3;
	private JTextField EquMNametextField_4;
	private JTextField EquMDepatextField_5;
	private JTable Usertable;
	private JTextField EquNumtextField2;
	private JTextField EquNametextField2;
	private JTextField BuyTimetextField2;
	private JTextField EmpLoctextField2;
	private JTextField EmpNumtextField;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquManaInView frame = new EquManaInView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EquManaInView() throws SQLException {
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setTitle("设备管理");
		setBounds(100, 100, 900, 634);
		getContentPane().setLayout(null);
		
		JLabel EquNumNewLabel = new JLabel("设备编号：");
		EquNumNewLabel.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		EquNumNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EquNumNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		EquNumNewLabel.setBounds(69, 41, 121, 27);
		getContentPane().add(EquNumNewLabel);
		
		JLabel EquNameNewLabel_1 = new JLabel("设备名称：");
		EquNameNewLabel_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/名称18.png")));
		EquNameNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquNameNewLabel_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquNameNewLabel_1.setBounds(69, 78, 121, 27);
		getContentPane().add(EquNameNewLabel_1);
		
		JLabel BuyTimeNewLabel_2 = new JLabel("购入日期：");
		BuyTimeNewLabel_2.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/时间18.png")));
		BuyTimeNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		BuyTimeNewLabel_2.setFont(new Font("宋体", Font.BOLD, 17));
		BuyTimeNewLabel_2.setBounds(69, 115, 121, 27);
		getContentPane().add(BuyTimeNewLabel_2);
		
		JLabel EquLocNewLabel_2_1 = new JLabel("存放位置：");
		EquLocNewLabel_2_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/所在地18.png")));
		EquLocNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquLocNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquLocNewLabel_2_1.setBounds(69, 152, 121, 27);
		getContentPane().add(EquLocNewLabel_2_1);
		
		JLabel EquMNameNewLabel_2_1_1 = new JLabel("设备负责人名称：");
		EquMNameNewLabel_2_1_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/姓名18.png")));
		EquMNameNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquMNameNewLabel_2_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquMNameNewLabel_2_1_1.setBounds(20, 189, 163, 27);
		getContentPane().add(EquMNameNewLabel_2_1_1);
		
		JLabel EquMDepaNewLabel_2_1_2 = new JLabel("负责人部门：");
		EquMDepaNewLabel_2_1_2.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/部门18.png")));
		EquMDepaNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		EquMDepaNewLabel_2_1_2.setFont(new Font("宋体", Font.BOLD, 17));
		EquMDepaNewLabel_2_1_2.setBounds(52, 226, 148, 27);
		getContentPane().add(EquMDepaNewLabel_2_1_2);
		
		EquNumtextField = new JTextField();
		EquNumtextField.setBounds(180, 41, 120, 27);
		getContentPane().add(EquNumtextField);
		EquNumtextField.setColumns(10);
		
		EquNametextField_1 = new JTextField();
		EquNametextField_1.setColumns(10);
		EquNametextField_1.setBounds(180, 78, 120, 27);
		getContentPane().add(EquNametextField_1);
		
		BuyTimeField_2 = new JTextField();
		BuyTimeField_2.setColumns(10);
		BuyTimeField_2.setBounds(180, 115, 120, 27);
		getContentPane().add(BuyTimeField_2);
		
		EquLoctextField_3 = new JTextField();
		EquLoctextField_3.setColumns(10);
		EquLoctextField_3.setBounds(180, 152, 120, 27);
		getContentPane().add(EquLoctextField_3);
		
		EquMNametextField_4 = new JTextField();
		EquMNametextField_4.setColumns(10);
		EquMNametextField_4.setBounds(180, 189, 120, 27);
		getContentPane().add(EquMNametextField_4);
		
		EquMDepatextField_5 = new JTextField();
		EquMDepatextField_5.setColumns(10);
		EquMDepatextField_5.setBounds(180, 226, 120, 27);
		getContentPane().add(EquMDepatextField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 41, 568, 217);
		getContentPane().add(scrollPane);
		
		Usertable = new JTable();
		Usertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				UserTableMousePressed(e);
			}
		});
		Usertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BBE\u5907\u7F16\u53F7", "\u8BBE\u5907\u540D\u79F0", "\u8D2D\u5165\u65E5\u671F", "\u5B58\u653E\u4F4D\u7F6E", "\u8BBE\u5907\u8D1F\u8D23\u4EBA", "\u8D1F\u8D23\u4EBA\u90E8\u95E8", "\u8D1F\u8D23\u4EBA\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(Usertable);
		
		JButton SearchNewButton = new JButton("查询");
		SearchNewButton.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/检查查询18.png")));
		SearchNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EquSerarchActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		SearchNewButton.setBounds(42, 280, 97, 23);
		getContentPane().add(SearchNewButton);
		
		JButton ResetbtnNewButton_1 = new JButton("重置");
		ResetbtnNewButton_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/重置18.png")));
		ResetbtnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		ResetbtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset1(e);
			}
		});
		ResetbtnNewButton_1.setBounds(203, 280, 97, 23);
		getContentPane().add(ResetbtnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "\u66F4\u6539\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 325, 868, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel EquNumNewLabel2 = new JLabel("设备编号：");
		EquNumNewLabel2.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		EquNumNewLabel2.setFont(new Font("宋体", Font.BOLD, 18));
		EquNumNewLabel2.setBounds(37, 24, 118, 26);
		panel.add(EquNumNewLabel2);
		
		JLabel EquNameNewLabel2_1 = new JLabel("设备名称：");
		EquNameNewLabel2_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/名称18.png")));
		EquNameNewLabel2_1.setFont(new Font("宋体", Font.BOLD, 18));
		EquNameNewLabel2_1.setBounds(37, 60, 118, 26);
		panel.add(EquNameNewLabel2_1);
		
		JLabel BuyTimeNewLabel2_1_1 = new JLabel("购入日期：");
		BuyTimeNewLabel2_1_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/时间18.png")));
		BuyTimeNewLabel2_1_1.setFont(new Font("宋体", Font.BOLD, 18));
		BuyTimeNewLabel2_1_1.setBounds(37, 96, 118, 26);
		panel.add(BuyTimeNewLabel2_1_1);
		
		JLabel EquNumNewLabel2_1_2 = new JLabel("存放位置：");
		EquNumNewLabel2_1_2.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/所在地18.png")));
		EquNumNewLabel2_1_2.setFont(new Font("宋体", Font.BOLD, 18));
		EquNumNewLabel2_1_2.setBounds(37, 132, 118, 26);
		panel.add(EquNumNewLabel2_1_2);
		
		EquNumtextField2 = new JTextField();
		EquNumtextField2.setEnabled(false);
		EquNumtextField2.setBounds(142, 24, 118, 24);
		panel.add(EquNumtextField2);
		EquNumtextField2.setColumns(10);
		
		EquNametextField2 = new JTextField();
		EquNametextField2.setColumns(10);
		EquNametextField2.setBounds(142, 60, 118, 24);
		panel.add(EquNametextField2);
		
		BuyTimetextField2 = new JTextField();
		BuyTimetextField2.setColumns(10);
		BuyTimetextField2.setBounds(142, 96, 118, 24);
		panel.add(BuyTimetextField2);
		
		EmpLoctextField2 = new JTextField();
		EmpLoctextField2.setColumns(10);
		EmpLoctextField2.setBounds(142, 130, 118, 24);
		panel.add(EmpLoctextField2);
		
		JLabel EquNumNewLabel2_1_2_1 = new JLabel("负责人编号：");
		EquNumNewLabel2_1_2_1.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/编号18.png")));
		EquNumNewLabel2_1_2_1.setFont(new Font("宋体", Font.BOLD, 18));
		EquNumNewLabel2_1_2_1.setBounds(23, 168, 132, 26);
		panel.add(EquNumNewLabel2_1_2_1);
		
		EmpNumtextField = new JTextField();
		EmpNumtextField.setColumns(10);
		EmpNumtextField.setBounds(142, 168, 118, 24);
		panel.add(EmpNumtextField);
		
		JButton DeleteNewButton = new JButton("删除");
		DeleteNewButton.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/删除18.png")));
		DeleteNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		DeleteNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
				
			}
		});
		DeleteNewButton.setBounds(284, 33, 97, 23);
		panel.add(DeleteNewButton);
		
		JButton UpdateNewButton = new JButton("更新");
		UpdateNewButton.setIcon(new ImageIcon(EquManaInView.class.getResource("/zqu/eqms/img/修改18.png")));
		UpdateNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		UpdateNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EquUpdateActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		UpdateNewButton.setBounds(284, 141, 97, 23);
		panel.add(UpdateNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(37, 201, 223, 39);
		panel.add(comboBox);
		
		this.FillTable(new Equi(),new Depa(),new User());
		this.FillJCB2();
	}
	
	
	private void deleteActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String EquNum = EquNumtextField2.getText();
		if(StringUtil.IsEmpty(EquNum)) {
			JOptionPane.showMessageDialog(this,"请选择需要删除的记录");
			return;
		}
		int Result = JOptionPane.showConfirmDialog(this, "是否需要删除该记录");
		if(Result==0) {
			Connection conn = null;
			try {
				conn = JobUtil.getConnection(); 
				int result = new Equidao().delete(conn, EquNum);
				if(result==1) {
					JOptionPane.showMessageDialog(this,"删除成功");
					this.Reset2();
					this.FillTable(new Equi(),new Depa(),new User());
				}else {
					JOptionPane.showMessageDialog(this,"删除失败");
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

	private void EquUpdateActionPerformed(ActionEvent evt) throws SQLException {
		// TODO Auto-generated method stub
		String EquNum = EquNumtextField2.getText();
		String EquName = EquNametextField2.getText();
		String BuyTime = BuyTimetextField2.getText();
		String EmpLoc = EmpLoctextField2.getText();
		String EmpNum = EmpNumtextField.getText();
		if(StringUtil.IsEmpty(EquNum)) {
			JOptionPane.showMessageDialog(this,"请选择需要修改的记录");
			return;
		}
		if(StringUtil.IsEmpty(EquName)) {
			JOptionPane.showMessageDialog(this,"设备名称不能为空");
			return;
		}
		Equi eq = new Equi();
		eq.setEquNum(EquNum);
		System.out.println(eq.getEquNum());
		eq.setEquName(EquName);
		eq.setBuyTime(BuyTime);
		eq.setEquLoc(EmpLoc);
		eq.setEmpNum(EmpNum);
		Connection conn = null;
		try {
			conn = JobUtil.getConnection();
			int result = new Equidao().update(conn, eq);
			if(result==1) {
				JOptionPane.showMessageDialog(this,"成功");
				Reset2();
				this.FillTable(new Equi(),new Depa(),new User());
			}else {
				JOptionPane.showMessageDialog(this,"失败");
				
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
		this.FillTable(new Equi(),new Depa(),new User());
	}

	/**
	 * 表格行点击事件
	 * @param e
	 */
	private void UserTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = Usertable.getSelectedRow();
		EquNumtextField2.setText((String)Usertable.getValueAt(row, 0));
		EquNametextField2.setText((String)Usertable.getValueAt(row, 1));
		BuyTimetextField2.setText((String)Usertable.getValueAt(row, 2));
		EmpLoctextField2.setText((String)Usertable.getValueAt(row, 3));
		EmpNumtextField.setText((String)Usertable.getValueAt(row, 6));
	}

	/**
	 * 设备搜索
	 * @param evy
	 * @throws SQLException 
	 */
	private void EquSerarchActionPerformed(ActionEvent evt) throws SQLException {
		// TODO Auto-generated method stub
		String EquNum = EquNumtextField.getText();
		String EquName = EquNametextField_1.getText();
		String BuyTime = BuyTimeField_2.getText();
		String EquLoc = EquLoctextField_3.getText();
		String EquMname = EquMNametextField_4.getText();
		String EquMDepa = EquMDepatextField_5.getText();
		Depa dp = new Depa();
		Equi eq = new Equi();
		User us = new User();
	
		eq.setEquNum(EquNum);
		eq.setEquName(EquName);
		eq.setBuyTime(BuyTime);
		eq.setEquLoc(EquLoc);
		us.setEmpName(EquMname);
		dp.setDepaName(EquMDepa);
		this.FillTable(eq, dp, us);
	}

	/**
	 * 重置1
	 * @param e
	 */
	
	private void Reset1(ActionEvent e) {
		// TODO Auto-generated method stub
		this.EquNumtextField.setText("");
		this.EquNametextField_1.setText("");
		this.BuyTimeField_2.setText("");
		this.EquLoctextField_3.setText("");
		this.EquMNametextField_4.setText("");
		this.EquMDepatextField_5.setText("");
	}
	
	/**
	 * 重置2
	 */
	private void Reset2() {
		this.EquNumtextField2.setText("");
		this.EquNametextField2.setText("");
		this.BuyTimetextField2.setText("");
		this.EmpLoctextField2.setText("");
		this.EmpNumtextField.setText("");
	}
	
	

	/**
	 * 初始化表格
	 * @throws SQLException 
	 */
	private void FillTable(Equi eq,Depa dp,User us) throws SQLException {
		DefaultTableModel dtm = (DefaultTableModel)Usertable.getModel();
		dtm.setRowCount(0);//设置0行
		Connection conn = null;
		try {
			conn = JobUtil.getConnection();
			ResultSet rs = new Equidao().list(conn,eq,dp,us);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("EquNum"));
//				System.out.println(rs.getString("EquNum"));
				v.add(rs.getString("EquName"));
//				System.out.println(rs.getString("EquName"));
				v.add(rs.getString("BuyTime"));
//				System.out.println(rs.getString("BuyTime"));
				v.add(rs.getString("EquLoc"));
//				System.out.println(rs.getString("EquLoc"));
				v.add(rs.getString("EmpName"));
//				System.out.println(rs.getString("EmpName"));
				v.add(rs.getString("DepaName"));
//				System.out.println(rs.getString("DepaName"));
				v.add(rs.getString("EmpNum"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
	
	
	//JCB
	private void FillJCB2() throws SQLException {
		Connection conn = JobUtil.getConnection();
		ResultSet rs = new Userdao().list(conn, new User());
		
		while(rs.next()) {
			User us1 = new User();
			us1.setEmpNum(rs.getString("EmpNum"));
			us1.setEmpName(rs.getString("EmpName"));
			us1.setDepaNum(rs.getString("DepaNum"));
			String s = "编号" + us1.getEmpNum() + " 名称" + us1.getEmpName() + " 部门" + us1.getDepaNum();
			this.comboBox.addItem(s);
		}
	}

}
