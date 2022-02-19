package zqu.eqms.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zqu.eqms.domain.User;
import zqu.eqms.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import zqu.eqms.dao.Userdao;

import zqu.eqms.util.*;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalExclusionType;


public class FirstView extends JFrame {

	private JPanel contentPane;
	private JTextField UserField;
	private JTextField PassWordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView frame = new FirstView();
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
	public FirstView() {
		setTitle("高校设备管理系统登录界面");
		setResizable(false);
		
		//读取图片
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./imgs/1.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(img);
		//
		
		//
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
		System.out.println(icon.getIconWidth());
		System.out.println(icon.getIconHeight());
		//
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(false);
		contentPane.setLayout(null);
		
		JLabel TitleLabel = new JLabel("高校设备管理系统");
		TitleLabel.setForeground(new Color(255, 153, 0));
		TitleLabel.setFont(new Font("宋体", Font.BOLD, 25));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(184, 35, 260, 25);
		contentPane.add(TitleLabel);
		
		
		//选择按钮
		JRadioButton AdminRadioButton = new JRadioButton("管理员登录");
		buttonGroup.add(AdminRadioButton);
		AdminRadioButton.setBounds(184, 253, 127, 23);
		AdminRadioButton.setOpaque(false);
		contentPane.add(AdminRadioButton);
		
		
		
		JRadioButton UserRadioButton = new JRadioButton("用户登录");
		UserRadioButton.setSelected(true);
		buttonGroup.add(UserRadioButton);
		UserRadioButton.setBounds(399, 253, 127, 23);
		UserRadioButton.setOpaque(false);
		contentPane.add(UserRadioButton);
		//

		
		//四个按钮
		JButton ResetButton = new JButton("重置");
		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserField.setText("");
				passwordField.setText("");
			}
		});
		ResetButton.setBounds(411, 305, 97, 23);
		contentPane.add(ResetButton);
		
		JButton EndButton = new JButton("结束");
		EndButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		EndButton.setBounds(281, 305, 97, 23);
		contentPane.add(EndButton);
		
		JButton SignInButton = new JButton("登录");
		SignInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean seleAdmin = AdminRadioButton.isSelected();
				LogActionPerformed(e,seleAdmin);
				
			}
		});
		SignInButton.setBounds(151, 305, 97, 23);
		contentPane.add(SignInButton);
		//
		
		//用户名、密码文本字段
		JLabel UserLabel = new JLabel("用户名");
		UserLabel.setForeground(new Color(255, 127, 80));
		UserLabel.setFont(new Font("宋体", Font.BOLD, 21));
		UserLabel.setBounds(170, 92, 100, 50);
		contentPane.add(UserLabel);
		
		JLabel PassWordLabel = new JLabel("密码");
		PassWordLabel.setForeground(new Color(255, 160, 122));
		PassWordLabel.setFont(new Font("宋体", Font.BOLD, 24));
		PassWordLabel.setBounds(170, 192, 100, 50);
		contentPane.add(PassWordLabel);
		//
		
		//输入的用户名、密码
		UserField = new JTextField();
		UserField.setBounds(270, 102, 160, 30);
		contentPane.add(UserField);
		UserField.setColumns(10);
		
//		PassWordField = new JTextField();
//		PassWordField.setBounds(270, 199, 160, 30);
//		contentPane.add(PassWordField);
//		PassWordField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 199, 160, 30);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
	
		//
		
		
		
		//背景图
		JLabel imgLabel = new JLabel(icon);
		imgLabel.setBounds(0, 0, 658, 432);
		contentPane.add(imgLabel);
		imgLabel.setOpaque(false);
		
		
		
		//居中
		this.setLocationRelativeTo(null);
		
	}
	/**
	 * 登录处理
	 * @param e
	 */
	private void LogActionPerformed(ActionEvent evt,boolean select) {
		String userName = this.UserField.getText();
		String passWord = new String(this.passwordField.getPassword());
		if(StringUtil.IsEmpty(userName)) {
			JOptionPane.showMessageDialog(contentPane, "用户名不能为空");
			return;
		}else {
			if(StringUtil.IsEmpty(passWord)) {
				JOptionPane.showMessageDialog(contentPane, "密码不能为空");
				return;
			}else {
				if(select) {
					User u1 =new User();
					u1.setEmpNum(userName);
//					u1.setEmpName(userName);
					u1.setEmpPass(passWord);
					Connection conn = new JobUtil().getConnection();
					try {
						User u2 = new Userdao().login(conn, u1);
						if(u2!=null) {
							if(u2.getEmpPass()==null) {
								JOptionPane.showMessageDialog(contentPane,"密码错误");
								return;
							}else {
								
								if(u2.getSvONot().equals("管理员")) {
									JOptionPane.showMessageDialog(contentPane,"欢迎你！！！" + u2.getEmpName());
									dispose();
									new MainView(u2).setVisible(true);
								}else {
									JOptionPane.showMessageDialog(contentPane,"该用户不是管理员");
								}
							}
								
						}else {
							JOptionPane.showMessageDialog(contentPane,"查无此人");
							return;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("获取失败");
						return;
					}finally {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				}else {
					User u1 =new User();
					u1.setEmpNum(userName);
//					u1.setEmpName(userName);
					u1.setEmpPass(passWord);
					Connection conn = new JobUtil().getConnection();
					try {
						User u2 = new Userdao().login(conn, u1);
						if(u2!=null) {
							if(u2.getEmpPass()==null) {
								JOptionPane.showMessageDialog(contentPane,"密码错误");
							}else {
								JOptionPane.showMessageDialog(contentPane,"欢迎你！！！" + u2.getEmpName());
								dispose();
								new MainView2(u2).setVisible(true);
							}
							
						}else {
							JOptionPane.showMessageDialog(contentPane,"查无此人,请联系管理员");
							return;
							
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
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
		}
		
		
	}
}
