package jp.game.rpg.hijiri;

public class Braum extends Ally {

	//コンストラクタ
	public Braum() {
		this.name = "ブラウム";
		this.MAX_HP = 610;
		this.hp = MAX_HP;
		this.atk = 55;
		this.armor = 47;
	}
	
	//メソッド

	//攻撃時
	public void attack(Enemy target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「もう説教だけでは済まんぞ！」");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//逃走時
	public void run() throws Exception {
		System.out.println(this.name + "は無様に逃げ出した！");
		java.lang.Thread.sleep(200);
		System.out.println("しかし逃げられなかった！");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//登場時
	public void appear() throws Exception {
		System.out.println("「心こそ、最強の筋肉よ！」");
		java.lang.Thread.sleep(100);
		System.out.println("「おや、お客さんかね？」");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//ダメージ時
	//Allyクラスを継承

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(200);
		System.out.println("「ほら、あっという間だったろ？」");
		System.out.println("");
		java.lang.Thread.sleep(200);

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
		java.lang.Thread.sleep(200);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}
