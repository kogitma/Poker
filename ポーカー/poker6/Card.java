
public class Card {
	// フィールド
	private String suitMark = "";
	int no = 0;

	// コンストラクタ
	public Card() {
	}

	public Card(String suitMark, int no) {
		this.suitMark = suitMark;
		this.no = no;
	}

	// メソッド
	public String getSuitMark() {
		return suitMark;
	}

	public int getNo() {
		return no;
	}

	public String toString() {
		String n = switch (no) {
		case 1  -> "A";
		case 11 -> "J";
		case 12 -> "Q";
		case 13 -> "K";
		default -> "" + no;
		};

		return suitMark + n;
	}

}
