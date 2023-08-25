package jp.game.rpg.hijiri;

public class Matango {
	
	String name;
	int hp;
	int atk;
	
	//コンストラクタ
	public Matango(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	//メソッド
	
	//攻撃時
	public void attack() throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//登場時
	public void apper() throws Exception {
		System.out.println("キノコが現れた！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//ダメージ時
		public void damage() throws Exception{
			System.out.println("「ギャッ！？」");
			System.out.println("");
			java.lang.Thread.sleep(1000);
		}
}
