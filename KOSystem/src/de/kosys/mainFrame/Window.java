package de.kosys.mainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.kosys.todo.ToDo;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ToDo todo = new ToDo();
	
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
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(240, 30, 560, 420);
		getContentPane().add(layeredPane);
		
		JPanel todoPanel = new JPanel();
		todoPanel.setBounds(0, 0, 560, 420);
		layeredPane.add(todoPanel);
		todoPanel.setLayout(null);
		
		JPanel chatPanel = new JPanel();
		chatPanel.setBounds(0, 0, 560, 420);
		layeredPane.add(chatPanel);
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 0, 560, 420);
		layeredPane.add(userPanel);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(0, 0, 560, 420);
		layeredPane.add(settingsPanel);
		
		
		JButton page1 = new JButton("TODO");
		page1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectPage(todoPanel);
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
				selectPage(chatPanel);
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
				selectPage(userPanel);
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
				selectPage(settingsPanel);
			}
		});
		page4.setFont(new Font("Tahoma", Font.BOLD, 16));
		page4.setForeground(Color.WHITE);
		page4.setBorder(null);
		page4.setBackground(SystemColor.controlShadow);
		page4.setBounds(0, 190, 240, 50);
		sidePanel.add(page4);
		
		setVisible(true);
	}
	
	private void selectPage(JPanel panel) {
		getLayeredPane().removeAll();
		getLayeredPane().add(panel);
		getLayeredPane().repaint();
		getLayeredPane().revalidate();
	}
	
	private void createToDoLabels() {
		int x = 0;
		int y = 0;
		
		int wm = 5; // Width margin
		int hm = 10; // Height margin
		
//		for(int i = 0; i < todo.getmaxID(); i++) {
//			JPanel Task = new JPanel();
//			Task.setBounds(x, y, 130, 190);
//			todoPanel.add(Task);
//		}
//		
		
	}
}