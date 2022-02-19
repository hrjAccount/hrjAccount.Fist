package zqu.eqms.gui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JInternalFrame;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AbUsInView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbUsInView frame = new AbUsInView();
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
	public AbUsInView() {
		setIconifiable(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		//读取图片
//		ImageIcon icon = new ImageIcon("./imgs/校徽.png");
		//
		
		//读取图片
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./imgs/校徽.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon icon1 = new ImageIcon(img);
		//
		
		
		
		//北边的
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);
		JLabel MarkLabel = new JLabel(icon1);
		panel.add(MarkLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel ClassLabel = new JLabel("班级：");
		ClassLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		ClassLabel.setEnabled(true);
		
		JLabel NameLabel = new JLabel("姓名：");
		NameLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		NameLabel.setEnabled(true);
		
		JLabel NumLabel = new JLabel("学号：");
		NumLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		NumLabel.setEnabled(true);
		
		JLabel ClassLabel_1 = new JLabel("19数据科学与大数据技术");
		ClassLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		ClassLabel_1.setEnabled(true);
		
		JLabel NameLabel_1 = new JLabel("黄日靖");
		NameLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		NameLabel_1.setEnabled(true);
		
		JLabel NumLabel_1 = new JLabel("201924115115");
		NumLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 24));
		NumLabel_1.setEnabled(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(ClassLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(NumLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(NameLabel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(ClassLabel_1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(NumLabel_1, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(ClassLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NumLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(ClassLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NameLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(NumLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(292, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		//
		setClosable(true);
		setTitle("作者相关信息");
		setBounds(100, 100, 688, 468);
		
		
	
		
	}
}
