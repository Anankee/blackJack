package BlackJack;

import java.util.Scanner;

public class Game {

	private static Deck deck = new Deck();
	private Scanner scanner = new Scanner(System.in);
	private String answer = "";
	private boolean playerCheck, casinoCheck, endGame;
	private Player player;
	private Player casino;
	private int c, p;

	public void gameStart() {
		player = new Player();
		casino = new Player();
		deck.fillDeck();
		while (endGame == false) {
			System.out.println("Game start...");
			casino.generateCard(1);
			System.out.println("Croupier first card: " + casino.getPlayerCard().get(c++));
			player.generateCard(2);
			System.out.println(
					"Your cards: " + player.getPlayerCard().get(p++) + ", " + player.getPlayerCard().get(p++) + ".");
			System.out.println("Your score: " + player.getScore());
			while (playerCheck == false) {
				if (player.checkScore() == GameStatus.LOST) {
					System.out.println("You lost!!!");
					casinoCheck = true;
					break;
				} else if (player.checkScore() == GameStatus.WON) {
					System.out.println("You won!!!");
					casinoCheck = true;
					break;
				} else {
					System.out.println("Do You want next card? Type \"yes \" or \"no\"");
					answer = scanner.next().toLowerCase();
					if (answer.equals("no")) {
						break;
					} else if (answer.equals("yes")) {
						player.generateCard(1);
						System.out.println("Your next card is: " + player.getPlayerCard().get(p++) + "\nYour score: "
								+ player.getScore());
					} else {
						System.out.println("Wrong answer. Please type again.");
					}
				}
			}
			if (casinoCheck == false) {
				casino.generateCard(1);
				System.out.println("Croupier card: " + casino.getPlayerCard().get(c++));
				System.out.println("His score: " + casino.getScore());
			}
			while (casinoCheck == false) {
				if (casino.checkScore() == GameStatus.LOST) {
					System.out.println("You won!!!");

					break;
				} else if (casino.checkScore() == GameStatus.WON) {
					System.out.println("You lost!!!");
					break;
				} else if (casino.getScore() > 16) {
					if (casino.getScore() > player.getScore()) {
						System.out.println("Casino won!!!");
						break;
					} else if (casino.getScore() == player.getScore()) {
						System.out.println("Draw!!!");
						break;
					} else {
						System.out.println("You won!!!");
						break;
					}
				} else if (casino.getScore() <= 16) {
					casino.generateCard(1);
					System.out.println("Croupier next card: " + casino.getPlayerCard().get(c++));
					System.out.println("His score: " + casino.getScore());
				}
			}

			System.out.println("Do you want to play again? Type \"yes\" or \"no\".");
			answer = scanner.next().toLowerCase();
			if (answer.equals("no")) {
				endGame = true;
			}
			reset();
		}
	}

	public static Deck getDeck() {
		return deck;
	}

	public void reset() {
		casinoCheck = false;
		playerCheck = false;
		c = 0;
		p = 0;
		player.resetScore();
		casino.resetScore();
	}
}
