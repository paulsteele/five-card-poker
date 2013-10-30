package poker;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

	
	public Window() {
		//create main window
				JFrame window = new JFrame("Texas Hold 'em");
				window.setSize(640, 480);
				window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JPanel full = new JPanel();
				full.setLayout(new BoxLayout(full, BoxLayout.Y_AXIS));
				//create Panels
				JPanel bottom = new JPanel();
				bottom.setSize(640, 192);
				bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
				
				JPanel interaction = new JPanel();
				interaction.setMaximumSize(new Dimension(192, 192));
				interaction.setBackground(Color.green);
				
				JPanel term = new JPanel();
				term.setMaximumSize(new Dimension(448, 192));
				term.setBackground(Color.red);
				
				JPanel middle = new JPanel();
				middle.setSize(640,144);
				middle.setLayout(new BoxLayout(middle, BoxLayout.X_AXIS));
				
				JPanel playercards =new JPanel();
				playercards.setMaximumSize(new Dimension (448, 144));
				playercards.setMinimumSize(new Dimension (448, 144));
				playercards.setBackground(Color.BLUE);
				
				JPanel empty = new JPanel();
				empty.setMaximumSize(new Dimension (192, 144));
				JPanel top  = new JPanel();
				top.setSize(640, 144);
				top.setLayout(new BoxLayout(top,BoxLayout.X_AXIS));
				
				JPanel communitycards = new JPanel();
				communitycards.setMaximumSize(new Dimension(448, 144));
				communitycards.setBackground(Color.cyan);
				
				JPanel cashlist = new JPanel();
				cashlist.setMaximumSize(new Dimension(192,144));
				cashlist.setBackground(Color.magenta);
				//add widgets to panels
				//add sub panels to panels
				top.add(communitycards);
				top.add(cashlist);
				middle.add(playercards);
				middle.add(empty);
				bottom.add(term);
				bottom.add(interaction);
				//add panels to main panel
				full.add(top);
				full.add(middle);
				full.add(bottom);
				//add main panel to window
				window.add(full);
				//display window
				window.setResizable(false);
				window.setVisible(true);
	}
}
