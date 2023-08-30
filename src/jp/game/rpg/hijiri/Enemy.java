package jp.game.rpg.hijiri;

public class Enemy {
	
	String name;
	int hp;
	int atk;
	
	//コンストラクタ
	public Enemy() {
	}
	
	public Enemy(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	public Enemy(char suffix) {
		this.name = name + suffix;
	}
	
	//メソッド
	
	//攻撃時
	public void attack() throws Exception {
	}
	
	//登場時
	public void appear() throws Exception {
	}
	
	//ダメージ時
	public void damage(int dmg) throws Exception{
	}

}
