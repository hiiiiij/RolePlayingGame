package jp.game.rpg.hijiri;

public class Garen {
	
	String name;
	int hp;
	int atk;
	
	//コンストラクタ
	public Garen(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	
	//メソッド
	
	//攻撃時
	public void attack() throws Exception {
		System.out.println(this.name + "の攻撃！");
		System.out.println("「デマーシアアアア！！」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//逃走時
	public void run() throws Exception {
		System.out.println(this.name + "は無様に逃げ出した！");
		java.lang.Thread.sleep(1000);
		System.out.println("しかし逃げられなかった！");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//登場時
	public void apper() throws Exception {
		System.out.println("「俺は" + name + "」");
		System.out.println("「今日も地球を持ち上げているぞ！」");
		java.lang.Thread.sleep(1000);
		System.out.println("「ム！メイジかッ！？」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//ダメージ時
	public void damage() throws Exception{
		System.out.println("「デマッ！？」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
	}
	
	//勝利時
	public void win() throws Exception{
		System.out.println(this.name + "は勝利した。");
		java.lang.Thread.sleep(1000);
		System.out.println("「デマアアアアアアシアアアアアア！！！」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
		
		char[] victory = {'V', 'I', 'C', 'T', 'O', 'R', 'Y'}; 
		
		for (int i = 0; i < victory.length; i++) {
			System.out.print(victory[i] + " ");
			java.lang.Thread.sleep(200);
			}
		}
	
	//敗北時
	public void dead() throws Exception{
		System.out.println(this.name + "は力尽きた。");
		System.out.println("「デマ……シア……。」");
		System.out.println("");
		java.lang.Thread.sleep(1000);
		
		char[] defeat = {'D', 'E', 'F', 'E', 'A', 'T'}; 
		
		for (int i = 0; i < defeat.length; i++) {
			System.out.print(defeat[i] + " ");
			java.lang.Thread.sleep(200);	
		}
	}
	
	
	
}
