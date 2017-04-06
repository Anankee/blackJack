package BlackJack;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	private ArrayList<Card> playerCards;
	private Random randm = new Random();
	private int score;

	public Player() {
		if (playerCards == null) {
			playerCards = new ArrayList<Card>();
		}
	}

	public void generateCard(int number) {
		for (int i = 0; i < number; i++){
		Card card = Game.getDeck().getCard(randm.nextInt(Game.getDeck().getCards().length));
		Game.getDeck().removeCard(card);
		Game.getDeck().checkDeck();
		playerCards.add(card);
		score += card.getPoints();
		}
	}

	public GameStatus checkScore() {
		if (score > 21) {
			return GameStatus.LOST;
		} else if (score == 21) {
			return GameStatus.WON;
		} else {
			return GameStatus.IN_PROGRES;
		}
	}

	public ArrayList<Card> getPlayerCard() {
		return playerCards;
	}

	public int getScore() {
		return score;
	}

	public void resetScore() {
		score = 0;
		playerCards.removeAll(playerCards);
	}
}
