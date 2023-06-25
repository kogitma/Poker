import java.util.ArrayList;

public class Hand {
	// フィールド
	private ArrayList<Card> cards = null;

	// コンストラクタ
	public Hand() {
		cards = new ArrayList<Card>();
	}

	public Hand(ArrayList<Card> cards) {
		this.cards = cards;
	}

	// メソッド

	// ゲッタ
	public ArrayList<Card> getCards() {
		return cards;
	}

	// カードの追加
	public void add(Card card) {
		cards.add(card);
	}

	// 数字を昇順に並び替え
	public void change() {
		for (int i = 0; i < (cards.size() - 1); i++) {
			for (int j = (i + 1); j < cards.size(); j++) {
				if (cards.get(i).getNo() > cards.get(j).getNo()) {
					Card tmp = cards.get(i);
					cards.set(i, cards.get(j));
					cards.set(j, tmp);
				}
			}
		}
	}

	// toStringメソッド
	public String toString() {
		String str = "";
		for (Card card : cards) {
			str += (card + " ");
		}
		return str;
	}

	// 役の判定
	public void yaku() {
		// 継続判定(フラッシュ、ストレート)
		boolean fl = false, st = false;
		// ペアが1種見つかるとpr1、2種見つかるとpr2がtrueになる
		boolean pr1 = false, pr2 = false;
		// ペアの枚数
		int p1 = 1, p2 = 1;

		// フラッシュの判定
		for (int i = 0; i < (cards.size() - 1); i++) {
			if (cards.get(i).getSuitMark() == cards.get(i + 1).getSuitMark()) {
				fl = true;
			} else {
				fl = false;
				break;
			}
		}

		// ストレートの判定
		for (int i = 0; i < (cards.size() - 1); i++) {
			if ((cards.get(i).getNo() - cards.get(i + 1).getNo()) == -1
					|| cards.get(i).getNo() == 1 && cards.get(i + 1).getNo() == 10) {
				st = true;
			} else {
				st = false;
				break;
			}
		}

		// ペアの判定
		for (int i = 0; i < (cards.size() - 1); i++) {
			if (cards.get(i).getNo() == cards.get(i + 1).getNo()) {
				pr1 = true;
				p1++;
			} else if (pr1 == true && pr2 == false) {
				p2 = p1;
				p1 = 1;
				pr2 = true;
			}
		}

		// 最終判定
		if (fl == true && st == true && cards.get(0).getNo() == 1 && cards.get(1).getNo() == 10) {
			System.out.println("ROYAL_STRAIGHT_FLUSH");
		} else if (fl == true && st == true) {
			System.out.println("STRAIGHT_FLUSH");
		} else if (fl == true) {
			System.out.println("FLUSH");
		} else if (st == true) {
			System.out.println("STRAIGHT");
		} else if (p1 == 4 || p2 == 4) {
			System.out.println("FOUR_CARD");
		} else if ((p1 == 2 && p2 == 3) || (p1 == 3 && p2 == 2)) {
			System.out.println("FULL_HOUSE");
		} else if (p1 == 3 || p2 == 3) {
			System.out.println("THREE_CARD");
		} else if (p1 == 2 && p2 == 2) {
			System.out.println("TWO_PAIR");
		} else if (p1 == 2 || p2 == 2) {
			System.out.println("ONE_PAIR");
		} else {
			System.out.println();
		}

	}
}
