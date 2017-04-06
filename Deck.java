package BlackJack;

import java.util.HashMap;

public class Deck {

	private HashMap<Card, Integer> cardsNumber = new HashMap<>();
	private Card[] deckOfCards;

	public Deck() {

	}

	public void fillDeck() {
		deckOfCards = Card.values();
		for (Card x : deckOfCards) {
			cardsNumber.put(x, 4);
		}
	}

	public HashMap<Card, Integer> getDeck() {
		return cardsNumber;
	}

	public void removeCard(Card card) {
		if (cardsNumber.get(card) == 1) {
			cardsNumber.remove(card);
		} else
			cardsNumber.replace(card, cardsNumber.get(card) - 1);
	}

	public Card[] getCards() {
		return deckOfCards;
	}

	public Card getCard(int number) {
		return deckOfCards[number];
	}

	public void checkDeck() {
		if (cardsNumber.isEmpty()) {
			fillDeck();
		}
	}
}
