package gestionBibliotheque.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestionBibliotheque.controller.UtilisateurController;
import gestionBibliotheque.dao.DAOException;
import gestionBibliotheque.dao.utilisateurs.AdherantDAO;
import gestionBibliotheque.dao.utilisateurs.BibliothecaireDAO;
import gestionBibliotheque.dao.utilisateurs.UtilisateurDAO;
import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;
import gestionBibliotheque.model.utilisateurs.Etudiant;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

import java.awt.Image;
import java.awt.Insets;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignIn extends JPanel {
	
	//Components attributes
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel headerPane;
	private JPanel footerPane;
	private JPanel userIconPanel;
	private JPanel emailPanel;
	private JPanel motDePassePanel;
	private JPanel signInButtonPanel;
	private JPanel signUpLinkPanel;
	private JLabel signUpLinkLabel;
	private JLabel userIconLabel;
	private JButton signInButton;
	private PlaceholderTextField emailInput;
	private PlaceholderPasswordField motDePasseInput;
	
	private Utilisateur user;
	
	private UtilisateurController uc;
	private Home homePage;
	//Sign In Screen constructor
	public SignIn(CardLayout cl, JPanel cards) {
		
		//content Panel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238,238,238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        
        GridBagConstraints gbcIcon = new GridBagConstraints();
        GridBagConstraints gbcEmail = new GridBagConstraints();
        GridBagConstraints gbcMotDePasse = new GridBagConstraints();
        GridBagConstraints gbcSignInButton = new GridBagConstraints();
        GridBagConstraints gbcSignUpLink = new GridBagConstraints();
        GridBagConstraints gbcHeader = new GridBagConstraints();
        GridBagConstraints gbcFooter = new GridBagConstraints();
        gbcIcon.fill = GridBagConstraints.BOTH;
        gbcEmail.fill = GridBagConstraints.BOTH;
        gbcMotDePasse.fill = GridBagConstraints.BOTH;
        gbcSignInButton.fill = GridBagConstraints.BOTH;
        gbcSignUpLink.fill = GridBagConstraints.BOTH;
        gbcHeader.fill = GridBagConstraints.BOTH;
        gbcFooter.fill = GridBagConstraints.BOTH;
        
        //header Panel
        headerPane = new JPanel();
        gbcHeader.gridx = 0;
        gbcHeader.gridy = 0;
        gbcHeader.ipady = 50;
        contentPane.add(headerPane, gbcHeader);
        
		//icon Panel
        userIconPanel = new JPanel();
        gbcIcon.gridx = 0;
        gbcIcon.gridy = 1;
        gbcIcon.ipady = 50;
        contentPane.add(userIconPanel, gbcIcon);
        
        //email Panel
        emailPanel = new JPanel();
        gbcEmail.gridx = 0;
        gbcEmail.gridy = 2;  
        contentPane.add(emailPanel, gbcEmail);
        
        //mot de passe Panel
        motDePassePanel = new JPanel();
        gbcMotDePasse.gridx = 0;
        gbcMotDePasse.gridy = 3;  
        contentPane.add(motDePassePanel, gbcMotDePasse);
        
        //sign in button Panel
        signInButtonPanel = new JPanel();
        gbcSignInButton.gridx = 0;
        gbcSignInButton.gridy = 4;  
        gbcSignInButton.ipadx = 200;
        gbcSignInButton.ipady = 50;
        contentPane.add(signInButtonPanel, gbcSignInButton);
        
        //sign up link Panel
        signUpLinkPanel = new JPanel();
        gbcSignUpLink.gridx = 0;
        gbcSignUpLink.gridy = 5; 
        gbcSignUpLink.ipady = 50;
        contentPane.add(signUpLinkPanel, gbcSignUpLink);
        
		//Footer Panel
        footerPane = new JPanel();
        gbcFooter.gridx = 0;
        gbcFooter.gridy = 8;
        contentPane.add(footerPane, gbcFooter);
        
        //user icon label
        userIconLabel = new JLabel();
        userIconPanel.add(userIconLabel);
        
        //user icon
		BufferedImage userImg = null;
		try {
			userImg = ImageIO.read(new File("images/userIcon.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image duserImg = userImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon userIcon = new ImageIcon(duserImg);
		userIconLabel.setIcon(userIcon);
		
		//email input field
		emailInput = new PlaceholderTextField("");
		emailInput.setPlaceholder("Email");
		emailInput.setColumns(25);
		emailInput.setMargin(new Insets(10, 10, 10, 10));
		emailInput.setForeground(new Color(80, 80, 80));
		emailPanel.add(emailInput);
		
		//mot de passe input field
		motDePasseInput = new PlaceholderPasswordField("");
		motDePasseInput.setPlaceholder("Mot de passe");
		motDePasseInput.setColumns(25);
		motDePasseInput.setMargin(new Insets(10, 10, 10, 10));
		emailInput.setForeground(new Color(80, 80, 80));
		motDePassePanel.add(motDePasseInput);
		
		//sign in button
		signInButton = new JButton("Se connecter");
		signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				String email = emailInput.getText();
				String mdp = motDePasseInput.getText();
				
				Utilisateur user = new Utilisateur(email,mdp);
				
				try {
					UtilisateurDAO userDAO= new UtilisateurDAO();
					AdherantDAO adDAO= new AdherantDAO();
					BibliothecaireDAO bibDAO=new BibliothecaireDAO();
					
						if(userDAO.signin(user) == "adherant") {
							//cl.show(cards, "adh home page");
							
							user = adDAO.getAdherant(email, mdp);
							homePage = new Home(user, cl, cards);
					        cards.add(homePage, "home page");
					        cl.show(cards, "home page");
							}
					
						else if(userDAO.signin(user) == "bibliothecaire") {
							user = bibDAO.getBibliothecaire(email, mdp);
							homePage = new Home(user, cl, cards);
					        cards.add(homePage, "home page");
					        cl.show(cards, "home page");
						}else {
							JOptionPane.showMessageDialog(signInButton, "Les données saisies sont incorrectes!!",  
		                            "Erreur de connexion",  
		                            JOptionPane.WARNING_MESSAGE);
						}
					} catch(DAOException ex) {
						System.out.println(ex);
					}
            }
        });
		signInButton.setFont(new Font("Century Gothic", Font.BOLD, 14));
		signInButton.setFocusPainted(false);
		signInButton.setMargin(new Insets(8, 85, 8, 85));
		signInButton.setBackground(new Color(0,120,255));
		signInButton.setForeground(Color.WHITE);
		signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signInButtonPanel.add(signInButton);
		
		//sign up link label
		signUpLinkLabel = new JLabel("Vous n'avez pas encore de compte ? Inscrivez-vous gratuitement");
		signUpLinkLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(cards, "sign up etudiant page");
			}
		});
		signUpLinkLabel.setForeground(new Color(0,60,255));
		Font font = signUpLinkLabel.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		signUpLinkLabel.setFont(font.deriveFont(attributes));
		signUpLinkLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signUpLinkPanel.add(signUpLinkLabel);
		
        //sign in icon
		BufferedImage signInImg = null;
		try {
			signInImg = ImageIO.read(new File("images/signIn.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dsignInImg = signInImg.getScaledInstance(18,18, Image.SCALE_SMOOTH);
		ImageIcon signInIcon = new ImageIcon(dsignInImg);
		signInButton.setIcon(signInIcon);
        
		setBackground(Color.WHITE);
		add(contentPane);
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

}
