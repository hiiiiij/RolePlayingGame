package jp.game.rpg.hijiri;

import java.util.Random;

public class GameMaster {

	public static void main(String args[]) throws Exception {

		//自キャラ配列
		int characterSelect;
		Ally allyCharacter[] = new Ally[] {
				new Garen(),
				new Braum(),
				new Draven()
		};

		//コマンド入力変数
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		//自キャラ選択
		do {

			System.out.println("キャラクターを数字で選択してください。");
			System.out.println("0:" + allyCharacter[0].name);
			System.out.println("1:" + allyCharacter[1].name);
			System.out.println("2:" + allyCharacter[2].name);

			characterSelect = scanner.nextInt();

			if (characterSelect > 2 || 0 > characterSelect) {
				System.out.println("有効な数字を選択してください。");
			}

		} while (characterSelect > 2 || 0 > characterSelect);

		//入力値によってキャラ選択
		int c = characterSelect;

		//自キャラ選択ボイス
		allyCharacter[c].selected();

		//登場
		allyCharacter[c].appear();

		//ランダム変数
		Random rand = new Random();

		//敵リストと番号

		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

		//敵の数
		int enemy_number = rand.nextInt(3) + 1;

		//敵の数固定するテスト
		enemy_number = 3;
		Enemy enemyCharacter[] = new Enemy[enemy_number];

		//敵生成（マタンゴ）
		//敵リスト
		for (int i = 0; i < enemy_number; i++) {
			enemyCharacter[i] = new Matango(ch[i]);
			enemyCharacter[i].appear();
		}

		//勝敗判定
		boolean win = false;
		boolean loss = false;

		//お互いのHPが残っている間ループ
		do {

			//コマンド選択
			System.out.println("");
			System.out.println("行動を数字で選択してください。");
			System.out.println("0:通常攻撃 1:逃げる 2:体力確認");
			int input = scanner.nextInt();
			System.out.println("");

			//コマンドによって行動を変化させる
			switch (input) {

			//0:通常攻撃
			case 0:

				//対象を選択する

				int t; //選択された敵

				do {
					int count = 0; //添え字

					//敵を表示する
					System.out.println("対象を数字で選択してください。");
					for (Enemy e : enemyCharacter) {
						if (e.alive == true) {
							System.out.println(count + ":" + e.name);
							System.out.println("");
						}
						if (e.alive == false) {
							System.out.println(count + ":" + e.name + "(死亡)");
							System.out.println("");
						}
						count++;
					}

					int target_number = scanner.nextInt();
					t = target_number;
					if (enemyCharacter[t].alive == false) {
						System.out.println("有効な数字を選択してください。");
					}
				} while (enemyCharacter[t].alive == false);

				//自分の攻撃
				allyCharacter[c].attack(enemyCharacter[t]);
				enemyCharacter[t].damage();

				//倒したとき
				if (enemyCharacter[t].alive == false) {
					System.out.println(enemyCharacter[t].name + "は倒れた！");
					System.out.println("");
				}

				//敵の攻撃
				for (Enemy e : enemyCharacter) {
					if (e.alive == true && allyCharacter[c].alive == true) {
						e.attack(allyCharacter[c]);
					}
				}

				break;

			//1:逃げる
			case 1:

				//自分の逃走
				allyCharacter[c].run();

				//敵の行動
				for (Enemy e : enemyCharacter) {
					if (e.alive == true && allyCharacter[c].alive == true) {
						e.attack(allyCharacter[c]);
					}
				}

				break;

			//2:体力確認
			case 2:

				//お互いの体力を表示する
				System.out.println(allyCharacter[c].name + "の体力：" + allyCharacter[c].hp);
				System.out.println("");

				for (Enemy e : enemyCharacter) {
					System.out.println(e.name + "の体力:" + +e.hp);
					System.out.println("");
				}

				break;

			//有効でないコマンド
			default:
				System.out.println("有効な数字を選択してください。");
				break;

			}

			//勝利判定
			win = true;
			for (Enemy e : enemyCharacter) {
				if (e.alive == true) {
					win = false;
				}
			}

			//敗北判定
			if (allyCharacter[c].alive == false) {
				loss = true;
			}

		} while (win == false && loss == false);

		//勝敗演出
		if (win == true) {
			allyCharacter[c].win();
		}
		if (loss == true) {
			allyCharacter[c].dead();
		}

	}
}
