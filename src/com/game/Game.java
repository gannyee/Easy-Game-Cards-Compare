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
		System.out.println("**********��ʼ�����˿���**********");
		System.out.println("**********�˿��ƴ����ɹ�**********");
		System.out.println(Arrays.toString(card.getNewCards()));
		System.out.println("**********��ʼϴ��**********");
		String[] cardsRandom = card.RandomCard();
		System.out.println("**********ϴ�ƽ���**********");
		System.out.println("**********�������**********");
		
		//Create players
		for(int i = 0; i < player.length;i ++){
			System.out.println("�������" + (i+1) + "��ҵ�ID������");
			System.out.println("������ID��");
			int id = input.nextInt();
			System.out.println("������������");
			String name = input.next();
			Player player1 = new Player(id,name);
			player[i] = player1;
		}
		
			
		//Show players' name
		for(int i = 0;i < player.length;i ++)
			System.out.println("*****��ӭ��ң�" + player[i].getName());
		
		System.out.println("**********��ʼ����**********");
		Random random = new Random();
		int index;
		for(int i = 0;i < 4;i ++){
			System.out.println("*****��ң� " + player[i % 2].getName() + " ����");
			index = random.nextInt(cardsRandom.length);
			player[i % 2].setCardInfo(cardsRandom[index]);
		}
		
		System.out.println("**********���ƽ���**********");
		System.out.println("**********��ʼ��Ϸ**********");
		
		String[] cardsComp = new String[2];
		for(int i = 0;i < player.length;i ++){
			cardsComp[i] = player[i].maxCard();
			System.out.println("��ң�" + player[i].getName() + "��������Ϊ�� " + player[i].maxCard());
		}
		
		int result  = maxCard(cardsComp);
		
		if(result == 1)
			System.out.println("********��� " + player[0].getName() + "��ʤ");
		else if(result == -1)
			System.out.println("********��� " + player[1].getName() + "��ʤ");
		else
			System.out.println("********��� " + player[1].getName() + "����� " + "����һ����û����Ӯ");
		
		System.out.println("**********��ҵ�����Ϊ��");
		for(int i = 0;i < player.length;i ++)
			System.out.println(player[i].getName() + ":[ " + player[i].getCardInfo().get(0) + " , "+ player[i].getCardInfo().get(1) + " ]");
		
		
		
	}

	public static int maxCard(String[] cards){
		Map<String, Integer> cardCompare = new HashMap<String, Integer>();
		cardCompare.put("÷��", 4);
		cardCompare.put("����", 3);
		cardCompare.put("����", 2);
		cardCompare.put("��Ƭ", 1);
		
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
