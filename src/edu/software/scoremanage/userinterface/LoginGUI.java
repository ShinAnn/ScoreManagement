package edu.software.scoremanage.userinterface;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame{
	
	Toolkit tools = Toolkit.getDefaultToolkit();
	int width = tools.getScreenSize().width;
	int height = tools.getScreenSize().height;
	
	public LoginGUI(){
		super();
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setTitle("Login");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = tools.getImage("F:\\icons\\th_Lastfm2.png");
		this.setIconImage(icon);
		
		JPanel pinkPanel = new JPanel();
		this.add(pinkPanel);
		pinkPanel.setBackground(Color.PINK);
		pinkPanel.setLayout(null);
		pinkPanel.setVisible(true);
		pinkPanel.setBounds(0, 0, 400, 300);
		
		JButton button = new JButton();
		pinkPanel.add(button);
		button.setLayout(null);
		button.setText("yamete");
		button.setSize(100,50);
		button.setLocation(150,100);
		button.setVisible(true);
		
		JPanel blackPanel = new JPanel();
		this.add(blackPanel);
		blackPanel.setLayout(null);
		blackPanel.setBounds(0, 0, width/10,height/10);
		blackPanel.setBackground(Color.DARK_GRAY);
		blackPanel.setVisible(true);
		
		return;
	}
	
	public void init(){
		
	}

}
