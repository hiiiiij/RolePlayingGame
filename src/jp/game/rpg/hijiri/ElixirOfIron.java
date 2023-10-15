package jp.game.rpg.hijiri;

public class ElixirOfIron extends Consumables {
	int enrichment;

	//コンストラクタ
	public ElixirOfIron() {
		this.name = "アイアンエリクサー";
		this.quantity = 1;
		this.enrichment = 30;
	}

	//メソッド
	public void use(Ally target) throws Exception {
		System.out.println(target.name + "は" + this.name + "を使った！");
		java.lang.Thread.sleep(200);
		System.out.println(target.name + "のアーマーが" + this.enrichment + "増加！");
		target.armor += this.enrichment;
		java.lang.Thread.sleep(200);
	}

	public void use(Enemy target) throws Exception {
		if (target.hp == 0) {
			System.out.println(target.name + "には効果がなかった。");
			System.out.println("");
		} else {
			System.out.println(this.name + "を" + target.name + "に投げつけた！");
			java.lang.Thread.sleep(200);
			System.out.println(target.name + "のアーマーが" + this.enrichment + "増加！");
			target.armor += this.enrichment;
			java.lang.Thread.sleep(200);
		}
	}

}
