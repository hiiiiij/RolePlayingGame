package jp.game.rpg.hijiri;

public class Ezreal extends Ally {

	//コンストラクタ
	public Ezreal() {
		this.name = "エズリアル";
		this.MAX_HP = 600;
		this.hp = MAX_HP;
		this.atk = 62;
		this.armor = 24;
		this.selected = false;
	}

	//メソッド

	//攻撃時
	public void attack(Enemy target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「ぶっ飛ばせガントレット！」");
		java.lang.Thread.sleep(200);
	}

	//スキル
	public void skill(Enemy target) throws Exception {
		System.out.println(this.name + "トゥルーショットバラージ！");
		System.out.println("「食らえ！」");
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
		System.out.println("「クエスト了解！…て、どこに行くって？」");
		java.lang.Thread.sleep(200);
		System.out.println("「博物館送りにしてやるぜ！」");
		System.out.println("");
		java.lang.Thread.sleep(200);
		this.selected = true;
	}

	//ダメージ時
	//Allyクラスを継承

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(200);
		System.out.println("「勝ったのは、エズリアルでーす！ フゥーイェーイ！」");
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
		System.out.println("「まだ……。」");
		System.out.println("");
		java.lang.Thread.sleep(200);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}