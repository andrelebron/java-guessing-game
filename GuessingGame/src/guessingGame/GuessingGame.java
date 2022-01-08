package guessingGame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numGuesses;
	public void checkGuess() { 		//Method used to determine if the user's guess was correct
		String guessText = txtGuess.getText();
		String message = "";
		try {
			numGuesses += 1;
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Try again.";
			else if (guess > theNumber)
				message = guess + " is too high. Try again.";
			else {
				message = guess + " is correct! You win! It only took you " + numGuesses + " tries, good job! Let's play again!";
				newGame();
			}
		} catch(Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {			//Method that determines the random number for the game 
		theNumber = (int)(Math.random() * 100 + 1);
		numGuesses = 0;
	}
	public GuessingGame() {			//Method that sets up the game's GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Andre's Hi Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Andre's Hi Lo Guessing Game"); //Settings for the title label
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 414, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");	//Settings for the instruction label
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 95, 255, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();	//Settings for the text input field
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(267, 92, 44, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");	//Settings for the guess button
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 147, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");	//Settings for 2nd instruction label
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 208, 414, 14);
		getContentPane().add(lblOutput);
	}
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}

}
