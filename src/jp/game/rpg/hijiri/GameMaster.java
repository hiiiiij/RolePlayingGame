package jp.game.rpg.hijiri;

import java.util.Random;

public class GameMaster {

	//インスタンス
	static java.util.Scanner scanner = new java.util.Scanner(System.in); //コマンド入力
	static Random rand = new Random(); //ランダム

	public static void main(String args[]) throws Exception {

		//キャラクター配列
		Ally allyCharacter[] = new Ally[] {
				new Garen(),
				new Braum(),
				new Draven()
		};

		//キャラクター表示
		System.out.println("キャラクターを選択してください。");
		int characterNo = 0;
		for (Ally a : allyCharacter) {
			characterNo++;
			System.out.println(characterNo + ":" + a.name);
		}

		//キャラクター選択
		int c = command(1, characterNo);

		//アイテム配列
		Item itemList[] = new Item[] {
				new Ruby(),
				new LongSword(),
				new ClothArmor(),
				new Omg()
		};

		equip(allyCharacter[c], itemList);

		//登場
		allyCharacter[c].appear();

		//敵の数の決定(1~3)
		int numberOfEnemy = rand.nextInt(3) + 1;

		//同名の敵の番号 8体まで
		char[] ch = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

		Enemy enemyCharacter[] = new Enemy[numberOfEnemy];

		//敵を生成（マタンゴ）
		//敵リスト
		for (int i = 0; i < numberOfEnemy; i++) {
			enemyCharacter[i] = new Matango(ch[i]);
			enemyCharacter[i].appear();
		}
		System.out.println("");

		//お互いのHPが残っている間ループ
		do {
			//コマンド選択
			System.out.println("行動を数字で選択してください。");
			System.out.println("1:通常攻撃 2:逃げる 3:体力確認");
			int input = command(1, 3);

			//コマンドによって行動を変化させる
			switch (input) {
			//0:通常攻撃
			case 0:
				//自分の攻撃
				attackFromAlly(allyCharacter[c], enemyCharacter);
				//敵の攻撃
				attackFromEnemy(enemyCharacter, allyCharacter[c]);
				break;

			//1:逃げる
			case 1:
				//自分の逃走
				allyCharacter[c].run();
				//敵の攻撃
				attackFromEnemy(enemyCharacter, allyCharacter[c]);
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
			}

		} while (isWin(enemyCharacter) == false && isLose(allyCharacter[c]) == false);

		if (isLose(allyCharacter[c]) == true) {
			allyCharacter[c].dead();
		}
		if (isWin(enemyCharacter) == true) {
			allyCharacter[c].win();
		}

	}

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

	//自分(agent)が敵(target)を攻撃するメソッド
	public static void attackFromAlly(Ally agent, Enemy target[]) throws Exception {
		//敵を表示する
		System.out.println("攻撃の対象を選択してください。");
		int enemyNo = 0;
		for (Enemy e : target) {
			enemyNo++;
			if (e.hp > 0) {
				System.out.println(enemyNo + ":" + e.name);
			}
			if (e.hp == 0) {
				System.out.println(enemyNo + ":" + e.name + "(死亡)");
			}
		}

		//対象を選択する
		int t;
		do {
			t = command(1, enemyNo);
			if (target[t].hp == 0) {
				System.out.println("有効な数字を選択してください。");
			}
		} while (target[t].hp == 0);

		//自分の攻撃
		agent.attack(target[t]);
		target[t].damage(agent.atk);

		//倒したとき
		if (target[t].hp == 0) {
			System.out.println(target[t].name + "は倒れた！");
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

	//アイテム装備
	public static void equip(Ally ally, Item itemList[]) throws Exception {
		//アイテム表示
		System.out.println("装備するアイテムを選択してください。");
		int itemNo = 0;
		for (Item i : itemList) {
			itemNo++;
			System.out.print(itemNo + ":" + i.name);
			if (i.hp > 0) {
				System.out.print(" 体力+" + i.hp);
			}
			if (i.atk > 0) {
				System.out.print(" 攻撃力+" + i.atk);
			}
			if (i.armor > 0) {
				System.out.print(" 防御力+" + i.armor);
			}
			System.out.println("");
		}

		//アイテム装備
		ally.equip(itemList[command(1, itemNo)]);

	}

}
