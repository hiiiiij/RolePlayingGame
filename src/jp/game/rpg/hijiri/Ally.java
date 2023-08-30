package jp.game.rpg.hijiri;

public abstract class Ally {

	String name;
	int hp;
	int atk;

	//コンストラクタ
	public Ally() {
	}
	
	public Ally(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	//メソッド

	//選択時
	public void selected() throws Exception {
	}

	//攻撃時
	public void attack() throws Exception {
	}

	//逃走時
	public void run() throws Exception {
	}

	//登場時
	public void appear() throws Exception {

	}

	//ダメージ時
	public void damage(int dmg) throws Exception {

	}

	//勝利時
	public void win() throws Exception {

	}

	//敗北時
	public void dead() throws Exception {

	}

}
