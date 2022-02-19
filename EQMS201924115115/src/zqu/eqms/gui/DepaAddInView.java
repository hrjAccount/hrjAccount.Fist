package zqu.eqms.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import zqu.eqms.dao.Depadao;
import zqu.eqms.dao.Userdao;
import zqu.eqms.domain.Depa;
import zqu.eqms.domain.User;
import zqu.eqms.util.JobUtil;
import zqu.eqms.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class DepaAddInView extends JInternalFrame {
	private JTextField DepaTextField;
	private JTextField DepaManTextField;
	private JobUtil ju = new JobUtil();
	private Depadao Dd = new Depadao();
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepaAddInView frame = new DepaAddInView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//变好看
//				try
//			    { 
//			        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//			    } catch(Exception e){ 
//					//TODO exception 
//			    } 
	}

	/**
	 * Create the frame.
	 */
	public DepaAddInView() {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setIconifiable(true);
		setTitle("部门添加");
		setBounds(100, 100, 533, 362);
		
		JLabel DepaLabel = new JLabel("部门名称：");
		DepaLabel.setBounds(78, 88, 146, 28);
		DepaLabel.setIcon(new ImageIcon(DepaAddInView.class.getResource("/zqu/eqms/img/名称18.png")));
		DepaLabel.setFont(new Font("宋体", Font.BOLD, 24));
		
		DepaTextField = new JTextField();
		DepaTextField.setBounds(234, 88, 173, 30);
		DepaTextField.setFont(new Font("宋体", Font.BOLD, 20));
		DepaTextField.setColumns(10);
		
		DepaManTextField = new JTextField();
		DepaManTextField.setBounds(234, 157, 173, 34);
		DepaManTextField.setFont(new Font("宋体", Font.BOLD, 20));
		DepaManTextField.setColumns(10);
		
		JLabel DepaManLabel = new JLabel("部门主管：");
		DepaManLabel.setBounds(78, 157, 146, 28);
		DepaManLabel.setIcon(new ImageIcon(DepaAddInView.class.getResource("/zqu/eqms/img/编号18.png")));
		DepaManLabel.setFont(new Font("宋体", Font.BOLD, 24));
		
		JButton AddNewButton = new JButton("添加");
		AddNewButton.setBounds(78, 253, 97, 31);
		AddNewButton.setIcon(new ImageIcon(DepaAddInView.class.getResource("/zqu/eqms/img/添加18.png")));
		AddNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		AddNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepaAddActionPerformed(e);
			}
		});
		AddNewButton.setBackground(Color.WHITE);
		
		JButton ResetNewButton = new JButton("重置");
		ResetNewButton.setBounds(337, 253, 97, 31);
		ResetNewButton.setIcon(new ImageIcon(DepaAddInView.class.getResource("/zqu/eqms/img/重置18.png")));
		ResetNewButton.setFont(new Font("宋体", Font.BOLD, 18));
		ResetNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValueAction(e);
			}
		});
		ResetNewButton.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(DepaManLabel);
		getContentPane().add(DepaLabel);
		getContentPane().add(DepaManTextField);
		getContentPane().add(DepaTextField);
		getContentPane().add(AddNewButton);
		getContentPane().add(ResetNewButton);
		
		comboBox = new JComboBox();
		comboBox.setBounds(121, 204, 270, 39);
		getContentPane().add(comboBox);

		try {
			this.FillJCB2();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	//部门添加事件
	private void DepaAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String Depaname = this.DepaTextField.getText();
		String DepaMan = this.DepaManTextField.getText();
		if(StringUtil.IsEmpty(Depaname)) {
			JOptionPane.showMessageDialog(this,"部门名称不能为空");
			return;
		}
//		if(StringUtil.IsEmpty(DepaMan)) {
//			JOptionPane.showMessageDialog(this,"部门主管编号不能为空");
//			return;
//		}
		Depa dp = new Depa();
		Depa.setDepaName(Depaname);
		Depa.setEmpNum(DepaMan);
		Connection conn = null;
		
		try {
			conn = ju.getConnection();
			int result = Dd.addDepa(conn, dp);
			if(result==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
			
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
	private void ResetValueAction(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	//重置表单
	private void resetValue() {
		this.DepaTextField.setText("");
		this.DepaManTextField.setText("");
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
