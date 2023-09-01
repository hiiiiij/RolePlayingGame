package jp.game.rpg.hijiri;

public class Matango extends Enemy {
	
	//コンストラクタ
	public Matango() {
		this.name = "マタンゴ";
		this.hp = 100;
		this.atk = 80;
		alive = true;
	}

	public Matango(char suffix) {
		this.name = "マタンゴ" + suffix;
		this.hp = 100;
		this.atk = 80;
		alive = true;
	}

	//メソッド

	//攻撃時
	public void attack(Ally target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
		target.hp = (target.hp - this.atk);
		if (target.hp <= 0) {
			target.hp = 0;
			target.alive = false;
		}
		System.out.println(target.name + "に" + this.atk + "のダメージ！");
		System.out.println("");
	}

	//登場時
	public void appear() throws Exception {
		System.out.println(this.name + "が現れた！");
		java.lang.Thread.sleep(1000);
	}

	//ダメージ時
	public void damage() throws Exception {
		System.out.println("「ギャッ！？」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
}
