package jp.game.rpg.hijiri;

public class Matango extends Enemy {
	
	//コンストラクタ
	public Matango() {
		this.name = "マタンゴ";
		this.MAX_HP = 100;
		this.hp = MAX_HP;
		this.atk = 80;
		this.armor = 10;
	}

	public Matango(char suffix) {
		this.name = "マタンゴ" + suffix;
		this.hp = 100;
		this.atk = 80;
		this.armor = 10;
	}

	//メソッド

	//攻撃時
	public void attack(Ally target) throws Exception {
		System.out.println(this.name + "の攻撃！");
		java.lang.Thread.sleep(200);
	}

	//登場時
	public void appear() throws Exception {
		System.out.println(this.name + "が現れた！");
		java.lang.Thread.sleep(200);
	}

	//ダメージ時
	//Enemyクラスを継承
}
