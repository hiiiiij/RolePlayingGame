package jp.game.rpg.hijiri;

public class GameMaster {
	public static void main(String args[]) throws Exception {
		//自分と敵
		Garen ally = new Garen("ガレン", 690, 69);
		Matango enemy = new Matango("キノコ", 100, 300);

		//登場
		ally.apper();
		enemy.apper();

		//ループお互いのHPが残っている間ループ
		do {
			//コマンド選択
			System.out.println("どうする？");
			System.out.println("行動を数字で選択してください。");
			System.out.println("0:通常攻撃 1:逃げる 2:体力確認");
			int input = new java.util.Scanner(System.in).nextInt();

			//コマンドによって行動を変化させる

			//0:通常攻撃
			if (input == 0) {

				//自分の攻撃
				ally.attack();
				enemy.hp = enemy.hp - ally.atk;
				System.out.println(enemy.name + "に" + ally.atk + "のダメージ！");
				java.lang.Thread.sleep(1000);
				enemy.damage();

				//敵の行動(生きている場合)
				if (enemy.hp > 0) {
					enemy.attack();
					ally.hp = ally.hp - enemy.atk;
					System.out.println(ally.name + "に" + enemy.atk + "のダメージ！");
					java.lang.Thread.sleep(1000);
					ally.damage();
				}

				//1:逃げる
			}
			if (input == 1) {

				//自分の逃走
				ally.run();

				//敵の行動(生きている場合)
				if (enemy.hp > 0) {
					enemy.attack();
					ally.hp = ally.hp - enemy.atk;
					System.out.println(ally.name + "に" + enemy.atk + "のダメージ！");
					java.lang.Thread.sleep(1000);
					ally.damage();
				}

				//2:体力確認	
			}
			if (input == 2) {

				//お互いの体力を表示する
				System.out.println(ally.name + "の体力：" + ally.hp);
				System.out.println(enemy.name + "の体力：" + enemy.hp);
				System.out.println("");
			}

		} while (ally.hp > 0 && enemy.hp > 0);

		//どちらの体力が0以下かで分岐
		if (ally.hp <= 0) {
			ally.dead();
		}
		if (enemy.hp <= 0) {
			ally.win();
		}
	}

}
