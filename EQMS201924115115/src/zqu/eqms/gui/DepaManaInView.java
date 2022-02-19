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
import zqu.eqms.dao.Userdao;
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
import javax.swing.JComboBox;




public class DepaManaInView extends JInternalFrame {
	private JTable Depatable;
	
	private JobUtil ju = new JobUtil();
	private Depadao Dd = new Depadao();
	private JTextField SearchtextField;
	private JTextField DepaNumtextField;
	private JTextField DepaNametextField;
	private JTextField EmpNumtextField;
	private JTextField DepaNUmtextField;
	private JTextField EmpNUmtextField;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepaManaInView frame = new DepaManaInView();
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
	public DepaManaInView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setFont(new Font("宋体", Font.BOLD, 12));
		setIconifiable(true);
		setClosable(true);
		setTitle("部门管理");
		setBounds(100, 100, 766, 688);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 169, 394, 202);
		
		JLabel DepaNameNewLabel = new JLabel("部门名称：");
		DepaNameNewLabel.setBounds(150, 38, 106, 20);
		DepaNameNewLabel.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/名称18.png")));
		DepaNameNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		SearchtextField = new JTextField();
		SearchtextField.setBounds(280, 39, 126, 21);
		SearchtextField.setColumns(10);
		
		JButton SearchNewButton = new JButton("查询");
		SearchNewButton.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/检查查询18.png")));
		SearchNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		SearchNewButton.setBounds(440, 78, 97, 23);
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepaSearchActionPerformed(e);
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(150, 415, 402, 202);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u66F4\u6539\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel DepaNumNewLabel = new JLabel("部门编号：");
		DepaNumNewLabel.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/编号18.png")));
		DepaNumNewLabel.setBounds(150, 78, 113, 20);
		DepaNumNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		JLabel DepaManNewLabel = new JLabel("部门主管：");
		DepaManNewLabel.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		DepaManNewLabel.setBounds(150, 120, 126, 20);
		DepaManNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		DepaNUmtextField = new JTextField();
		DepaNUmtextField.setBounds(280, 79, 126, 21);
		DepaNUmtextField.setColumns(10);
		
		EmpNUmtextField = new JTextField();
		EmpNUmtextField.setBounds(280, 119, 126, 21);
		EmpNUmtextField.setColumns(10);
		
		JLabel DepaNameNewLabel_1 = new JLabel("部门名称：");
		DepaNameNewLabel_1.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/名称18.png")));
		DepaNameNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		DepaNameNewLabel_1.setBounds(34, 56, 124, 21);
		
		JLabel DepaManaNewLabel_1 = new JLabel("主管编号：");
		DepaManaNewLabel_1.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		DepaManaNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		DepaManaNewLabel_1.setBounds(34, 87, 153, 21);
		
		JLabel DepaNumNewLabel_2 = new JLabel("部门编号：");
		DepaNumNewLabel_2.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/编号18.png")));
		DepaNumNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		DepaNumNewLabel_2.setBounds(34, 25, 124, 21);
		
		DepaNumtextField = new JTextField();
		DepaNumtextField.setBounds(166, 28, 112, 21);
		DepaNumtextField.setEditable(false);
		DepaNumtextField.setColumns(10);
		
		DepaNametextField = new JTextField();
		DepaNametextField.setBounds(166, 59, 112, 21);
		DepaNametextField.setColumns(10);
		
		EmpNumtextField = new JTextField();
		EmpNumtextField.setBounds(166, 90, 112, 21);
		EmpNumtextField.setColumns(10);
		
		JButton ChangeNewButton = new JButton("修改");
		ChangeNewButton.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/修改18.png")));
		ChangeNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		ChangeNewButton.setBounds(34, 163, 97, 23);
		ChangeNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepaUpdateActionPerform(e);
				
				
			}
		});
		
		JButton delectNewButton = new JButton("删除");
		delectNewButton.setIcon(new ImageIcon(DepaManaInView.class.getResource("/zqu/eqms/img/删除18.png")));
		delectNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		delectNewButton.setBounds(255, 163, 97, 23);
		delectNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DepaDelectActionPerformed(e);
					fillTable(new Depa());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.setLayout(null);
		panel.add(DepaManaNewLabel_1);
		panel.add(EmpNumtextField);
		panel.add(DepaNumNewLabel_2);
		panel.add(DepaNumtextField);
		panel.add(DepaNameNewLabel_1);
		panel.add(DepaNametextField);
		panel.add(ChangeNewButton);
		panel.add(delectNewButton);
		
		Depatable =  new JTable();
		Depatable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DepaTableMousePresed(e);
				
			}
		});
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
		scrollPane.setViewportView(Depatable);
		getContentPane().setLayout(null);
		getContentPane().add(DepaManNewLabel);
		getContentPane().add(EmpNUmtextField);
		getContentPane().add(DepaNumNewLabel);
		getContentPane().add(DepaNUmtextField);
		getContentPane().add(SearchNewButton);
		getContentPane().add(scrollPane);
		getContentPane().add(panel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(34, 118, 244, 35);
		panel.add(comboBox);
		getContentPane().add(DepaNameNewLabel);
		getContentPane().add(SearchtextField);
		
		this.fillTable(new Depa());
		try {
			this.FillJCB2();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * 部门删除
	 * @param e
	 * @throws SQLException 
	 */
	protected void DepaDelectActionPerformed(ActionEvent evt) throws SQLException {
		// TODO Auto-generated method stub
		String Depanum = DepaNumtextField.getText();
		if(StringUtil.IsEmpty(Depanum)) {
			JOptionPane.showMessageDialog(this,"请选择需要删除的记录");
			return;
		}
		int result = JOptionPane.showConfirmDialog(this, "是否需要删除该记录");
		if(result==0) {
			Connection conn = null;
			try {
				conn = JobUtil.getConnection();
				int result1 = new Depadao().delete(conn, Depanum);
				if(result1==1) {
					JOptionPane.showMessageDialog(this,"删除成功");
					this.resetValue();
					this.fillTable(new Depa());
					
					
				}else {
					JOptionPane.showMessageDialog(this,"删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				
			}finally {
				conn.close();
			}
		}
		
	}

	/**
	 * 更新操作
	 * @param e
	 */
	
	
	private void DepaUpdateActionPerform(ActionEvent evt) {
		// TODO Auto-generated method stub
		String DepaNum = DepaNumtextField.getText();
		String DepaName = DepaNametextField.getText();
		String EmpNum = EmpNumtextField.getText();
		if(StringUtil.IsEmpty(DepaNum)) {
			JOptionPane.showMessageDialog(this,"请选择需要修改的记录");
			return;
		}
		if(StringUtil.IsEmpty(DepaName)) {
			JOptionPane.showMessageDialog(this,"部门名称不能为空");
			return;
		}
		Depa dp = new Depa(DepaNum,DepaName,EmpNum);
		Connection conn = null;
		try{
			conn = JobUtil.getConnection();
			int result =new Depadao().update(conn, dp);
			if(result==1) {
				JOptionPane.showMessageDialog(this,"成功");
				this.resetValue();
				this.fillTable(new Depa());
			}else {
				JOptionPane.showMessageDialog(this,"失败");
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
//				this.fillTable(new Depa());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.fillTable(new Depa());
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void DepaTableMousePresed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row = Depatable.getSelectedRow();
		DepaNumtextField.setText((String)Depatable.getValueAt(row, 0));
		DepaNametextField.setText((String)Depatable.getValueAt(row, 1));
		EmpNumtextField.setText((String)Depatable.getValueAt(row, 2));
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
	//重置
	public void resetValue() {
		this.DepaNumtextField.setText("");
		this.DepaNametextField.setText("");
		this.EmpNumtextField.setText("");
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
