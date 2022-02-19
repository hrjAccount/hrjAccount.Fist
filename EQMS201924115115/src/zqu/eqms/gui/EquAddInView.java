package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import zqu.eqms.dao.Equidao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Equi;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EquAddInView extends JInternalFrame {
	private JTextField EquNametextField;
	private JTextField EquPricetextField_1;
	private JTextField BuyTimetextField_2;
	private JTextField EquLoctextField_3;
	private JTextField EquMantextField_4;
	private Equidao eqd= new Equidao();
	private JComboBox  comboBox;
	private JComboBox comboBox_1;
 	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquAddInView frame = new EquAddInView();
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
	public EquAddInView() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("设备添加");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 688, 480);
		getContentPane().setLayout(null);
		
		JLabel EquNameNewLabel = new JLabel("设备名称：");
		EquNameNewLabel.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/设备名称18.png")));
		EquNameNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		EquNameNewLabel.setBounds(47, 40, 129, 34);
		getContentPane().add(EquNameNewLabel);
		
		JLabel EqupriceNewLabel_1 = new JLabel("设备价格：");
		EqupriceNewLabel_1.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/价格18.png")));
		EqupriceNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		EqupriceNewLabel_1.setBounds(47, 106, 129, 24);
		getContentPane().add(EqupriceNewLabel_1);
		
		JLabel BuyTimeNewLabel_2 = new JLabel("购买时间：");
		BuyTimeNewLabel_2.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/时间18.png")));
		BuyTimeNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		BuyTimeNewLabel_2.setBounds(47, 159, 129, 34);
		getContentPane().add(BuyTimeNewLabel_2);
		
		JLabel EquLocNewLabel_3 = new JLabel("设备所在地：");
		EquLocNewLabel_3.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/所在地18.png")));
		EquLocNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		EquLocNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		EquLocNewLabel_3.setBounds(31, 239, 147, 34);
		getContentPane().add(EquLocNewLabel_3);
		
		JLabel ManNewLabel_4 = new JLabel("设备负责人：");
		ManNewLabel_4.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/编号18 2.png")));
		ManNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		ManNewLabel_4.setBounds(31, 298, 147, 34);
		getContentPane().add(ManNewLabel_4);
		
		EquNametextField = new JTextField();
		EquNametextField.setBounds(171, 41, 131, 34);
		getContentPane().add(EquNametextField);
		EquNametextField.setColumns(10);
		
		EquPricetextField_1 = new JTextField();
		EquPricetextField_1.setColumns(10);
		EquPricetextField_1.setBounds(171, 106, 131, 34);
		getContentPane().add(EquPricetextField_1);
		
		BuyTimetextField_2 = new JTextField();
		BuyTimetextField_2.setColumns(10);
		BuyTimetextField_2.setBounds(171, 162, 131, 34);
		getContentPane().add(BuyTimetextField_2);
		
		EquLoctextField_3 = new JTextField();
		EquLoctextField_3.setColumns(10);
		EquLoctextField_3.setBounds(171, 242, 131, 34);
		getContentPane().add(EquLoctextField_3);
		
		EquMantextField_4 = new JTextField();
		EquMantextField_4.setColumns(10);
		EquMantextField_4.setBounds(171, 301, 131, 34);
		getContentPane().add(EquMantextField_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "\u8BBE\u5907\u89C4\u683C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(334, 47, 213, 89);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addItem("大");
		comboBox.addItem("中");
		comboBox.addItem("小");
		
		comboBox.setBounds(10, 30, 193, 33);
		panel.add(comboBox);
		
		JLabel ExampleNewLabel_2_1 = new JLabel("(例如：2021-01-01)");
		ExampleNewLabel_2_1.setFont(new Font("宋体", Font.BOLD, 20));
		ExampleNewLabel_2_1.setBounds(68, 198, 223, 34);
		getContentPane().add(ExampleNewLabel_2_1);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/添加18.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquAddActionPerformed(e);
			}
		});
		btnNewButton.setBounds(330, 202, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon(EquAddInView.class.getResource("/zqu/eqms/img/重置18.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(476, 202, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(47, 342, 255, 34);
		getContentPane().add(comboBox_1);
		try {
			this.FillJCB2();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	//添加
	private void EquAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String EquName =  EquNametextField.getText();
		String EquPrice = EquPricetextField_1.getText();
		String BuyTime = BuyTimetextField_2.getText();
		String EquLoc = EquLoctextField_3.getText();
		String EquMan = EquMantextField_4.getText();
		String Equspc = (String) comboBox.getSelectedItem();
		if(StringUtil.IsEmpty(EquName)) {
			JOptionPane.showMessageDialog(this,"设备名称不能为空");
			return;
		}
		if(StringUtil.IsEmpty(EquMan)) {
			JOptionPane.showMessageDialog(this,"管理员编号不能为空");
			return;
		}
		Equi eq = new Equi();
		eq.setEquName(EquName);
		eq.setEquPri(EquPrice);
		eq.setBuyTime(BuyTime);
		eq.setEquLoc(EquLoc);
		eq.setEmpNum(EquMan);
		eq.setEquSpc(Equspc);
		Connection conn = null;
		try {
			conn = new JobUtil().getConnection();
			int result = eqd.addEque(conn, eq);
			if(result==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		}catch(Exception e){
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

	//重置事件
	private void ResetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetvalue();
	}
	
	//重置函数
	private void resetvalue() {
		this.EquNametextField.setText("");
		this.EquPricetextField_1.setText("");
		this.BuyTimetextField_2.setText("");
		this.EquLoctextField_3.setText("");
		this.EquMantextField_4.setText("");
		
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
			this.comboBox_1.addItem(s);
		}
	}

}
