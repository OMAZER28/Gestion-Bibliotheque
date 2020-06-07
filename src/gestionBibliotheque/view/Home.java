package gestionBibliotheque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gestionBibliotheque.model.utilisateurs.Adherant;
import gestionBibliotheque.model.utilisateurs.Bibliothecaire;
import gestionBibliotheque.model.utilisateurs.Utilisateur;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Home extends JPanel {
	
	
	
	//Components attributes
	private static final long serialVersionUID = 1L;
	private boolean livreRouteActive;
	private boolean revueRouteActive;
	private boolean empruntRouteActive;
	private boolean reservationRouteActive;
	private boolean gestionRouteActive;
	private boolean profileRouteActive;
	private DocRoute livreRoute;
	private DocRoute revueRoute;
	private EmpruntRoute empruntRoute;
	private ReservationRoute reservationRoute;
	private GestionRoute gestionRoute;
	private ProfileRoute profileRoute;
	private JLabel livre_route;
	private JLabel revue_route;
	private JLabel emprunt_route;
	private JLabel gestion_route;
	private JLabel reservation_route;
	private JLabel profil_route;
	private JPanel menuPanel;
	private JPanel contentPane;
	private JPanel logoPanel;
	private JPanel routesPanel;
	private JPanel routesPanel_header;
	private JPanel routesPanel_empty_space;
	private JPanel routesPanel_footer;
	
	
	//Sign In Screen constructor
	public Home(Utilisateur user, CardLayout cl, JPanel cards) {
		setLayout(new BorderLayout(0, 0));
		
		
		
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout(0, 0));
		add(menuPanel, BorderLayout.WEST);
		
		
		
		
		livreRoute = new DocRoute(user, "livre");
		revueRoute = new DocRoute(user, "revue");
		empruntRoute  = new EmpruntRoute();
		gestionRoute = new GestionRoute();
		reservationRoute = new ReservationRoute();
		profileRoute = new ProfileRoute();
		contentPane = new JPanel();
		CardLayout cardlayout = new CardLayout();
		contentPane.setLayout(cardlayout);
		contentPane.add(livreRoute, "livre page");
		contentPane.add(revueRoute, "revue page");
		contentPane.add(empruntRoute, "emprunt page");
		contentPane.add(reservationRoute, "reservation page");
		contentPane.add(gestionRoute, "gestion page");
		contentPane.add(profileRoute, "profile page");
		add(contentPane, BorderLayout.CENTER);
		
		
		
		
        //logo icon
		BufferedImage logoImg = null;
		try {
			logoImg = ImageIO.read(new File("images/logo.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dlogoImg = logoImg.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(dlogoImg);
		
		
		
		
		
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setLayout(new FlowLayout());
		menuPanel.add(logoPanel, BorderLayout.NORTH);
		
		GridLayout glheader = new GridLayout(3,1);
		glheader.setVgap(25);
		GridLayout glfooter = new GridLayout(2,1);
		glfooter.setVgap(25);
		
		routesPanel = new JPanel();
		routesPanel.setBackground(Color.WHITE);
		menuPanel.add(routesPanel, BorderLayout.CENTER);
		routesPanel.setLayout(new BorderLayout(0, 0));
		
		routesPanel_header = new JPanel();
		routesPanel_header.setBackground(Color.WHITE);
		routesPanel.add(routesPanel_header, BorderLayout.NORTH);
		routesPanel_header.setLayout(glheader);
		
		
		
		routesPanel_empty_space = new JPanel();
		routesPanel_empty_space.setBackground(Color.WHITE);
		routesPanel.add(routesPanel_empty_space, BorderLayout.CENTER);

		
		
		routesPanel_footer = new JPanel();
		routesPanel_footer.setBackground(Color.WHITE);
		routesPanel.add(routesPanel_footer, BorderLayout.SOUTH);
		routesPanel_footer.setLayout(glfooter);
		
		
		
		
		livre_route = new JLabel("Livres");
		livre_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setLivreRouteStyle("images/livre_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isLivreRouteActive()) 
					setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setLivreRouteActive(true);
				cardlayout.show(contentPane, "livre page");
				setLivreRouteStyle("images/livre_b.png", new Color(0,120,255));
				setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
				setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
				setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
				setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
				setReservationRouteStyle("images/reservation_g.png", new Color(73,73,73));
				setRevueRouteActive(false);
				setEmpruntRouteActive(false);
				setGestionRouteActive(false);
				setProfileRouteActive(false);
				setReservationRouteActive(false);
			}
		});
		livre_route.setBorder(new EmptyBorder(0,40,10,10));
		livre_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));
		livre_route.setIconTextGap(20);
		livre_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
		
		
		
		
		
		
		
		
		
		revue_route = new JLabel("Revues");
		revue_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setRevueRouteStyle("images/revue_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isRevueRouteActive())
					setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setRevueRouteActive(true);
				cardlayout.show(contentPane, "revue page");
				setRevueRouteStyle("images/revue_b.png", new Color(0,120,255));
				setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
				setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
				setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
				setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
				setReservationRouteStyle("images/reservation_g.png", new Color(73,73,73));
				setLivreRouteActive(false);
				setEmpruntRouteActive(false);
				setGestionRouteActive(false);
				setProfileRouteActive(false);
				setReservationRouteActive(false);
			}
		});
		revue_route.setBorder(new EmptyBorder(0,40,10,10));
		revue_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));
		revue_route.setIconTextGap(20);
		revue_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
		
		
		
		
		emprunt_route = new JLabel("Emprunt");
		emprunt_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setEmpruntRouteStyle("images/emprunt_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isEmpruntRouteActive()) 
					setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setEmpruntRouteActive(true);
				cardlayout.show(contentPane, "emprunt page");
				setEmpruntRouteStyle("images/emprunt_b.png", new Color(0,120,255));
				setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
				setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
				setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
				setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
				setLivreRouteActive(false);
				setRevueRouteActive(false);
				setGestionRouteActive(false);
				setProfileRouteActive(false);
			}
		});
		emprunt_route.setBorder(new EmptyBorder(0,40,10,10));
		emprunt_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));	
		emprunt_route.setIconTextGap(20);
		emprunt_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
		
		
		
		
		
		reservation_route = new JLabel("Mes Réservations");
		reservation_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setReservationRouteStyle("images/reservation_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isReservationRouteActive()) 
					setReservationRouteStyle("images/reservation_g.png", new Color(73,73,73));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setReservationRouteActive(true);
				cardlayout.show(contentPane, "reservation page");
				setReservationRouteStyle("images/reservation_b.png", new Color(0,120,255));
				setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
				setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
				setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
				setLivreRouteActive(false);
				setRevueRouteActive(false);
				setProfileRouteActive(false);
			}
		});
		reservation_route.setBorder(new EmptyBorder(0,40,10,10));
		reservation_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));	
		reservation_route.setIconTextGap(20);
		reservation_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setReservationRouteStyle("images/reservation_g.png", new Color(73,73,73));
		
		
		
		
		
		
		gestion_route = new JLabel("Gestion utilisateurs");
		gestion_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setGestionRouteStyle("images/gestion_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isGestionRouteActive()) {
					setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setGestionRouteActive(true);
				cardlayout.show(contentPane, "gestion page");
				setGestionRouteStyle("images/gestion_b.png", new Color(0,120,255));
				setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
				setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
				setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
				setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
				setLivreRouteActive(false);
				setRevueRouteActive(false);
				setEmpruntRouteActive(false);
				setProfileRouteActive(false);
			}
		});
		gestion_route.setBorder(new EmptyBorder(0,40,10,10));
		gestion_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));
		gestion_route.setIconTextGap(20);
		gestion_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
		
		
		
		
		
		profil_route = new JLabel(user.getNom());
		profil_route.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setProfileRouteStyle("images/user_b.png", new Color(0,120,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!isProfileRouteActive()) 
					setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setProfileRouteActive(true);
				cardlayout.show(contentPane, "profile page");
				setProfileRouteStyle("images/user_b.png", new Color(0,120,255));
				setLivreRouteStyle("images/livre_g.png", new Color(73,73,73));
				setRevueRouteStyle("images/revue_g.png", new Color(73,73,73));
				setEmpruntRouteStyle("images/emprunt_g.png", new Color(73,73,73));
				setGestionRouteStyle("images/gestion_g.png", new Color(73,73,73));
				setReservationRouteStyle("images/reservation_g.png", new Color(73,73,73));
				setLivreRouteActive(false);
				setRevueRouteActive(false);
				setEmpruntRouteActive(false);
				setGestionRouteActive(false);
				setReservationRouteActive(false);
			}
		});
		profil_route.setBorder(new EmptyBorder(0,40,10,10));
		profil_route.setFont(new Font("Titillium Web Light", Font.PLAIN, 18));
		profil_route.setIconTextGap(20);
		profil_route.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setProfileRouteStyle("images/user_g.png", new Color(73,73,73));
		
		
		
		
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setBorder(new EmptyBorder(0,30,10,10));	
		logoLabel.setIcon(logoIcon);
		logoPanel.add(logoLabel);
		
		
		
		
		JLabel logoName = new JLabel("My Biblio");
		logoName.setFont(new Font("Titillium Web Light", Font.PLAIN, 20));
		logoName.setForeground(new Color(0,120,255));
		logoName.setBorder(new EmptyBorder(30,0,40,60));	
		logoPanel.add(logoName);
		
		
		
		
		routesPanel_header.add(livre_route);
		routesPanel_header.add(revue_route);
		if(user instanceof Adherant) {
			routesPanel_header.add(reservation_route);
		}
		else if(user instanceof Bibliothecaire) {
			routesPanel_header.add(emprunt_route);
			routesPanel_footer.add(gestion_route);
		}
		routesPanel_footer.add(profil_route);
	}
	
	public boolean isLivreRouteActive() {
		return livreRouteActive;
	}
	public void setLivreRouteActive(boolean livreRouteActive) {
		this.livreRouteActive = livreRouteActive;
	}
	public boolean isRevueRouteActive() {
		return revueRouteActive;
	}
	public void setRevueRouteActive(boolean revueRouteActive) {
		this.revueRouteActive = revueRouteActive;
	}
	public boolean isEmpruntRouteActive() {
		return empruntRouteActive;
	}
	public void setEmpruntRouteActive(boolean empruntRouteActive) {
		this.empruntRouteActive = empruntRouteActive;
	}
	public boolean isReservationRouteActive() {
		return reservationRouteActive;
	}
	public void setReservationRouteActive(boolean reservationRouteActive) {
		this.reservationRouteActive = reservationRouteActive;
	}
	public boolean isGestionRouteActive() {
		return gestionRouteActive;
	}
	public void setGestionRouteActive(boolean gestionRouteActive) {
		this.gestionRouteActive = gestionRouteActive;
	}
	public boolean isProfileRouteActive() {
		return profileRouteActive;
	}
	public void setProfileRouteActive(boolean profileRouteActive) {
		this.profileRouteActive = profileRouteActive;
	}
	

	public void setLivreRouteStyle(String livreRouteImage, Color livreRouteLabelFg) {
		BufferedImage livreImage = null;
		try {
			livreImage = ImageIO.read(new File(livreRouteImage));
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
		Image dlivreImage = livreImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon livreIcon = new ImageIcon(dlivreImage);
		livre_route.setIcon(livreIcon);
		livre_route.setForeground(livreRouteLabelFg);
	}
	public void setRevueRouteStyle(String revueRouteImage, Color revueRouteLabelFg) {
		BufferedImage revueImage = null;
		try {
			revueImage = ImageIO.read(new File(revueRouteImage));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image drevueImage = revueImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon revueIcon = new ImageIcon(drevueImage);
		revue_route.setIcon(revueIcon);
		revue_route.setForeground(revueRouteLabelFg);
	}
	public void setEmpruntRouteStyle(String empruntRouteImage, Color empruntRouteLabelFg) {
		BufferedImage empruntImage = null;
		try {
			empruntImage = ImageIO.read(new File(empruntRouteImage));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dempruntImage = empruntImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon empruntIcon = new ImageIcon(dempruntImage);
		emprunt_route.setIcon(empruntIcon);
		emprunt_route.setForeground(empruntRouteLabelFg);
	}
	public void setReservationRouteStyle(String reservationRouteImage, Color reservationRouteLabelFg) {
		BufferedImage reservationImage = null;
		try {
			reservationImage = ImageIO.read(new File(reservationRouteImage));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dreservationImage = reservationImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon reservationIcon = new ImageIcon(dreservationImage);
		reservation_route.setIcon(reservationIcon);
		reservation_route.setForeground(reservationRouteLabelFg);
	}
	public void setGestionRouteStyle(String gestionRouteImage, Color gestionRouteLabelFg) {
		BufferedImage gestionImage = null;
		try {
			gestionImage = ImageIO.read(new File(gestionRouteImage));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dgestionImage = gestionImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon gestionIcon = new ImageIcon(dgestionImage);
		gestion_route.setIcon(gestionIcon);
		gestion_route.setForeground(gestionRouteLabelFg);
	}
	public void setProfileRouteStyle(String profileRouteImage, Color profileRouteLabelFg) {
		BufferedImage userImage = null;
		try {
			userImage = ImageIO.read(new File(profileRouteImage));
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
		Image duserImage = userImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon userIcon = new ImageIcon(duserImage);
		profil_route.setIcon(userIcon);
		profil_route.setForeground(profileRouteLabelFg);
	}
}
