package jp.game.rpg.hijiri;

import java.util.Arrays;
import java.util.Random;

public class GameMaster {

	//インスタンス
	static java.util.Scanner scanner = new java.util.Scanner(System.in); //コマンド入力
	static Random rand = new Random(); //ランダム

	public static void main(String args[]) throws Exception {

		//キャラクター配列
		Ally allyCharacters[] = new Ally[] {
				new Garen(),
				new Braum(),
				new Draven()
		};

		//キャラクター表示
		System.out.println("キャラクターを選択してください。");
		for (Ally a : allyCharacters) {
			System.out.println(Arrays.asList(allyCharacters).indexOf(a) + 1 + ":" + a.name);
		}

		//キャラクター選択
		int c = command(1, allyCharacters.length);
		//装備品配列
		Equipment equipmentList[] = new Equipment[] {
				new Ruby(),
				new LongSword(),
				new ClothArmor(),
				new Omg()
		};
		//装備
		equipItem(allyCharacters[c], equipmentList);

		//消耗品配列
		Consumables consumablesList[] = new Consumables[] {
				new Redpotion(),
				new ElixirOfIron(),
				new ThrowingKnife()
		};
		//所持
		bringItem(allyCharacters[c], consumablesList);

		//登場
		allyCharacters[c].appear();

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
			//コマンド選択
			System.out.println("行動を数字で選択してください。");
			System.out.println("1:通常攻撃 2:スキル 3:アイテム 4:逃げる 5:体力確認");
			int input = command(1, 5);

			//コマンドによって行動を変化させる
			switch (input) {
			//0:通常攻撃
			case 0:
				//自分の攻撃
				attackFromAlly(allyCharacters[c], enemyCharacters);
				//敵の攻撃
				attackFromEnemy(enemyCharacters, allyCharacters[c]);
				break;

			//1:スキル
			case 1:
				Enemy target = selectEnemy(enemyCharacters);

				allyCharacters[c].skill(target);
				break;

			//2:アイテム
			case 2:
				//消耗品使用
				useItem(allyCharacters[c], enemyCharacters);
				break;

			//3:逃げる
			case 3:
				//自分の逃走
				allyCharacters[c].run();
				//敵の攻撃
				attackFromEnemy(enemyCharacters, allyCharacters[c]);
				break;

			//4:体力確認
			case 4:
				//お互いの体力を表示する
				confirm_HP(allyCharacters[c], enemyCharacters);
				break;
			}

		} while (isWin(enemyCharacters) == false && isLose(allyCharacters[c]) == false);

		if (isLose(allyCharacters[c])) {
			allyCharacters[c].dead();
		}
		if (isWin(enemyCharacters)) {
			allyCharacters[c].win();
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

	//敵を表示し、対象を選択するメソッド
	public static Enemy selectEnemy(Enemy enemyList[]) {
		//敵を表示する
		System.out.println("対象を選択してください。");
		for (Enemy e : enemyList) {
			if (e.hp > 0) {
				System.out.println(Arrays.asList(enemyList).indexOf(e) + 1 + ":" + e.name);
			}
			if (e.hp == 0) {
				System.out.println(Arrays.asList(enemyList).indexOf(e) + 1 + ":" + e.name + "(死亡)");
			}
		}

		//対象を選択する
		int t;
		do {
			t = command(1, enemyList.length);
			if (enemyList[t].hp == 0) {
				System.out.println("有効な数字を選択してください。");
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
	public static void attackFromEnemy(Enemy agent[], Ally target) throws Exception {
		//敵の攻撃
		int dmg = 0;
		for (Enemy e : agent) {
			if (e.hp > 0 && target.hp > 0) {
				e.attack(target);
				target.damage(e.atk);
				dmg += (e.atk - target.armor);
			}
		}
		if (dmg > 0) {
			System.out.println(target.name + "に合計" + dmg + "のダメージ！");
			System.out.println("");
		}
	}

	//自分と敵の体力を確認するメソッド
	public static void confirm_HP(Ally ally, Enemy enemy[]) throws Exception {
		System.out.println(ally.name + "の体力：" + ally.hp);
		System.out.println("");
		for (Enemy e : enemy) {
			System.out.println(e.name + "の体力:" + +e.hp);
			System.out.println("");
		}
	}

	//敗北判定（自分のhpが0か判定）
	public static boolean isLose(Ally ally) {
		boolean a;
		if (ally.hp > 0) {
			a = false;
		} else {
			a = true;
		}
		return a;
	}

	//勝利判定（全ての敵のhpが0か判定）
	public static boolean isWin(Enemy enemy[]) {
		boolean a = false;
		for (Enemy e : enemy) {
			if (e.hp > 0) {
				a = false;
				break;
			} else {
				a = true;
			}
		}
		return a;
	}

	//装備品装備
	public static void equipItem(Ally ally, Equipment equipmentList[]) throws Exception {
		//装備品表示
		System.out.println("装備を選択してください。");
		for (Equipment e : equipmentList) {
			System.out.print(Arrays.asList(equipmentList).indexOf(e) + 1 + ":" + e.name);
			if (e.hp > 0) {
				System.out.print(" 体力+" + e.hp);
			}
			if (e.atk > 0) {
				System.out.print(" 攻撃力+" + e.atk);
			}
			if (e.armor > 0) {
				System.out.print(" 防御力+" + e.armor);
			}
			System.out.println("");
		}
		//装備品装備
		ally.equip(equipmentList[command(1, equipmentList.length)]);
	}

	//消耗品所持
	public static void bringItem(Ally ally, Consumables consumablesList[]) throws Exception {
		//消耗品表示
		System.out.println("アイテムを選択してください。");
		for (Consumables c : consumablesList) {
			System.out.print(Arrays.asList(consumablesList).indexOf(c) + 1 + ":" + c.name);
			System.out.println("");
		}
		//消耗品所持
		ally.bring(consumablesList[command(1, consumablesList.length)]);
	}

	//消耗品使用
	public static void useItem(Ally ally, Enemy enemy[]) throws Exception {
		if (ally.consumables == null) {
			System.out.println("アイテムを持っていない！");
			System.out.println("");
		} else {
			System.out.println(ally.consumables.name + "を使用する対象を選択してください。");
			//対象を選択する
			System.out.println("1:" + ally.name + "(自分)");
			for (Enemy e : enemy) {
				if (e.hp > 0) {
					System.out.println(Arrays.asList(enemy).indexOf(e) + 2 + ":" + e.name);
				}
				if (e.hp == 0) {
					System.out.println(Arrays.asList(enemy).indexOf(e) + 2 + ":" + e.name + "(死亡)");
				}
			}

			//対象に応じた処理
			int t;
			t = command(1, enemy.length + 1);
			if (t == 0) {
				ally.consumables.use(ally);
			}
			if (t > 0) {
				ally.consumables.use(enemy[t - 1]);
			}

			ally.consumables = null;

		}
	}
}
