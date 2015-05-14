package com.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Card {
	private String number;
	private String color;
	
	/**
	 * Create a pair of new cards
	 * @return
	 */
	public ArrayList<Card> createCard(){
		String[] carNumber = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] carColor = new String[]{"·½¿é","ºìĞÄ","Ã·»¨","ºÚÌÒ"};
		ArrayList<Card> newCards = new ArrayList<Card>();
		
		//Create a pair of new cards
		for(int i = 0;i < carColor.length;i ++){
			for(int j = 0;j < carNumber.length;j ++){
			//	card.id = i;
				Card card = new Card();
				card.color = carColor[i];
				card.number = carNumber[j];
				newCards.add(card);
			}
		}
		return newCards;
	}
	
	/**
	 * show the new cards
	 * @return
	 */
	public String[] getNewCards(){
		String[] newCardGroup = new String[createCard().size()];
		for(int i = 0;i < createCard().size();i ++){
			newCardGroup[i] =  createCard().get(i).color +createCard().get(i).number ;
		}
		return newCardGroup;
	}
	
	/**
	 * Create random cards
	 * @return
	 */
	public String[] RandomCard(){
		Random random = new Random();
		String[] cardsArray = getNewCards();
		String swapCard = null;
		for(int i = 0;i < cardsArray.length;i ++){
			int index = random.nextInt(cardsArray.length);
			swapCard = cardsArray[i];
			cardsArray[i] = cardsArray[index];
			cardsArray[index] = swapCard;
		
		}
		return cardsArray;
	}
}
