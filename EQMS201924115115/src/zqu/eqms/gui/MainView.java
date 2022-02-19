package zqu.eqms.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zqu.eqms.domain.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView(new User());
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
	public MainView(User u2) {
		setTitle("高校设备管理系统管理员主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 697);
		
		
		//panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		//读取图片
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./imgs/卡通.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon1 = new ImageIcon(img);
		
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 967, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 627, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1529, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//

		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本功能");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/功能18.png")));
		mnNewMenu.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("设备管理");
		mnNewMenu_1.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/设备18.png")));
		mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 18));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("设备添加");
		mntmNewMenuItem.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/添加18.png")));
		mntmNewMenuItem.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquAddInView eaiv = new EquAddInView();
				eaiv.setVisible(true);
				table.add(eaiv);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("设备维护");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/数据维护18.png")));
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EquManaInView emiv = new EquManaInView();
					emiv.setVisible(true);
					table.add(emiv);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("部门管理");
		mnNewMenu_2.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/部门18.png")));
		mnNewMenu_2.setFont(new Font("宋体", Font.BOLD, 18));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("部门添加");
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/添加18.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepaAddInView dav = new DepaAddInView();
				dav.setVisible(true);
				table.add(dav);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("部门维护");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/数据维护18.png")));
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DepaManaInView dmi = new DepaManaInView();
				dmi.setVisible(true);
				table.add(dmi);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("员工管理");
		mnNewMenu_3.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/员工18.png")));
		mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 18));
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("员工添加");
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/添加18.png")));
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddInView uaiv = new UserAddInView();
				uaiv.setVisible(true);
				table.add(uaiv);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("员工维护");
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/数据维护18.png")));
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManaInView umiv = new UserManaInView();
				umiv.setVisible(true);
				table.add(umiv);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("退出");
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/退出18.png")));
		mntmNewMenuItem_6.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出该系统");
				if(result==0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("相关信息");
		mnNewMenu_4.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/相关资料18.png")));
		mnNewMenu_4.setFont(new Font("宋体", Font.BOLD, 18));
		menuBar.add(mnNewMenu_4);
		
		
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("作者相关信息");
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/作者18.png")));
		mntmNewMenuItem_7.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_7.setSelected(true);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbUsInView aiv = new AbUsInView();
				aiv.setVisible(true);
				table.add(aiv);
//				AbUsInView aiv = new AbUsInView();
//				aiv.setVisible(true);
//				table.add(aiv);
//				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("登录用户信息");
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainView.class.getResource("/zqu/eqms/img/用户18.png")));
		mntmNewMenuItem_8.setFont(new Font("宋体", Font.BOLD, 18));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMessage ums = new UserMessage(u2);
				ums.setVisible(true);
				table.add(ums);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		
		//最大化 和居中
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
