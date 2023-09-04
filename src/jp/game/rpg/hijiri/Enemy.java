package jp.game.rpg.hijiri;

public abstract class Enemy {

	String name;
	int MAX_HP;
	int hp;
	int atk;
	int armor;
	char suffix;

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
	public void damage(int atk) throws Exception {
		int dmg = atk - this.armor;
		if (dmg <= 0) {
			dmg = 0;
		}
		System.out.println(this.name + "に" + (dmg) + "のダメージ！");
		System.out.println("");
		java.lang.Thread.sleep(200);
		//ダメージ計算
		this.hp -= (dmg);
		if (this.hp <= 0) {
			this.hp = 0;
		}
	}

}
