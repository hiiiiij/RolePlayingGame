package jp.game.rpg.hijiri;

public class Enemy {

	String name;
	int hp;
	int atk;
	char suffix;
	boolean alive;
	
	//コンストラクタ
	public Enemy() {
	}
	
	public Enemy(char suffix) {
	}
	
	//メソッド
	
	//攻撃時
	public void attack(Ally target) throws Exception {
	}
	
	//登場時
	public void appear() throws Exception {
	}
	
	//ダメージ時
	public void damage() throws Exception{
	}

}
