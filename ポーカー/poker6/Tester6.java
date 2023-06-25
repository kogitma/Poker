import java.util.Scanner;

public class Tester6 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		final int HAND = 5;

		Deck d = new Deck(); // デッキ生成
		d.shuffle(); // デッキシャッフル

		// 手札生成
		Hand h = new Hand();
		for (int i = 0; i < HAND; i++) {
			h.add(d.deal());
		}

		// ゲーム開始
		System.out.println("ポーカーゲームを始めます。");

		while (d.getDeck().size() != 0) {
			h.change(); // 並び替え
			System.out.println(" 1  2  3  4  5");
			System.out.print(h + "  ");	// 手札の表示
			h.yaku();	// 役の表示
			System.out.print("捨てるカードを番号で入力(135など)、終了は0:");
			int rm = stdIn.nextInt();

			// 0入力で終了
			if (rm == 0) {
				break;
			}

			// 選択したカードを交換
			while (rm > 0) {
				if (d.getDeck().size() != 0) {// 山札が残っているか
					if (0 < (rm % 10) && (rm % 10 - 1) < h.getCards().size()) {// 1～5以外を排除
						h.getCards().set(rm % 10 - 1, d.deal());
					}
					rm /= 10;
				}
				else {
					break;
				}
			}
		}
		System.out.print("ゲーム終了");

	}

}
