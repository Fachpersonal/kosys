package de.kosys.mainFrame;

import de.kosys.todo.ToDo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

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
	
	private JPanel todoPanel;
	private JPanel todoPanelInfos;
	private JPanel userPanel;
	private JPanel chatPanel;
	private JPanel settingsPanel;
	
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
		
		//#####################################################################################################################################
		
		todoPanel = new JPanel();
		todoPanel.setBounds(240, 30, 560, 420);
		layeredPane.add(todoPanel);
		todoPanel.setLayout(null);
		
		chatPanel = new JPanel();
		chatPanel.setBounds(240, 30, 560, 420);
		layeredPane.add(chatPanel);
		chatPanel.setLayout(null);
		
		userPanel = new JPanel();
		userPanel.setBounds(240, 30, 560, 420);
		layeredPane.add(userPanel);
		userPanel.setLayout(null);
		
		settingsPanel = new JPanel();
		settingsPanel.setBounds(240, 30, 560, 420);
		layeredPane.add(settingsPanel);
		settingsPanel.setLayout(null);
		
		//#####################################################################################################################################
		
		JButton page1 = new JButton("TODO");
		page1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todo.getToDoList();
				createToDoLabels();
				selectPage(todoPanel);
//				System.out.println(todo.getmaxID());
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
		getLayeredPane().remove(todoPanel);
//		getLayeredPane().remove(todoPanelInfos);
		getLayeredPane().remove(chatPanel);
		getLayeredPane().remove(userPanel);	
		getLayeredPane().remove(settingsPanel);
		getLayeredPane().add(panel);
		getLayeredPane().repaint();
		getLayeredPane().revalidate();
	}
	
	private void createToDoLabels() {
		
		JButton[] arr = new JButton[todo.getmaxID()];
		
		int x = 0;
		int y = 0;
		
		int placeholder = 0;
		
		int witdh = 176;
		int height = 95;
		
		int wm = 5; // Width margin
		int hm = 10; // Height margin
	
		for(int i = 0; i < todo.getmaxID(); i++) {
//			
			arr[i] = new JButton(todo.getTitle(i));
			arr[i].setBounds(wm + x, hm + y, witdh, height);
			arr[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(null, "Title: \n	" + todo.getTitle(i) + "\n Created by: \n" + todo.getcreatedBy(i) + "\n Needs to be finish till: \n" + todo.getfinishDate(i));
					
//					System.out.println("GUSTAV BTN PRESSED!");
				}
			});
			switch(todo.getStatus(i)) {
			case "ToDo":
				arr[i].setBackground(Color.RED);	// TODO Change COLOR!!!
				break;
			case "In Work":
				arr[i].setBackground(Color.YELLOW);		// TODO Change COLOR!!!
				break;
			case "Done":
				arr[i].setBackground(Color.GREEN);		// TODO Change COLOR!!!
				break;
			}
			
			todoPanel.add(arr[i]);
			
			placeholder++;
			x += 186;
			if(placeholder == 3) {
				y += 105;
				x = 0;
				placeholder = 0;
			}
		}
	}
}