package jp.game.rpg.hijiri;

public abstract class Ally implements Character {

	String name;
	int MAX_HP;
	int hp;
	int atk;
	int armor;
	Equipment equipment;
	Consumables consumables;
	Boolean selected;

	
	//メソッド

	//攻撃
	public void attack(Enemy target) throws Exception {
	}

	//スキル
	public void skill(Enemy target) throws Exception {
	}

	//逃走
	public void run() throws Exception {
	}

	//登場
	public void appear() throws Exception {

	}

	//ダメージ
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
			System.out.println(this.name + "は倒れた！");
			System.out.println("");
		}
	}

	//装備
	public void equip(Equipment item) throws Exception {
		System.out.println(this.name + "は" + item.name + "を装備した。");
		equipment = item;

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

	//消耗品
	public void bring(Consumables item) throws Exception {
		System.out.println(this.name + "は" + item.name + "を持った。");
		consumables = item;
		System.out.println("");
	}

	//勝利
	public void win() throws Exception {

	}

	//敗北
	public void dead() throws Exception {

	}

}
