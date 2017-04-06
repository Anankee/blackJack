package BlackJack;

public enum Card {
	AS(11), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9), EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(
			3), TWO(2);
	private int points;

	Card(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
}
