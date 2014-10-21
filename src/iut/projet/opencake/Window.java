package iut.projet.opencake;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class Window extends JFrame {
	public Window(GLApp glAppHandle) {
		super("Options");
	 
	    setBounds(50, 100, 250, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JButton btn = new JButton("update");
	    JLabel lbl = new JLabel("speed");
	    JTextField txt = new JTextField();
	    
	    add(lbl);
	    add(txt);
	    add(btn);
	}
	
}