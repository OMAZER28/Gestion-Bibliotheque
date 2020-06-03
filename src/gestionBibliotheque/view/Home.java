package gestionBibliotheque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;


public class Home extends JPanel {
	
	//Components attributes
	private static final long serialVersionUID = 1L;
	
	//Sign In Screen constructor
	public Home(CardLayout cl, JPanel cards) {
        
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.WHITE);
		add(menuPanel, BorderLayout.WEST);
		GridBagLayout gbl_menuPanel = new GridBagLayout();
		gbl_menuPanel.columnWidths = new int[]{1, 0};
		gbl_menuPanel.rowHeights = new int[]{1, 0};
		gbl_menuPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_menuPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		menuPanel.setLayout(gbl_menuPanel);
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.WHITE);
		add(footerPanel, BorderLayout.SOUTH);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		add(headerPanel, BorderLayout.NORTH);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		add(contentPane, BorderLayout.CENTER);
		
        //logo icon
		BufferedImage logoImg = null;
		try {
			logoImg = ImageIO.read(new File("images/logo.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dlogoImg = logoImg.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(dlogoImg);
		
		JLabel logoLabel = new JLabel("");
		GridBagConstraints gbc_logoLabel = new GridBagConstraints();
		gbc_logoLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_logoLabel.gridx = 0;
		gbc_logoLabel.gridy = 0;
		gbc_logoLabel.ipadx = 100;
		menuPanel.add(logoLabel, gbc_logoLabel);
		logoLabel.setIcon(logoIcon);
	}

}
