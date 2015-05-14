package com.game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.card.Card;
import com.player.Player;

public class Game {
	public static void main(String[] args) {
		// Create new Card class
		Card card = new Card(); 
		Player[] player = new Player[2];
		
		Scanner input = new Scanner(System.in);
		System.out.println("**********开始创建扑克牌**********");
		System.out.println("**********扑克牌创建成功**********");
		System.out.println(Arrays.toString(card.getNewCards()));
		System.out.println("**********开始洗牌**********");
		String[] cardsRandom = card.RandomCard();
		System.out.println("**********洗牌结束**********");
		System.out.println("**********创建玩家**********");
		
		//Create players
		for(int i = 0; i < player.length;i ++){
			System.out.println("请输入第" + (i+1) + "玩家的ID和姓名");
			System.out.println("请输入ID：");
			int id = input.nextInt();
			System.out.println("请输入姓名：");
			String name = input.next();
			Player player1 = new Player(id,name);
			player[i] = player1;
		}
		
			
		//Show players' name
		for(int i = 0;i < player.length;i ++)
			System.out.println("*****欢迎玩家：" + player[i].getName());
		
		System.out.println("**********开始发牌**********");
		Random random = new Random();
		int index;
		for(int i = 0;i < 4;i ++){
			System.out.println("*****玩家： " + player[i % 2].getName() + " 拿牌");
			index = random.nextInt(cardsRandom.length);
			player[i % 2].setCardInfo(cardsRandom[index]);
		}
		
		System.out.println("**********发牌结束**********");
		System.out.println("**********开始游戏**********");
		
		String[] cardsComp = new String[2];
		for(int i = 0;i < player.length;i ++){
			cardsComp[i] = player[i].maxCard();
			System.out.println("玩家：" + player[i].getName() + "最大的手牌为： " + player[i].maxCard());
		}
		
		int result  = maxCard(cardsComp);
		
		if(result == 1)
			System.out.println("********玩家 " + player[0].getName() + "获胜");
		else if(result == -1)
			System.out.println("********玩家 " + player[1].getName() + "获胜");
		else
			System.out.println("********玩家 " + player[1].getName() + "和玩家 " + "手牌一样大，没有输赢");
		
		System.out.println("**********玩家的手牌为：");
		for(int i = 0;i < player.length;i ++)
			System.out.println(player[i].getName() + ":[ " + player[i].getCardInfo().get(0) + " , "+ player[i].getCardInfo().get(1) + " ]");
		
		
		
	}

	public static int maxCard(String[] cards){
		Map<String, Integer> cardCompare = new HashMap<String, Integer>();
		cardCompare.put("梅花", 4);
		cardCompare.put("黑桃", 3);
		cardCompare.put("红心", 2);
		cardCompare.put("方片", 1);
		
		int winer;
		int a = 0;
		int b = 0;
		
		a = transfer(cards[0]);
		b = transfer(cards[1]);

		if(a > b)
			winer = 1;
		else if(a < b)
			winer = -1;
		else{
			String card1 = cards[0].substring(0,2);
			String card2 = cards[1].substring(0,2);
			
			if(cardCompare.get(card1) > cardCompare.get(card2))
				winer = 1;
			else if(cardCompare.get(card1) < cardCompare.get(card2))
				winer = -1;
			else
				winer = 0;
		}
		return winer;
	}
	
	public static int transfer(String str){
		int a = 0;
		if(str.substring(2).equals("J"))
			a = 11;
		else if(str.substring(2).equals("Q"))
			a = 12;
		else if(str.substring(2).equals("K"))
			a = 13;
		else if(str.substring(2).equals("A"))
			a = 1;
		else
			a = Integer.parseInt(str.substring(2));
		return a;
		
	}
	
}
