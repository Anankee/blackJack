package BlackJack;

import java.util.HashMap;

public class Deck {

	private HashMap<Cards, Integer> cardsNumber = new HashMap<>();
	private Cards[] deckOfCards;

	public Deck() {

	}

	public void fillDeck() {
		deckOfCards = Cards.values();
		for (Cards x : deckOfCards) {
			cardsNumber.put(x, 4);
		}
	}

	public HashMap<Cards, Integer> getDeck() {
		return cardsNumber;
	}

	public void removeCard(Cards card) {
		if (cardsNumber.get(card) == 1) {
			cardsNumber.remove(card);
		} else
			cardsNumber.replace(card, cardsNumber.get(card) - 1);
	}

	public Cards[] getCards() {
		return deckOfCards;
	}

	public Cards getCard(int number) {
		return deckOfCards[number];
	}

	public void checkDeck() {
		if (cardsNumber.isEmpty()) {
			fillDeck();
		}
	}
}
