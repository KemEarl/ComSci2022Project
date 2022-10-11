import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
//
public class GHome extends JFrame implements ActionListener {
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel title = new JLabel("Word Hunt");
	private static JLabel subtitle = new JLabel("So You Think You Can Word?");
	private static JLabel nam = new JLabel("Player Name:");
	private static JTextField player_nam = new JTextField(25);
	private static JButton play = new JButton("Play");
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static JPanel gamepan = new JPanel();
	private static JLabel play_label = new JLabel("Hi, Player");
	private static JLabel play_lvl = new JLabel("Current Level: 0");
	private static JLabel lvl_req = new JLabel("Points Required to Complete Level: 0");
	private static JLabel pts_l = new JLabel("Points: 0");
	private static JLabel att_l = new JLabel("Attempts: 5");
	private static JLabel label = new JLabel("Enter Word Here:");
	private static JTextField user = new JTextField(20);
	private static JButton ok = new JButton("Check");
	private static JLabel note = new JLabel("Words MUST have 3+ Letters. It's about the length and quality of words.");
	private static JTextArea al = new JTextArea("Valid Used Words: \n", 5, 20);
	private static JLabel instruct = new JLabel("Use the letters provided in the [Letter Bank] below to form words.");
	private static JLabel startnote = new JLabel("Start the Level ? : ");
	private static JButton start = new JButton("Start");
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static dictRead ob = new dictRead();
	private static List<String> tried =new ArrayList<String>();
	private static String word;
	private static String [] letters;
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static Player newbie = new Player();
	private static PointSys op = new PointSys();
	private static Leveling stairs = new Leveling();
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static JPanel letpan = new JPanel();
	private static JLabel let_title = new JLabel("Letter Bank");
	private static JLabel let = new JLabel("-");
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
//
	public static void main(String [] args) {
		//Test Attempts
		Build();
		/////////////////////////////////////////////////////////////////////
	}
	//
	public static void Build () {
		//Set Up The Frame
		frame.setSize(650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(panel);

		//Set Up Front Panel
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		///
		title.setBounds(250, 45, 200, 30);
		title.setFont(new Font("Times New Roman", Font.BOLD, 27));
		title.setForeground(Color.WHITE);

		subtitle.setBounds(170, 95, 400, 30);
		subtitle.setFont(new Font("Courier New", Font.ITALIC, 20));
		subtitle.setForeground(Color.WHITE);

		panel.add(title);
		panel.add(subtitle);
		panel.add(gamepan);

		nam.setBounds(80, 250, 150, 50);
		nam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		nam.setForeground(Color.WHITE);
		panel.add(nam);

		player_nam.setBounds(250, 260, 200, 30);
		player_nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(player_nam);

		play.setBounds(250, 350, 200, 50);
		play.addActionListener(new GHome());
		panel.add(play);
		////////////////////////////////////////////////////////////////////////////////
		//Set Up Game Panel
		gamepan.setLayout(null);
		gamepan.setBounds(20, 100, 600, 500);
		gamepan.setBackground(Color.LIGHT_GRAY);

		//Label
		label.setBounds(50, 350, 100, 25);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setForeground(Color.BLACK);
		label.setVisible(false);
		gamepan.add(label);

		//Player Name label
		play_label.setBounds(50, 20, 100, 20);
		play_label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		play_label.setForeground(Color.BLACK);
		gamepan.add(play_label);

		//Player Level label
		play_lvl.setBounds(50, 40, 100, 25);
		play_lvl.setFont(new Font("Times New Roman", Font.BOLD, 12));
		play_lvl.setForeground(Color.BLACK);
		gamepan.add(play_lvl);

		//Level Score Requirement
		lvl_req.setBounds(50, 60, 250, 25);
		lvl_req.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lvl_req.setForeground(Color.BLACK);
		lvl_req.setVisible(false);
		gamepan.add(lvl_req);

		//Input Text Box
		user.setBounds(160, 350, 165, 25);
		user.setFont(new Font("Arial", Font.BOLD, 12));
		user.setEnabled(true);
		user.setVisible(false);
		gamepan.add(user);

		//OK Button
		ok.setBounds(160, 400, 165, 50);
		ok.addActionListener(new GHome());
		ok.setEnabled(true);
		ok.setVisible(false);
		gamepan.add(ok);

		//Note label
		note.setBounds(50, 475, 400, 25);
		note.setFont(new Font("Arial", Font.BOLD, 9));
		note.setForeground(Color.BLACK);
		gamepan.add(note);

		//Screen Showing Used Words
		al.setBounds(350, 125, 175, 325);
		al.setFont(new Font("Arial", Font.BOLD, 9));
		al.append("================================ \n");
		al.setEnabled(false);
		gamepan.add(al);

		pts_l.setBounds(480, 20, 215, 25);
		pts_l.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pts_l.setVisible(false);
		gamepan.add(pts_l);

		att_l.setBounds(480, 40, 215, 25);
		att_l.setFont(new Font("Times New Roman", Font.BOLD, 14));
		att_l.setVisible(false);
		gamepan.add(att_l);

		instruct.setBounds(50, 100, 400, 20);
		instruct.setFont(new Font("Arial", Font.BOLD, 11));
		instruct.setForeground(Color.BLACK);
		instruct.setVisible(false);
		gamepan.add(instruct);

		startnote.setBounds(50, 80, 400, 20);
		startnote.setFont(new Font("Arial", Font.BOLD, 11));
		startnote.setForeground(Color.BLACK);
		gamepan.add(startnote);

		start.setBounds(225, 80, 100, 20);
		start.setFont(new Font("Courier New", Font.BOLD, 12));
		start.addActionListener(new GHome());
		gamepan.add(start);

		gamepan.setVisible(false);

		////////////////////////////////////////////////////////////////////////////////
		//Set Up Letters Panel
		letpan.setLayout(null);
		letpan.setBackground(Color.DARK_GRAY);
		letpan.setBounds(50, 125, 275, 325);
		gamepan.add(letpan);
		
		let_title.setBounds(75, 30, 175, 50);
		let_title.setFont(new Font("Courier New", Font.BOLD, 16));
		let_title.setForeground(Color.WHITE);
		letpan.add(let_title);

		let.setBounds(55, 100, 175, 50);
		let.setFont(new Font("Calibri", Font.BOLD, 20));
		let.setForeground(Color.WHITE);
		letpan.add(let);
	}
	//
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		//OK Button
		if (e.getSource() == ok) {
			word = (user.getText()).toLowerCase();
			newbie.decAttempts();
			att_l.setText("Attempts: "+newbie.getAttempts());

			if (ob.ValidWord(word.toUpperCase(), letters) == false) {
				JOptionPane.showMessageDialog(panel, "You Have Used An Invalid Letter.");
			} 
			else {
				if (tried.contains(word) == true) {
					JOptionPane.showMessageDialog(panel, "You Have Already Used This Word.");
				} 
				else {
					boolean there = ob.checkInDict(word);
					System.out.println(there);
					if (!(there == true)) {
						JOptionPane.showMessageDialog(panel, "The word " + "'" + word + "'" + " does not exist");
					} 
					else {
						newbie.incScore(op.fullAssPts(word));;
						pts_l.setText("Points: "+newbie.getScore());
						al.append(word.toUpperCase()+"\n");
					}
						}
			}


			

			if ((newbie.getAttempts() < 1) && (stairs.CheckProgress(newbie.getScore()) == false)) {
				ok.setVisible(false);
				user.setVisible(false);
				letpan.setBounds(50, 125, 275, 325);
				label.setVisible(false);
				instruct.setVisible(false);
				start.setVisible(true);
				startnote.setVisible(true);
				al.setVisible(false);
				JOptionPane.showMessageDialog(gamepan, "Attempts exhausted. Try Level again.");
				att_l.setVisible(false);
				pts_l.setVisible(true);
				lvl_req.setVisible(false);
				let.setText("-");

				play_lvl.setText("Current Level: "+Player.getLvl());
				newbie.resetScore();
				pts_l.setText("Points: 0");
			}

			user.setText("");

			if (stairs.CheckProgress(newbie.getScore()) == true) {
				newbie.incLvl();

				JOptionPane.showMessageDialog(panel, "Level Complete");
				ok.setVisible(false);
				user.setVisible(false);
				letpan.setBounds(50, 125, 275, 325);
				label.setVisible(false);
				instruct.setVisible(false);
				start.setVisible(true);
				startnote.setVisible(true);
				al.setVisible(false);
				att_l.setVisible(false);
				pts_l.setVisible(true);
				lvl_req.setVisible(false);
				let.setText("-");

				play_lvl.setText("Current Level: "+Player.getLvl());
				newbie.resetScore();
				pts_l.setText("Points: 0");
			}

		}
		//Play Button
		if (e.getSource() == play) {
			int nam_length = (player_nam.getText()).length();
			if (nam_length > 0) {
				newbie.setNaam(player_nam.getText());
				play_label.setText("Hi, "+newbie.getNaam());
				gamepan.setVisible(true);
				play.setVisible(false);
				player_nam.setVisible(false);
				//title.setVisible(false);
				subtitle.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(panel, "Please Enter a Player Name");
			}

		}

		//Start Button
		if (e.getSource() == start) {
			if (JOptionPane.showConfirmDialog(gamepan, "Ready to start?", "Choose Yes or No", JOptionPane.YES_NO_OPTION) == 0) {
				letpan.setBounds(50, 125, 275, 200);
				user.setVisible(true);
				ok.setVisible(true);
				label.setVisible(true);
				instruct.setVisible(true);
				start.setVisible(false);
				startnote.setVisible(false);
				al.setVisible(true);
				att_l.setVisible(true);
				pts_l.setVisible(true);
				lvl_req.setVisible(true);
				play_lvl.setText("Current Level: "+Player.getLvl());

				boolean iffy = stairs.CheckLeveling(Player.getLvl());
				if (iffy == true) {
					letters = stairs.FixedLeveling();
				} 
				else {
					letters = stairs.RandLeveling();
				}

				newbie.setAttempts(stairs.getAtt());
				att_l.setText("Attempts: "+newbie.getAttempts());
				let.setText(Arrays.toString(letters));
				lvl_req.setText("Points Required To Complete The Level: "+stairs.getPtsR());
			}
			else {
				JOptionPane.showMessageDialog(gamepan, "When You're Ready, Press Start to Begin the Level");
			}

			
		}


	}
}
