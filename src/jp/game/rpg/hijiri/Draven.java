package jp.game.rpg.hijiri;

public class Draven extends Ally {

	//コンストラクタ
	public Draven() {
		this.name = "ドレイヴン";
		this.MAX_HP = 675;
		this.hp = MAX_HP;
		this.atk = 62;
		this.armor = 29;
	}

	//メソッド
	//攻撃時
	public void attack(Enemy target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「よく見ておけよ」");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//スキル
	public void skill(Enemy target) throws Exception {
		System.out.println(this.name + "の回転斬斧！");
		System.out.println("「最高の仕事だぜ。」");
		System.out.println("");
		java.lang.Thread.sleep(200);
		target.damage(this.atk);
		System.out.println(this.name + "の攻撃力が上昇！");
		System.out.println("");
		java.lang.Thread.sleep(200);
		this.atk += 20;
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
		System.out.println("「ここでは俺様が主役よ」");
		java.lang.Thread.sleep(200);
		System.out.println("「リーグオブドレイヴンへようこそ！」");
		System.out.println("");
		java.lang.Thread.sleep(200);
	}

	//ダメージ時
	//Allyクラスを継承

	//勝利時
	public void win() throws Exception {
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(200);
		System.out.println("「やはり俺様は最高だな」");
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
		System.out.println("「この俺様が……」");
		System.out.println("");
		java.lang.Thread.sleep(200);

		char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);
		}
	}

}
