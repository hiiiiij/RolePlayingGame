package jp.game.rpg.hijiri;

public class GameMaster {
	public static void main(String args[]) throws Exception {

		//自キャラ配列
		Garen garen = new Garen("ガレン", 690, 69);
		Braum braum = new Braum("ブラウム", 610, 55);
		Draven draven = new Draven("ドレイヴン", 675, 62);

		//自キャラ変数
		int characterSelect;
		Ally allyCharacter = null;

		//コマンド入力変数
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		//自キャラ選択
		do {

			System.out.println("キャラクターを数字で選択してください。");
			System.out.println("0:" + garen.name);
			System.out.println("1:" + braum.name);
			System.out.println("2:" + draven.name);

			characterSelect = scanner.nextInt();

			if (characterSelect > 2 || 0 > characterSelect) {
				System.out.println("有効な数字を選択してください。");
			}

		} while (characterSelect > 2 || 0 > characterSelect);

		//入力値によってキャラ選択
		if (characterSelect == 0) {
			allyCharacter = garen;
		}
		if (characterSelect == 1) {
			allyCharacter = braum;
		}
		if (characterSelect == 2) {
			allyCharacter = draven;
		}

		//自キャラ選択ボイス
		allyCharacter.selected();

		//登場
		allyCharacter.appear();

		//敵決定
		Matango matango = new Matango();
		Matango enemyCharacter = matango;

		enemyCharacter.appear();

		//お互いのHPが残っている間ループ
		do {
			//コマンド選択
			System.out.println("どうする？");
			System.out.println("行動を数字で選択してください。");
			System.out.println("0:通常攻撃 1:逃げる 2:体力確認");
			int input = scanner.nextInt();

			//コマンドによって行動を変化させる

			//0:通常攻撃
			if (input == 0) {

				//自分の攻撃
				allyCharacter.attack();
				System.out.println(enemyCharacter.name + "に" + allyCharacter.atk + "のダメージ！");
				java.lang.Thread.sleep(1000);
				enemyCharacter.damage(allyCharacter.atk);

				//敵の行動(生きている場合)
				if (enemyCharacter.hp > 0) {
					enemyCharacter.attack();
					System.out.println(allyCharacter.name + "に" + enemyCharacter.atk + "のダメージ！");
					java.lang.Thread.sleep(1000);
					allyCharacter.damage(enemyCharacter.atk);
				}

				//1:逃げる
			}
			if (input == 1) {

				//自分の逃走
				allyCharacter.run();

				//敵の行動(生きている場合)
				if (enemyCharacter.hp > 0) {
					enemyCharacter.attack();
					System.out.println(allyCharacter.name + "に" + enemyCharacter.atk + "のダメージ！");
					java.lang.Thread.sleep(1000);
					allyCharacter.damage(enemyCharacter.atk);
				}

				//2:体力確認	
			}
			if (input == 2) {

				//お互いの体力を表示する
				System.out.println(allyCharacter.name + "の体力：" + allyCharacter.hp);
				System.out.println(enemyCharacter.name + "の体力：" + enemyCharacter.hp);
				System.out.println("");
			}

		} while (allyCharacter.hp > 0 && enemyCharacter.hp > 0);

		//どちらの体力が0以下かで分岐
		if (allyCharacter.hp <= 0) {
			allyCharacter.dead();
		}
		if (enemyCharacter.hp <= 0) {
			allyCharacter.win();
		}
	}

}
