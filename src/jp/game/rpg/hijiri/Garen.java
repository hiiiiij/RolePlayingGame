package jp.game.rpg.hijiri;

public class Garen extends Ally {

	//コンストラクタ
	public Garen() {
		this.name = "ガレン";
		this.MAX_HP = 690;
		this.hp = MAX_HP;
		this.atk = 69;
		this.armor = 38;
	}

	//メソッド

	//攻撃時
	public void attack(Enemy target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「デマーシアアアア！！」");
		java.lang.Thread.sleep(200);
	}

	//スキル
	public void skill(Enemy target) throws Exception {
		System.out.println(this.name + "の断固たる一撃！");
		System.out.println("「デマーシアアアア！！」");
		java.lang.Thread.sleep(200);
		target.damage(this.atk * 2);
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
		System.out.println("「我が剣と忠誠は、デマーシアの為に！」");
		java.lang.Thread.sleep(200);
		System.out.println("「ム！メイジかッ！？」");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//ダメージ時
	//Allyクラスを継承

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(200);
		System.out.println("「デマアアアアアアシアアアアアア！！！」");
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
		System.out.println("「デマ……シア……。」");
		System.out.println("");
		java.lang.Thread.sleep(200);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}
