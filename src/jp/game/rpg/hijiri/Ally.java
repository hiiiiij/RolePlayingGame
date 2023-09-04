package jp.game.rpg.hijiri;

public abstract class Ally {

	String name;
	int MAX_HP;
	int hp;
	int atk;
	int armor;
	Item equipment;

	//コンストラクタ
	public Ally() {
	}

	//メソッド

	//攻撃時
	public void attack(Enemy target) throws Exception {
	}

	//逃走時
	public void run() throws Exception {
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
		System.out.println(this.name + "に" + dmg + "のダメージ！");
		System.out.println("");
		java.lang.Thread.sleep(200);
		//ダメージ計算
		this.hp -= dmg;
		if (this.hp <= 0) {
			this.hp = 0;
		}
	}

	public void equip(Item item) throws Exception {
		System.out.println(this.name + "は" + item.name + "を装備した。");
		this.equipment = item;
		
		if (item.hp > 0) {
			this.MAX_HP += item.hp;
			this.hp += item.hp;
			System.out.print("HPが" + item.hp + "上昇！");
		}
		if (item.atk > 0) {
			this.atk += item.atk;
			System.out.print("攻撃力が" + item.atk + "上昇！");
		}
		if (item.armor > 0) {
			this.armor += item.armor;
			System.out.print("防御力が" + item.armor + "上昇！");
		}
		System.out.println("");
		System.out.println("");
	}

	//勝利時
	public void win() throws Exception {

	}

	//敗北時
	public void dead() throws Exception {

	}

}
