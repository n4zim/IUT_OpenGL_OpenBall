package iut.projet.opencake;
 
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;

/**
 * Fenêtre de paramètres
 */
@SuppressWarnings("serial")
public class SettingWindow extends JFrame {
	// Handle sur l'application
	GLApp handle;

	// Création des champs
    JTextField txtSpeed = new JTextField();
    JTextField txtBottom = new JTextField();
    JTextField txtTop = new JTextField();
    JTextField txtNLignes = new JTextField();
    JTextField txtNPtLigne = new JTextField();
    JTextField txtEchelle = new JTextField();
    JCheckBox chckbxWTFmode = new JCheckBox("Activer le mode de déplacement");
		
    /**
	* Construction de la fenêtre 
	* @param glAppHandle
	*/
	public SettingWindow(GLApp glAppHandle) {
		super("Options");
		setResizable(false);
		setAlwaysOnTop(true);
		
		handle = glAppHandle;
	 
		// Définit la taille de la fenêtre
	    setBounds(0, 0, 586, 250);
	    
	    // Action en fermeture (tuer le programme)
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Définition du bouton
	    JButton btnUpdate = new JButton("Mettre à jour");
	    btnUpdate.setBounds(340, 132, 179, 25);
	    txtSpeed.setBounds(175, 48, 113, 20);
	    
	    // Mise à jour des champs
	    txtSpeed.setText(handle.getAnimSpeed().toString());
	    txtBottom.setBounds(457, 89, 77, 20);
	    txtBottom.setText(handle.getBottomWall().toString());
	    txtTop.setBounds(457, 48, 77, 19);
	    txtTop.setText(handle.getTopWall().toString());
	    txtNLignes.setBounds(225, 89, 75, 19);
	    txtNLignes.setText(handle.getNbLignes().toString());
	    txtNPtLigne.setBounds(225, 135, 75, 19);
	    txtNPtLigne.setText(handle.getNbPointsParLigne().toString());
	    txtEchelle.setBounds(175, 181, 85, 20);
	    txtEchelle.setText(handle.getEchelle().toString());
	    
	    // Définition des tailles des champs
	    txtSpeed.setPreferredSize(new Dimension(50, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    txtEchelle.setPreferredSize(new Dimension(30, 20));
	    getContentPane().setLayout(null);
	    
	    // Ajout des champs dans la fenêtre
	    JLabel lblVitesseDeLa = new JLabel("Vitesse de la sphère");
	    lblVitesseDeLa.setBounds(12, 47, 151, 20);
	    getContentPane().add(lblVitesseDeLa);
	    getContentPane().add(txtSpeed);
	    
	    JLabel lblLimiteDuBas = new JLabel("Limite du bas");
	    lblLimiteDuBas.setBounds(346, 91, 107, 15);
	    getContentPane().add(lblLimiteDuBas);
	    getContentPane().add(txtBottom);
	    
	    JLabel lblLimiteDuHaut = new JLabel("Limite du haut");
	    lblLimiteDuHaut.setBounds(346, 50, 113, 15);
	    getContentPane().add(lblLimiteDuHaut);
	    getContentPane().add(txtTop);
	    
	    JLabel lblLignesComposantLa = new JLabel("Lignes composant la sphère");
	    lblLignesComposantLa.setBounds(12, 89, 215, 20);
	    getContentPane().add(lblLignesComposantLa);
	    getContentPane().add(txtNLignes);

	    JLabel lblPointsParLigne = new JLabel("Points par ligne de la sphère");
	    lblPointsParLigne.setBounds(12, 137, 215, 15);
	    getContentPane().add(lblPointsParLigne);
	    getContentPane().add(txtNPtLigne);
	    
	    JLabel lblEchelleDeLa = new JLabel("Echelle de la sphère");
	    lblEchelleDeLa.setBounds(12, 183, 149, 15);
	    getContentPane().add(lblEchelleDeLa);
	    getContentPane().add(txtEchelle);
	    
	    // Action au clic du bouton
	    btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Règle toutes les valeurs de l'application selon les champs
				handle.setAnimSpeed(Float.valueOf(txtSpeed.getText()));
				handle.setBottomWall(Float.valueOf(txtBottom.getText()));
				handle.setTopWall(Float.valueOf(txtTop.getText()));
				handle.setNbLignes(Integer.valueOf(txtNLignes.getText()));
				handle.setNbPointsParLigne(Integer.valueOf(txtNPtLigne.getText()));
				handle.setEchelle(Float.valueOf(txtEchelle.getText()));
			}
		});
	    
	    chckbxWTFmode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handle.setModeDeplacement(chckbxWTFmode.isSelected());
				handle.r = 0;
			}
		});
	    
	    // Ajout du bouton dans la fenêtre
	    getContentPane().add(btnUpdate);
	    
	    JLabel lblContrleDeLa = new JLabel("Contrôle de la sphère");
	    lblContrleDeLa.setFont(new Font("Dialog", Font.BOLD, 20));
	    lblContrleDeLa.setBounds(146, 12, 270, 25);
	    getContentPane().add(lblContrleDeLa);
	    
	    chckbxWTFmode.setBounds(326, 175, 208, 23);
	    getContentPane().add(chckbxWTFmode);
	}
}