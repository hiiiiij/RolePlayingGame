package jp.game.rpg.hijiri;

public class ThrowingKnife extends Consumables {
	int power;

	//コンストラクタ
	public ThrowingKnife() {
		this.name = "投げナイフ";
		this.power = 200;
	}

	//メソッド
	public void use(Ally target) throws Exception {
		System.out.println(target.name + "は" + this.name + "でジャグリングを始めた！");
		System.out.println(this.name + "は地面に落ちてしまった！");
	}

	public void use(Enemy target) throws Exception {
		if (target.hp == 0) {
			System.out.println(this.name + "は" + target.name + "に突き刺さった");
			System.out.println("");
		} else {
			System.out.println(this.name + "を" + target.name + "に投げつけた！");
			java.lang.Thread.sleep(200);
			int dmg = this.power - target.armor;
			System.out.println(target.name + "に" + dmg + "のダメージ！");
			target.hp -= dmg;
			if (target.hp < 0) {
				target.hp = 0;
				System.out.println(target.name + "は倒れた！");
				System.out.println("");
			}
			java.lang.Thread.sleep(200);
		}
	}

}
