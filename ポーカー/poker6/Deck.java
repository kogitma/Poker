import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	final int SUIT = 4;
	final int NO = 13;

	// フィールド
	private ArrayList<Card> deck = new ArrayList<>();
	{

		for (int i = 0; i < SUIT; i++) {
			String s = switch (i) {
			case 0 -> "♠";
			case 1 -> "♣";
			case 2 -> "♦";
			case 3 -> "♥";
			default -> "";
			};
			for (int j = 0; j < NO; j++) {
				deck.add(new Card(s, (j + 1)));
			}
		}
	}

	// メソッド
	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card deal() {
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}
	
	public ArrayList<Card> getDeck(){
		return deck;
	}
}
