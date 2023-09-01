package jp.game.rpg.hijiri;

public class Draven extends Ally {

	//コンストラクタ
	public Draven() {
		this.name = "ドレイヴン";
		this.hp = 675;
		this.atk = 62;
		alive = true;
	}

	//メソッド

	//選択時
	public void selected() throws Exception {
		System.out.println("「リーグオブドレイヴンへようこそ！」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//攻撃時
	public void attack(Enemy target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「よく見ておけよ」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
		target.hp = (target.hp - this.atk);
		if (target.hp <= 0) {
			target.hp = 0;
			target.alive = false;
		}
		System.out.println(target.name + "に" + this.atk + "のダメージ！");
		java.lang.Thread.sleep(1000);
	}

	//逃走時
	public void run() throws Exception {
		System.out.println(this.name + "は無様に逃げ出した！");
		java.lang.Thread.sleep(1000);
		System.out.println("しかし逃げられなかった！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//登場時
	public void appear() throws Exception {
		System.out.println("「俺は" + this.name + "」");
		System.out.println("「ここでは俺様が主役よ」");
		java.lang.Thread.sleep(1000);
		System.out.println("「殺られたいのはどいつだ？」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//ダメージ時
	public void damage() throws Exception {
		System.out.println("「嫉妬するなよ」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(1000);
		System.out.println("「やはり俺様は最高だな」");
		System.out.println("");
		java.lang.Thread.sleep(1000);

		char[] victory = { 'V', 'I', 'C', 'T', 'O', 'R', 'Y' };

		for (int i = 0; i < victory.length; i++) {
			System.out.print(victory[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

	//敗北時
	public void dead() throws Exception {
		System.out.println(this.name + "は力尽きた。");
		System.out.println("「この俺様が……」");
		System.out.println("");
		java.lang.Thread.sleep(1000);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}
