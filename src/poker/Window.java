package poker;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class Window {

	JTextArea community;
	JTextArea score;
	JTextArea playcards;
	JTextArea terminal;
	JTextField bidfield;
	JButton bid;
	JButton call;
	JButton fold;
	
	
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
				interaction.setLayout(new BoxLayout(interaction, BoxLayout.Y_AXIS));
				
				JPanel middle = new JPanel();
				middle.setSize(640,144);
				middle.setLayout(new BoxLayout(middle, BoxLayout.X_AXIS));
				
				JPanel empty = new JPanel();
				empty.setMaximumSize(new Dimension (192, 144));
				JPanel top  = new JPanel();
				top.setSize(640, 144);
				top.setLayout(new BoxLayout(top,BoxLayout.X_AXIS));
							
				//initialize the text areas
				community = new JTextArea();
				community.setMaximumSize(new Dimension(448, 144));
				community.setLineWrap(true);
				//community.setEditable(false);
				community.setBorder(BorderFactory.createLineBorder(Color.black, 5));
				score = new JTextArea();
				score.setMaximumSize(new Dimension(192,144));
				score.setLineWrap(true);
				//score.setEditable(false);
				score.setBorder(BorderFactory.createLineBorder(Color.black, 5));
				playcards = new JTextArea(); 
				playcards.setMaximumSize(new Dimension (448, 144));
				playcards.setLineWrap(true);
				//playcards.setEditable(false);
				playcards.setBorder(BorderFactory.createLineBorder(Color.black, 5));
				terminal = new JTextArea();
				terminal.setMaximumSize(new Dimension(448, 192));
				terminal.setLineWrap(true);
				//terminal.setEditable(false);
				terminal.setBorder(BorderFactory.createLineBorder(Color.black, 5));
				bidfield = new JTextField();
				bidfield.setMaximumSize(new Dimension(192,32));
				bid = new JButton("Bid");
				call = new JButton("Call");
				fold = new JButton("Fold");
				
				//add widgets to panels
				interaction.add(bidfield);
				interaction.add(bid);
				interaction.add(call);
				interaction.add(fold);
				top.add(community);
				top.add(score);
				middle.add(playcards);
				middle.add(empty);
				bottom.add(terminal);
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
