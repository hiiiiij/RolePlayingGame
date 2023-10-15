package jp.game.rpg.hijiri;

public class ThrowingKnife extends Consumables {
	int power;

	//コンストラクタ
	public ThrowingKnife() {
		this.name = "投げナイフ";
		this.quantity = 1;
		this.power = 200;
	}

	//メソッド
	public void use(Ally target) throws Exception {
		if (target.hp == 0) {
			System.out.println(this.name + "は" + target.name + "に突き刺さった");
			System.out.println("");
			java.lang.Thread.sleep(200);
		} else {
			System.out.println(this.name + "を" + target.name + "に投げつけた！");
			java.lang.Thread.sleep(200);
			target.damage(power);
		}
	}

	public void use(Enemy target) throws Exception {
		if (target.hp == 0) {
			System.out.println(this.name + "は" + target.name + "に突き刺さった");
			System.out.println("");
			java.lang.Thread.sleep(200);
		} else {
			System.out.println(this.name + "を" + target.name + "に投げつけた！");
			java.lang.Thread.sleep(200);
			target.damage(power);
		}
	}

}
