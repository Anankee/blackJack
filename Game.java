package BlackJack;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Deck deck = new Deck();
	private Random random = new Random();
	private Scanner scanner = new Scanner(System.in);
	private int playerScore, casinoScore;
	private String answer = "";
	private boolean playerCheck, casinoCheck, endGame;

	public void gameStart() {
		deck.fillDeck();
		while (endGame == false) {
			System.out.println("Game start...");
			System.out.println("Croupier first card: " + generateCard(PlayerOrCasino.CASINO));
			System.out.println("Your cards: " + generateCard(PlayerOrCasino.PLAYER) + ", "
					+ generateCard(PlayerOrCasino.PLAYER) + ".");
			System.out.println("Your score: " + playerScore);
			while (playerCheck == false) {
				if (checkPlayerScore() == -1) {
					System.out.println("You lost!!!");
					casinoCheck = true;
					break;
				} else if (checkPlayerScore() == 1) {
					System.out.println("You won!!!");
					casinoCheck = true;
					break;
				} else {
					System.out.println("Do You want next card? Type \"yes \" or \"no\"");
					answer = scanner.next().toLowerCase();
					if (answer.equals("no")) {
						break;
					} else if (answer.equals("yes")) {
						System.out.println("Your next card is: " + generateCard(PlayerOrCasino.PLAYER)
								+ "\nYour score: " + playerScore);
					} else {
						System.out.println("Wrong answer. Please type again.");
					}
				}
			}
			if (casinoCheck == false) {
				System.out.println("Croupier card: " + generateCard(PlayerOrCasino.CASINO));
				System.out.println("His score: " + casinoScore);
			}
			while (casinoCheck == false) {
				if (checkCasinoScore() == -1) {
					System.out.println("You won!!!");
					
					break;
				} else if (checkCasinoScore() == 1) {
					System.out.println("You lost!!!");
					
					break;
				} else if (casinoScore > 15) {
					if (casinoScore > playerScore) {
						System.out.println("Casino won!!!");
						break;
					} else if (casinoScore == playerScore){
						System.out.println("Draw!!!");
						break;
					} else {
						System.out.println("You won!!!");
						break;
					}
				} else if (casinoScore <= 15) {
					System.out.println("Casino next card: " + generateCard(PlayerOrCasino.CASINO));
					System.out.println("His score: " + casinoScore);
				}
			}

			System.out.println("Do you want to play again? Type \"yes\" or \"no\".");
			answer = scanner.next().toLowerCase();
			if (answer.equals("no")){
				endGame = true;
			}
			reset();
		}
	}
	
	private void playerTurn(){
		
	}
	
	private void reset(){
		casinoCheck = false;
		playerCheck = false;
		playerScore = 0;
		casinoScore = 0;
	}

	private int checkPlayerScore() {
		if (playerScore > 21) {
			return -1;
		} else if (playerScore == 21) {
			return 1;
		} else {
			return 0;
		}
	}

	private int checkCasinoScore() {
		if (casinoScore > 21) {
			return -1;
		} else if (casinoScore == 21) {
			return 1;
		} else {
			return 0;
		}
	}

	private int playerScore(Cards card) {
		playerScore += card.getPoints();
		return playerScore;
	}

	private int casinoScore(Cards card) {
		casinoScore += card.getPoints();
		return casinoScore;
	}

	private Cards generateCard(PlayerOrCasino who) {
		Cards card = deck.getCard(random.nextInt(deck.getCards().length));
		deck.removeCard(card);
		deck.checkDeck();
		if (who == PlayerOrCasino.PLAYER) {
			playerScore(card);
		} else {
			casinoScore(card);
		}
		return card;
	}
}
