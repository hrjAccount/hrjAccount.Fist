package zqu.eqms.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import zqu.eqms.dao.Depadao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;




public class DepaManaInView2 extends JInternalFrame {
	private JTable Depatable;
	
	private JobUtil ju = new JobUtil();
	private Depadao Dd = new Depadao();
	private JTextField SearchtextField;
	private JTextField DepaNUmtextField;
	private JTextField EmpNUmtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepaManaInView2 frame = new DepaManaInView2();
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
	public DepaManaInView2() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setTitle("部门管理");
		setBounds(100, 100, 768, 485);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 192, 394, 202);
		
		JLabel DepaNameNewLabel = new JLabel("部门名称：");
		DepaNameNewLabel.setBounds(150, 38, 106, 20);
		DepaNameNewLabel.setIcon(new ImageIcon(DepaManaInView2.class.getResource("/zqu/eqms/img/名称18.png")));
		DepaNameNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		SearchtextField = new JTextField();
		SearchtextField.setBounds(252, 39, 126, 21);
		SearchtextField.setColumns(10);
		
		JButton SearchNewButton = new JButton("查询");
		SearchNewButton.setIcon(new ImageIcon(DepaManaInView2.class.getResource("/zqu/eqms/img/检查查询18.png")));
		SearchNewButton.setBounds(419, 78, 97, 31);
		SearchNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepaSearchActionPerformed(e);
				
			}
		});
		
		JLabel DepaNumNewLabel = new JLabel("部门编号：");
		DepaNumNewLabel.setBounds(150, 78, 106, 20);
		DepaNumNewLabel.setIcon(new ImageIcon(DepaManaInView2.class.getResource("/zqu/eqms/img/编号18.png")));
		DepaNumNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		JLabel DepaManNewLabel = new JLabel("部门主管：");
		DepaManNewLabel.setIcon(new ImageIcon(DepaManaInView2.class.getResource("/zqu/eqms/img/编号18 2.png")));
		DepaManNewLabel.setBounds(150, 128, 106, 20);
		DepaManNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		DepaNUmtextField = new JTextField();
		DepaNUmtextField.setBounds(252, 79, 126, 21);
		DepaNUmtextField.setColumns(10);
		
		EmpNUmtextField = new JTextField();
		EmpNUmtextField.setBounds(252, 127, 126, 21);
		EmpNUmtextField.setColumns(10);
		
		Depatable =  new JTable();
		
		Depatable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		Depatable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u90E8\u95E8\u7F16\u53F7", "\u90E8\u95E8\u540D\u79F0", "\u90E8\u95E8\u4E3B\u7BA1\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Depatable.getColumnModel().getColumn(2).setPreferredWidth(85);
		getContentPane().setLayout(null);
		scrollPane.setViewportView(Depatable);
		getContentPane().add(scrollPane);
		getContentPane().add(DepaManNewLabel);
		getContentPane().add(EmpNUmtextField);
		getContentPane().add(DepaNumNewLabel);
		getContentPane().add(DepaNUmtextField);
		getContentPane().add(SearchNewButton);
		getContentPane().add(DepaNameNewLabel);
		getContentPane().add(SearchtextField);
		
		this.fillTable(new Depa());

	}
	
	

	/**
	 * 部门搜索事件
	 * @param evt
	 */
	private void DepaSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String Searchtext = this.SearchtextField.getText();
		String Depanum = this.DepaNUmtextField.getText();
		String Empnum = this.EmpNUmtextField.getText();
		Depa dp = new Depa();
		dp.setDepaName(Searchtext);
		dp.setDepaNum(Depanum);
		dp.setEmpNum(Empnum);
		this.fillTable(dp);
		
	}

	/**
	 * 初始化表格
	 * @param dp
	 */
	private void fillTable(Depa dp) {
		
		DefaultTableModel dtm = (DefaultTableModel) Depatable.getModel();
		dtm.setRowCount(0);//设置0行
		Connection conn = null;
		try {
			conn = JobUtil.getConnection();
			ResultSet rs = new Depadao().list(conn, dp);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("DepaNum"));
				v.add(rs.getString("DepaName"));
				v.add(rs.getString("EmpNum"));
				dtm.addRow(v);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("数据库初始化失败");
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
