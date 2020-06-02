package de.kosys.mainFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import de.kosys.todo.ToDoLable;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
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
				selectPage(1);
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
				selectPage(2);
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
				selectPage(3);
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
				selectPage(4);
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
		
		setVisible(true);
	}
	
	private void selectPage(int page) {
		ToDoLable tdc = new ToDoLable();
		switch(page) {
		case 1:	//TODOPAGE
			tdc.makeToDo();
			break;
		case 2:	//CHATPAGE
			
			break;
		case 3:	//USERPAGE
			
			break;
		case 4:	//SETTINGSPAGE
			
			break;
		}
	}
}