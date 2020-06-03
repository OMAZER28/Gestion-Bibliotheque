package gestionBibliotheque.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpBibliothecaire extends JPanel {
	
	//Components attributes
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JPanel headerPanel;
	private JPanel footerPanel;
	private JPanel userIconPanel;
	private JPanel userNamePanel;
	private JPanel emailPanel;
	private JPanel motDePassePanel;
	private JPanel signUpButtonPanel;
	private JPanel usersPanel;
	private JPanel dateNaissancePanel;
	private JLabel userIconLabel;
	private JPanel signUpLinkPanel;
	private JLabel signUpLinkLabel;
	private JButton signUpButton;
	private PlaceholderTextField userNameInput;
	private PlaceholderTextField emailInput;
	private PlaceholderTextField motDePasseInput;
	private PlaceholderTextField dateNaissanceInput;
	private JButton etudiant;
	private JButton enseignant;
	private JButton bibliothecaire;
	private GridBagConstraints gbcIcon;
	private GridBagConstraints gbcUserName;
	private GridBagConstraints gbcEmail;
	private GridBagConstraints gbcMotDePasse;
	private GridBagConstraints gbcUsers;
	private GridBagConstraints gbcDateNaissance;
	private GridBagConstraints gbcSignUpButton;
	private GridBagConstraints gbcSignUpLink;
	private GridBagConstraints gbcHeader;
	private GridBagConstraints gbcFooter;
	
	//Sign Up Screen constructor
	public SignUpBibliothecaire(CardLayout cl, JPanel cards, boolean etdSelected, boolean ensSelected, boolean bibSelected) {
			
		//content Panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        
        gbcIcon = new GridBagConstraints();
        gbcUserName = new GridBagConstraints();
        gbcEmail = new GridBagConstraints();
        gbcMotDePasse = new GridBagConstraints();
        gbcUsers = new GridBagConstraints();
        gbcDateNaissance = new GridBagConstraints();
        gbcSignUpButton = new GridBagConstraints();
        gbcSignUpLink = new GridBagConstraints();
        gbcHeader = new GridBagConstraints();
        gbcFooter = new GridBagConstraints();
        gbcIcon.fill = GridBagConstraints.BOTH;
        gbcUserName.fill = GridBagConstraints.BOTH;
        gbcEmail.fill = GridBagConstraints.BOTH;
        gbcMotDePasse.fill = GridBagConstraints.BOTH;
        gbcUsers.fill = GridBagConstraints.BOTH;
        gbcDateNaissance.fill = GridBagConstraints.BOTH;
        gbcSignUpButton.fill = GridBagConstraints.BOTH;
        gbcSignUpLink.fill = GridBagConstraints.BOTH;
        gbcHeader.fill = GridBagConstraints.BOTH;
        gbcFooter.fill = GridBagConstraints.BOTH;
        
        //header Panel
        headerPanel = new JPanel();
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        contentPane.add(headerPanel, gbcHeader);
        
		//icon Panel
        userIconPanel = new JPanel();
        gbcIcon.gridx = 0;
        gbcIcon.gridy = 1;
        contentPane.add(userIconPanel, gbcIcon);
        
        //nom d'utilisateur Panel
        userNamePanel = new JPanel();
        gbcUserName.gridx = 0;
        gbcUserName.gridy = 2;  
        contentPane.add(userNamePanel, gbcUserName);
        
        //email Panel
        emailPanel = new JPanel();
        gbcEmail.gridx = 0;
        gbcEmail.gridy = 3;  
        contentPane.add(emailPanel, gbcEmail);
        
        //mot de passe Panel
        motDePassePanel = new JPanel();
        gbcMotDePasse.gridx = 0;
        gbcMotDePasse.gridy = 4;  
        contentPane.add(motDePassePanel, gbcMotDePasse);
        
        //utilisateurs Panel
        usersPanel = new JPanel();
        gbcUsers.gridx = 0;
        gbcUsers.gridy = 5;
        contentPane.add(usersPanel, gbcUsers);
        
        //date de naissance Panel
        dateNaissancePanel = new JPanel();
        gbcDateNaissance.gridx = 0;
        gbcDateNaissance.gridy = 6;
        contentPane.add(dateNaissancePanel, gbcDateNaissance);
        
        //sign Up button Panel
        signUpButtonPanel = new JPanel();
        gbcSignUpButton.gridx = 0;
        gbcSignUpButton.gridy = 7;  
        gbcSignUpButton.ipadx = 200;
        contentPane.add(signUpButtonPanel, gbcSignUpButton);
        
        //sign up link Panel
        signUpLinkPanel = new JPanel();
        gbcSignUpLink.gridx = 0;
        gbcSignUpLink.gridy = 8; 
        contentPane.add(signUpLinkPanel, gbcSignUpLink);
 
		//footer Panel
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        gbcFooter.gridx = 0;
        gbcFooter.gridy = 9;
        contentPane.add(footerPanel, gbcFooter);
        
        //user icon label
        userIconLabel = new JLabel();
        userIconPanel.add(userIconLabel);
        
        //user icon
		BufferedImage userImg = null;
		try {
			userImg = ImageIO.read(new File("images/adduserIcon.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image duserImg = userImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon userIcon = new ImageIcon(duserImg);
		userIconLabel.setIcon(userIcon);
		
		//nom d'utilisateur input field
		userNameInput = new PlaceholderTextField("");
		userNameInput.setPlaceholder("Nom utilisateur");
		userNameInput.setColumns(25);
		userNameInput.setMargin(new Insets(10, 10, 10, 10));
		userNameInput.setForeground(new Color(80, 80, 80));
		userNamePanel.add(userNameInput);
		
		//email input field
		emailInput = new PlaceholderTextField("");
		emailInput.setPlaceholder("Email");
		emailInput.setColumns(25);
		emailInput.setMargin(new Insets(10, 10, 10, 10));
		emailInput.setForeground(new Color(80, 80, 80));
		emailPanel.add(emailInput);
		
		//mot de passe input field
		motDePasseInput = new PlaceholderTextField("");
		motDePasseInput.setPlaceholder("Mot de passe");
		motDePasseInput.setColumns(25);
		motDePasseInput.setMargin(new Insets(10, 10, 10, 10));
		motDePasseInput.setForeground(new Color(80, 80, 80));
		motDePassePanel.add(motDePasseInput);
		
		//date de naissance input field
		dateNaissanceInput = new PlaceholderTextField("");
		dateNaissanceInput.setPlaceholder("Date de naissance");
		dateNaissanceInput.setColumns(25);
		dateNaissanceInput.setMargin(new Insets(10, 10, 10, 10));
		dateNaissanceInput.setForeground(new Color(80, 80, 80));
		dateNaissancePanel.add(dateNaissanceInput);
		
		//sign up button
		signUpButton = new JButton("S'enregister");
		signUpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(cards, "home page");
			}
		});
		signUpButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
		signUpButton.setFocusPainted(false);
		signUpButton.setMargin(new Insets(8, 85, 8, 85));
		signUpButton.setBackground(new Color(0,200,100));
		signUpButton.setForeground(Color.WHITE);
		signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUpButtonPanel.add(signUpButton);
		
		//sign up link label
		signUpLinkLabel = new JLabel("Vous avez déjà un compte ? Se connecter");
		signUpLinkLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(cards, "sign in page");
			}
		});
		signUpLinkLabel.setForeground(new Color(0,60,255));
		Font font = signUpLinkLabel.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		signUpLinkLabel.setFont(font.deriveFont(attributes));
		signUpLinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUpLinkPanel.add(signUpLinkLabel);
		
        //sign up icon
		BufferedImage signUpImg = null;
		try {
			signUpImg = ImageIO.read(new File("images/signUp.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dsignUpImg = signUpImg.getScaledInstance(18,18, Image.SCALE_SMOOTH);
		ImageIcon signUpIcon = new ImageIcon(dsignUpImg);
		signUpButton.setIcon(signUpIcon);
		
		//users button
		etudiant = new JButton("Etudiant");
		etudiant.setFont(new Font("Century Gothic", Font.BOLD, 14));
		etudiant.setFocusPainted(false);
		etudiant.setBackground(Color.WHITE);
		etudiant.setForeground(new Color(0,120,255));
		etudiant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        enseignant = new JButton("Enseignant"); 
        enseignant.setFont(new Font("Century Gothic", Font.BOLD, 14));
        enseignant.setFocusPainted(false);
        enseignant.setBackground(Color.WHITE);
        enseignant.setForeground(new Color(0,120,255));
        enseignant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bibliothecaire = new JButton("Bibliothecaire"); 
        bibliothecaire.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bibliothecaire.setFocusPainted(false);
        bibliothecaire.setBackground(Color.WHITE);
        bibliothecaire.setForeground(new Color(0,120,255));
        bibliothecaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        usersPanel.add(etudiant);
        usersPanel.add(enseignant);
        usersPanel.add(bibliothecaire);
        
        etudiant.setEnabled(etdSelected);
        enseignant.setEnabled(ensSelected);
        bibliothecaire.setEnabled(bibSelected);
        
        //etudiant icon
		BufferedImage etudiantImage = null;
		try {
			etudiantImage = ImageIO.read(new File("images/etudiant.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image detudiantImage = etudiantImage.getScaledInstance(18,18, Image.SCALE_SMOOTH);
		ImageIcon etudiantIcon = new ImageIcon(detudiantImage);
		etudiant.setIcon(etudiantIcon);
		
        //enseignant icon
		BufferedImage enseignantImage = null;
		try {
			enseignantImage = ImageIO.read(new File("images/enseignant.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image denseignantImage = enseignantImage.getScaledInstance(18,18, Image.SCALE_SMOOTH);
		ImageIcon enseignantIcon = new ImageIcon(denseignantImage);
		enseignant.setIcon(enseignantIcon);
		
        //bibliothecaire icon
		BufferedImage bibliothecaireImage = null;
		try {
			bibliothecaireImage = ImageIO.read(new File("images/bibliothecaire.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dbibliothecaireImage = bibliothecaireImage.getScaledInstance(18,18, Image.SCALE_SMOOTH);
		ImageIcon bibothecaireIcon = new ImageIcon(dbibliothecaireImage);
		bibliothecaire.setIcon(bibothecaireIcon);
        
        //navigation
        etudiant.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		cl.show(cards, "sign up etudiant page");
        	}
        });
        enseignant.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		cl.show(cards, "sign up enseignant page");
        	}
        });
        bibliothecaire.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		cl.show(cards, "sign up bibliothecaire page");
        	}
        });
        
		setBackground(Color.WHITE);           
		add(contentPane);
	}
}
