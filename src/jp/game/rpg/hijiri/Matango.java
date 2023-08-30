package jp.game.rpg.hijiri;

public class Matango extends Enemy {

	String name = "キノコ";
	int hp = 100;
	int atk = 300;

	//コンストラクタ
	public Matango() {
	}
	
	public Matango(String name, int hp, int atk) {
		super(name, hp, atk);
	}
	
	public Matango(char suffix) {
		super(suffix);
	}

	//メソッド

	//攻撃時
	public void attack() throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//登場時
	public void appear() throws Exception {
		System.out.println(this.name + "は胞子をまき散らしている！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}

	//ダメージ時
	public void damage(int dmg) throws Exception {
		System.out.println("「ギャッ！？」");
		System.out.println("");
		this.hp = (this.hp - dmg);
		java.lang.Thread.sleep(1000);
	}
}
