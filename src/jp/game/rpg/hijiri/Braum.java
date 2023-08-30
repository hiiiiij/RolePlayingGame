package jp.game.rpg.hijiri;

public class Braum extends Ally {

	String name = "ブラウム";
	int hp = 610;
	int atk = 55;

	//コンストラクタ
	public Braum() {
	}
	
	public Braum(String name, int hp, int atk) {
		super(name, hp, atk);
	}

	//メソッド

	//選択時
	public void selected() throws Exception {
		System.out.println("「心こそ、最強の筋肉よ！」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//攻撃時
	public void attack() throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「もう説教だけでは済まんぞ！」");
		System.out.println("");
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
		System.out.println("「凍った心も、あったかい笑顔で溶かせるもんよ！」");
		java.lang.Thread.sleep(1000);
		System.out.println("「おや、お客さんかね？」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//ダメージ時
	public void damage(int dmg) throws Exception {
		System.out.println("「負けるな！……これ、母ちゃんの口癖な」");
		System.out.println("");
		this.hp = this.hp - dmg;
		java.lang.Thread.sleep(1000);
	}

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(1000);
		System.out.println("「ほら、あっという間だったろ？」");
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
		System.out.println("「グゥッ、ウオォ……。」");
		System.out.println("");
		java.lang.Thread.sleep(1000);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}
