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

public class EquManaInView2 extends JInternalFrame {
	private JTextField EquNumtextField;
	private JTextField EquNametextField_1;
	private JTextField BuyTimeField_2;
	private JTextField EquLoctextField_3;
	private JTextField EquMNametextField_4;
	private JTextField EquMDepatextField_5;
	private JTable Usertable;

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
	public EquManaInView2() throws SQLException {
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setTitle("设备管理");
		setBounds(100, 100, 901, 394);
		getContentPane().setLayout(null);
		
		JLabel EquNumNewLabel = new JLabel("设备编号：");
		EquNumNewLabel.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/编号18 2.png")));
		EquNumNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EquNumNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		EquNumNewLabel.setBounds(84, 41, 106, 27);
		getContentPane().add(EquNumNewLabel);
		
		JLabel EquNameNewLabel_1 = new JLabel("设备名称：");
		EquNameNewLabel_1.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/名称18.png")));
		EquNameNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquNameNewLabel_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquNameNewLabel_1.setBounds(77, 78, 113, 27);
		getContentPane().add(EquNameNewLabel_1);
		
		JLabel BuyTimeNewLabel_2 = new JLabel("购入日期：");
		BuyTimeNewLabel_2.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/时间18.png")));
		BuyTimeNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		BuyTimeNewLabel_2.setFont(new Font("宋体", Font.BOLD, 17));
		BuyTimeNewLabel_2.setBounds(77, 115, 113, 27);
		getContentPane().add(BuyTimeNewLabel_2);
		
		JLabel EquLocNewLabel_2_1 = new JLabel("存放位置：");
		EquLocNewLabel_2_1.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/所在地18.png")));
		EquLocNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquLocNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquLocNewLabel_2_1.setBounds(77, 152, 113, 27);
		getContentPane().add(EquLocNewLabel_2_1);
		
		JLabel EquMNameNewLabel_2_1_1 = new JLabel("设备负责人名称：");
		EquMNameNewLabel_2_1_1.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/姓名18.png")));
		EquMNameNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		EquMNameNewLabel_2_1_1.setFont(new Font("宋体", Font.BOLD, 17));
		EquMNameNewLabel_2_1_1.setBounds(27, 189, 156, 27);
		getContentPane().add(EquMNameNewLabel_2_1_1);
		
		JLabel EquMDepaNewLabel_2_1_2 = new JLabel("负责人部门：");
		EquMDepaNewLabel_2_1_2.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/部门18.png")));
		EquMDepaNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		EquMDepaNewLabel_2_1_2.setFont(new Font("宋体", Font.BOLD, 17));
		EquMDepaNewLabel_2_1_2.setBounds(57, 226, 131, 27);
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
		SearchNewButton.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/检查查询18.png")));
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
		ResetbtnNewButton_1.setIcon(new ImageIcon(EquManaInView2.class.getResource("/zqu/eqms/img/重置18.png")));
		ResetbtnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		ResetbtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset1(e);
			}
		});
		ResetbtnNewButton_1.setBounds(203, 280, 97, 23);
		getContentPane().add(ResetbtnNewButton_1);
		
		this.FillTable(new Equi(),new Depa(),new User());
		
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
}
