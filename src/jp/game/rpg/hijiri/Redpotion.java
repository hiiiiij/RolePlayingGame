package jp.game.rpg.hijiri;

public class Redpotion extends Consumables {
	int recovery;
	
	//コンストラクタ
	public Redpotion() {
		this.name = "赤ポーション";
		this.recovery = 150;
	}
	
	//メソッド
	public void use(Ally target) throws Exception {
		System.out.println(target.name + "は" + this.name + "を使った！");
		java.lang.Thread.sleep(200);
		System.out.println(target.name + "の体力が" + this.recovery + "回復！");
		target.hp += this.recovery;
		if (target.hp > target.MAX_HP) {
			target.hp = target.MAX_HP;
		}
		java.lang.Thread.sleep(200);
	}
	
	public void use(Enemy target) throws Exception {
		if (target.hp == 0) {
			System.out.println(target.name + "には効果がなかった。");
			System.out.println("");
		} 
		else {
		System.out.println(this.name + "を" + target.name + "に投げつけた！");
		java.lang.Thread.sleep(200);
		System.out.println(target.name + "の体力が" + this.recovery + "回復！");
		target.hp += this.recovery;
		if (target.hp > target.MAX_HP) {
			target.hp = target.MAX_HP;
		}
		java.lang.Thread.sleep(200);
		}
	}
}
