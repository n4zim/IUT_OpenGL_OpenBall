package iut.projet.opencake;
 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class Window extends JFrame {
	GLApp handle;
    JTextField txtSpeed = new JTextField();
    JTextField txtBottom = new JTextField();
    JTextField txtTop = new JTextField();
    JTextField txtNLignes = new JTextField();
    JTextField txtNPtLigne = new JTextField();
	
	public Window(GLApp glAppHandle) {
		super("Options");
		
		handle = glAppHandle;
	 
	    setBounds(50, 100, 250, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    FlowLayout layout = new FlowLayout();
	    setLayout(layout);
	    
	    JButton btnUpdate = new JButton("update");

	    txtSpeed.setText(glAppHandle.getAnimSpeed().toString());
	    txtBottom.setText(glAppHandle.getBottomWall().toString());
	    txtTop.setText(glAppHandle.getTopWall().toString());
	    txtNLignes.setText(glAppHandle.getNbLignes().toString());
	    txtNPtLigne.setText(glAppHandle.getNbPointsParLigne().toString());
	    
	    txtSpeed.setPreferredSize(new Dimension(50, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    txtBottom.setPreferredSize(new Dimension(30, 20));
	    
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
	    
	    btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				handle.setAnimSpeed(Float.valueOf(txtSpeed.getText()));
				handle.setBottomWall(Float.valueOf(txtBottom.getText()));
				handle.setTopWall(Float.valueOf(txtTop.getText()));
				handle.setNbLignes(Integer.valueOf(txtNLignes.getText()));
				handle.setNbPointsParLigne(Integer.valueOf(txtNLignes.getText()));
			}
		});
	    
	    add(btnUpdate);
	}
	
}