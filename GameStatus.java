package BlackJack;

public enum GameStatus {
	WON("You won!!!"), LOST("You lost!!!"), DRAW("Draw!!!"), IN_PROGRES;
	
	private String message;
	GameStatus(String message){
		this.message = message;
	}
	
	GameStatus(){}
	
	private String getMessage(){
		return message;
	}
}
