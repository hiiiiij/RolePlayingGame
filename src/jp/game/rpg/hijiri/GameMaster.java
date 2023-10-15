package jp.game.rpg.hijiri;

import java.util.Arrays;
import java.util.Random;

public class GameMaster {

	//インスタンス
	static java.util.Scanner scanner = new java.util.Scanner(System.in); //コマンド入力
	static Random rand = new Random(); //ランダム

	public static void main(String args[]) throws Exception {

		//キャラクター配列
		Ally allyList[] = new Ally[] {
				new Garen(),
				new Braum(),
				new Draven(),
				new Ezreal()
		};

		//味方キャラクター選択
		Ally[] allyCharacters = characterSelect(allyList);

		//装備品配列
		Equipment equipmentList[] = new Equipment[] {
				new Ruby(),
				new LongSword(),
				new ClothArmor(),
				new Omg()
		};

		//装備
		equipItem(allyCharacters, equipmentList);

		//消耗品配列
		Consumables consumablesList[] = new Consumables[] {
				new Redpotion(),
				new ElixirOfIron(),
				new ThrowingKnife()
		};

		//所持
		bringItem(allyCharacters, consumablesList);

		//登場

		//敵の数の決定(1~3)
		int numberOfEnemy = rand.nextInt(3) + 1;

		//同名の敵の番号 8体まで
		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

		Enemy enemyCharacters[] = new Enemy[numberOfEnemy];

		//敵を生成（マタンゴ）
		//敵リスト
		for (int i = 0; i < numberOfEnemy; i++) {
			enemyCharacters[i] = new Matango(ch[i]);
			enemyCharacters[i].appear();
		}
		System.out.println("");

		//お互いのHPが残っている間ループ
		do {
			allyAction(allyCharacters, enemyCharacters);
			attackFromEnemy(enemyCharacters, allyCharacters);
		} while (isWin(enemyCharacters) == false && isLose(allyCharacters) == false);

		if (isLose(allyCharacters)) {
			System.out.println("全滅してしまった！");
			System.out.println("");
			java.lang.Thread.sleep(200);

			char[] defeat = { 'D', 'E', 'F', 'E', 'A', 'T' };

			for (int i = 0; i < defeat.length; i++) {
				System.out.print(defeat[i] + " ");
				java.lang.Thread.sleep(200);
			}
		}
		if (isWin(enemyCharacters)) {
			System.out.println("戦闘に勝利した！");
			System.out.println("");
			java.lang.Thread.sleep(200);

			char[] victory = { 'V', 'I', 'C', 'T', 'O', 'R', 'Y' };

			for (int i = 0; i < victory.length; i++) {
				System.out.print(victory[i] + " ");
				java.lang.Thread.sleep(200);
			}
		}

	}

	//===============================================================//
	//===============================================================//
	//===============================================================//
	//===============================================================//
	//===============================================================//
	//メソッド
	//===============================================================//
	//===============================================================//
	//===============================================================//
	//===============================================================//
	//===============================================================//

	//最低値(min)から最大値(max)までのコマンドを受け付けるメソッド
	public static int command(int min, int max) {
		int n;
		do {
			System.out.print(">>");
			n = scanner.nextInt();
			if (n < min || n > max) {
				System.out.println("有効な数字を入力してください。");
			}
		} while (n < min || n > max);
		System.out.println("");
		return n - 1;
	}

	//味方を表示し、対象を選択するメソッド
	public static Ally selectAlly(Ally allyCharacters[]) {
		//味方を表示する
		System.out.println("対象を選択してください。");
		for (Ally e : allyCharacters) {
			System.out.println(Arrays.asList(allyCharacters).indexOf(e) + 1 + ":" + e.name);
		}
		//対象を選択する
		int t;
		do {
			t = command(1, allyCharacters.length);
			if (allyCharacters[t].hp == 0) {
				System.out.println("有効な対象を選択してください。");
			}
		} while (allyCharacters[t].hp == 0);

		return allyCharacters[t];
	}

	//敵を表示し、対象を選択するメソッド
	public static Enemy selectEnemy(Enemy enemyList[]) {
		//敵を表示する
		System.out.println("対象を選択してください。");
		for (Enemy e : enemyList) {
			System.out.println(Arrays.asList(enemyList).indexOf(e) + 1 + ":" + e.name);
		}

		//対象を選択する
		int t;
		do {
			t = command(1, enemyList.length);
			if (enemyList[t].hp == 0) {
				System.out.println("有効な対象を選択してください。");
			}
		} while (enemyList[t].hp == 0);

		return enemyList[t];
	}

	//自分(agent)が敵(target)を攻撃するメソッド
	public static void attackFromAlly(Ally agent, Enemy target[]) throws Exception {
		Enemy t = selectEnemy(target);

		//自分の攻撃
		agent.attack(t);
		t.damage(agent.atk);

		//倒したとき
		if (t.hp == 0) {
			System.out.println(t.name + "は倒れた！");
			System.out.println("");
		}
	}

	//敵(agent)が自分(target)を攻撃するメソッド
	public static void attackFromEnemy(Enemy enemyCharacters[], Ally allyCharacters[]) throws Exception {
		//敵の攻撃
		for (Enemy e : enemyCharacters) {
			Random rand = new Random();
			int targetNo;
			do {
				targetNo = rand.nextInt(2);
			} while (allyCharacters[targetNo].hp == 0);

			if (e.hp > 0 && allyCharacters[targetNo].hp > 0) {
				e.attack(allyCharacters[targetNo]);
				allyCharacters[targetNo].damage(e.atk);
			}
		}
	}

	//自分と敵の体力を確認するメソッド
	public static void confirm_HP(Ally allyCharacters[], Enemy enemyCharacters[]) throws Exception {
		System.out.println("【味方】");
		for (Ally a : allyCharacters) {
			System.out.println(a.name + "の体力：" + a.hp);
			System.out.println("");
		}

		System.out.println("【敵】");
		for (Enemy e : enemyCharacters) {
			System.out.println(e.name + "の体力:" + +e.hp);
			System.out.println("");
		}
	}

	//敗北判定（自分のhpが0か判定）
	public static boolean isLose(Ally allyCharacters[]) {
		boolean lose = false;
		for (Ally a : allyCharacters) {
			if (a.hp > 0) {
				lose = false;
				break;
			} else {
				lose = true;
			}
		}
		return lose;
	}

	//勝利判定（全ての敵のhpが0か判定）
	public static boolean isWin(Enemy enemyCharacters[]) {
		boolean win = false;

		for (Enemy e : enemyCharacters) {
			if (e.hp > 0) {
				win = false;
				break;
			} else {
				win = true;
			}
		}
		return win;
	}

	//装備品装備
	public static void equipItem(Ally allyCharacters[], Equipment equipmentList[]) throws Exception {
		//表示
		System.out.println("装備を選択してください。");
		for (Equipment equipment : equipmentList) {
			System.out.print(Arrays.asList(equipmentList).indexOf(equipment) + 1 + ":" + equipment.name);
			if (equipment.hp > 0) {
				System.out.print(" 体力+" + equipment.hp);
			}
			if (equipment.atk > 0) {
				System.out.print(" 攻撃力+" + equipment.atk);
			}
			if (equipment.armor > 0) {
				System.out.print(" 防御力+" + equipment.armor);
			}
			System.out.println("");
		}
		int equipmentNo = command(1, equipmentList.length);

		//装備
		selectAlly(allyCharacters).equip(equipmentList[equipmentNo]);
	}

	//消耗品所持
	public static void bringItem(Ally allyCharacters[], Consumables consumablesList[]) throws Exception {
		//表示
		System.out.println("アイテムを選択してください。");
		for (Consumables c : consumablesList) {
			System.out.print(Arrays.asList(consumablesList).indexOf(c) + 1 + ":" + c.name);
			System.out.println("");
		}
		int consumablesNo = command(1, consumablesList.length);

		//所持
		selectAlly(allyCharacters).bring(consumablesList[consumablesNo]);
	}

	//消耗品使用
	public static void useItem(Ally ally, Ally allyList[], Enemy enemyList[]) throws Exception {
		if (ally.consumables == null || ally.consumables.quantity == 0) {
			System.out.println("アイテムを持っていない！");
			System.out.println("");
		} else {
			//対象を選択する
			System.out.println(ally.consumables.name + "を使用します。");
			System.out.println("対象を選択してください。");
			System.out.println("1:味方 2:敵");
			int which = command(1, 2);

			//使用する
			if (which == 0) {
				ally.consumables.use(selectAlly(allyList));
			} else {
				ally.consumables.use(selectEnemy(enemyList));
			}

			//個数を減らす
			ally.consumables.quantity--;
		}
	}

	//キャラクター選択
	public static Ally[] characterSelect(Ally allyList[]) throws Exception {
		Ally[] allyCharacters = new Ally[3];

		for (int i = 0; i < 3; i++) {
			int c;
			do {
				//キャラクター表示
				System.out.println(i + 1 + "人目のキャラクターを選択してください。");
				for (Ally a : allyList) {
					System.out.println(Arrays.asList(allyList).indexOf(a) + 1 + ":" + a.name);
				}
				//キャラクター選択
				c = command(1, allyList.length);
				if (allyList[c].selected == false) {
					allyCharacters[i] = allyList[c];
					allyCharacters[i].appear();
					break;
				} else {
					System.out.println("既に選ばれています。");
				}
			} while (allyList[c].selected == true);
		}
		return allyCharacters;
	}

	//味方の行動
	public static void allyAction(Ally allyCharacters[], Enemy enemyCharacters[]) throws Exception {
		for (Ally ally : allyCharacters) {
			if (ally.hp > 0) {
				
				int input; 
				
				do {
				//コマンド選択
				System.out.println(ally.name + "の行動！");
				System.out.println("1:通常攻撃 2:スキル 3:アイテム 4:逃げる 5:体力確認");
				input = command(1, 5);
				//コマンドによって行動を変化させる
				
					switch (input) {
					//0:通常攻撃
					case 0:
						//自分の攻撃
						attackFromAlly(ally, enemyCharacters);
						break;

					//1:スキル
					case 1:
						Enemy target = selectEnemy(enemyCharacters);
						ally.skill(target);
						break;

					//2:アイテム
					case 2:
						//消耗品使用
						useItem(ally, allyCharacters, enemyCharacters);
						break;

					//3:逃げる
					case 3:
						//自分の逃走
						ally.run();
						break;

					//4:体力確認
					case 4:
						//お互いの体力を表示する
						confirm_HP(allyCharacters, enemyCharacters);
						break;
					}
				} while (input == 2 ||  input == 4);

			} else {
				break;
			}
		}
	}

}
