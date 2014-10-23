package iut.projet.opencake;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Fen�tre de param�tres
 */
public class SettingWindow extends JFrame {
	// Handle sur l'application
	GLApp handle;

	// Cr�ation des champs
    JTextField txtSpeed = new JTextField();
    JTextField txtBottom = new JTextField();
    JTextField txtTop = new JTextField();
    JTextField txtNLignes = new JTextField();
    JTextField txtNPtLigne = new JTextField();
    JTextField txtEchelle = new JTextField();
		
    /**
	* Construction de la fen�tre 
	* @param glAppHandle
	*/
	public SettingWindow(GLApp glAppHandle) {
		super("Options");
		
		handle = glAppHandle;
	 
		// D�finit la taille de la fen�tre
	    setBounds(0, 0, 600, 80);
	    
	    // Action en fermeture (tuer le programme)
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Layout pour l'affichage des objets
	    FlowLayout layout = new FlowLayout();
	    setLayout(layout);
	    
	    // D�finition du bouton
	    JButton btnUpdate = new JButton("update");
	    
	    // Mise � jour des champs
	    txtSpeed.setText(handle.getAnimSpeed().toString());
	    txtBottom.setText(handle.getBottomWall().toString());
	    txtTop.setText(handle.getTopWall().toString());
	    txtNLignes.setText(handle.getNbLignes().toString());
	    txtNPtLigne.setText(handle.getNbPointsParLigne().toString());
	    txtEchelle.setText(handle.getEchelle().toString());
	    
	    // D�finition des tailles des champs
	    txtSpeed.setPreferredSize(new Dimension(50, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    txtEchelle.setPreferredSize(new Dimension(30, 20));
	    
	    // Ajout des champs dans la fen�tre
	    add(new JLabel("speed"));
	    add(txtSpeed);
	    
	    add(new JLabel("bottom"));
	    add(txtBottom);
	    
	    add(new JLabel("top"));
	    add(txtTop);
	    
	    add(new JLabel("lignes"));
	    add(txtNLignes);

	    add(new JLabel("pts par ligne"));
	    add(txtNPtLigne);
	    
	    add(new JLabel("echelle"));
	    add(txtEchelle);
	    
	    // Action au clic du bouton
	    btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// R�gle toutes les valeurs de l'application selon les champs
				handle.setAnimSpeed(Float.valueOf(txtSpeed.getText()));
				handle.setBottomWall(Float.valueOf(txtBottom.getText()));
				handle.setTopWall(Float.valueOf(txtTop.getText()));
				handle.setNbLignes(Integer.valueOf(txtNLignes.getText()));
				handle.setNbPointsParLigne(Integer.valueOf(txtNPtLigne.getText()));
				handle.setEchelle(Float.valueOf(txtEchelle.getText()));
			}
		});
	    
	    // Ajout du bouton dans la fen�tre
	    add(btnUpdate);
	}
	
}