package de.kosys.mainFrame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Window() {
		setSize(800,450);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 800, 30);
		topPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JButton closebtn = new JButton("X");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closebtn.setBounds(750, 0, 50, 30);
		closebtn.setBackground(new Color(0,0,0,0));
		closebtn.setForeground(Color.WHITE);
		topPanel.add(closebtn);
		closebtn.setBorder(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBounds(0, 30, 240, 420);
		sidePanel.setBackground(Color.GRAY);
		getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		JButton page1 = new JButton("TODO");
		page1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		page1.setFont(new Font("Tahoma", Font.BOLD, 16));
		page1.setForeground(Color.WHITE);
		page1.setBorder(null);
		page1.setBackground(SystemColor.controlShadow);
		page1.setBounds(0, 10, 240, 50);
		sidePanel.add(page1);
		
		JButton page2 = new JButton("CHAT");
		page2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		page2.setFont(new Font("Tahoma", Font.BOLD, 16));
		page2.setForeground(Color.WHITE);
		page2.setBorder(null);
		page2.setBackground(SystemColor.controlShadow);
		page2.setBounds(0, 70, 240, 50);
		sidePanel.add(page2);
		
		JButton page3 = new JButton("USER");
		page3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		page3.setFont(new Font("Tahoma", Font.BOLD, 16));
		page3.setForeground(Color.WHITE);
		page3.setBorder(null);
		page3.setBackground(SystemColor.controlShadow);
		page3.setBounds(0, 130, 240, 50);
		sidePanel.add(page3);
		
		JButton page4 = new JButton("SETTINGS");
		page4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		page4.setFont(new Font("Tahoma", Font.BOLD, 16));
		page4.setForeground(Color.WHITE);
		page4.setBorder(null);
		page4.setBackground(SystemColor.controlShadow);
		page4.setBounds(0, 190, 240, 50);
		sidePanel.add(page4);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(240, 30, 560, 420);
		mainPanel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel todoPanel = new JPanel();
		todoPanel.setBounds(10, 10, 540, 400);
		todoPanel.setVisible(false);
		mainPanel.add(todoPanel);
		todoPanel.setLayout(null);
		
		JPanel chatPanel = new JPanel();
		chatPanel.setBounds(10, 10, 540, 400);
		chatPanel.setVisible(false);
		mainPanel.add(chatPanel);
		chatPanel.setLayout(null);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(10, 10, 540, 400);
		userPanel.setVisible(false);
		mainPanel.add(userPanel);
		userPanel.setLayout(null);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(10, 10, 540, 400);
		settingsPanel.setVisible(false);
		mainPanel.add(settingsPanel);
		settingsPanel.setLayout(null);
		
		setVisible(true);
	}
}