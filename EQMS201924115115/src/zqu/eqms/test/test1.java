package zqu.eqms.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.dao.Depadao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;

import javax.swing.JComboBox;

public class test1 extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test1 frame = new test1();
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
	public test1() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(220, 120, 226, 35);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(218, 204, 214, 35);
		contentPane.add(comboBox_1);
		this.FillJCB();
		this.FillJCB2();
	}
	
	private void FillJCB2() throws SQLException {
		Connection conn = JobUtil.getConnection();
		ResultSet rs = new Userdao().list(conn, new User());
		
		while(rs.next()) {
			User us1 = new User();
			us1.setEmpNum(rs.getString("EmpNum"));
			us1.setEmpName(rs.getString("EmpName"));
			us1.setDepaNum(rs.getString("DepaNum"));
			String s = "编号" + us1.getEmpNum() + " 名称" + us1.getEmpName() + " 部门" + us1.getDepaNum();
			this.comboBox_1.addItem(s);
		}
	}

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
