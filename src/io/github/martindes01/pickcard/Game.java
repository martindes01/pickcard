package io.github.martindes01.pickcard;

import java.util.ArrayList;

public class Game {

	public Game() {
		
	}

	public static void main(String[] args) {

		
		
		ArrayList<Card> cards = new ArrayList<>();
		cards.add(new Card(Suit.CLUBS, Rank.TWO, false));
		cards.add(new Card(Suit.CLUBS, Rank.THREE, false));
		cards.add(new Card(Suit.CLUBS, Rank.FOUR, false));
		cards.add(new Card(Suit.DIAMONDS, Rank.TWO, false));
		cards.add(new Card(Suit.DIAMONDS, Rank.THREE, false));
		cards.add(new Card(Suit.DIAMONDS, Rank.FOUR, false));
		cards.add(new Card(Suit.HEARTS, Rank.TWO, false));
		cards.add(new Card(Suit.HEARTS, Rank.THREE, false));
		cards.add(new Card(Suit.HEARTS, Rank.FOUR, false));
		
//		Pile fkn = new Pile();
		
		int tot = 0;
		
		for (int i = 0; i < 4000; i ++) {
		
			Pile pile = new Pile(cards);
			long t1 = System.nanoTime();
			pile.pickCardsAt(2, 2);
			long t2 = System.nanoTime();
			tot += (i < 1000 || i > 3000) ? 0 : (t2 - t1); 
			//System.out.println(t2 - t1);
			
			System.out.println(pile);
		}
		System.out.println(tot);

//		System.out.println(pile);
//		
//		Pile pile2 = pile.pickCardsAt(10, 5);
//		
////		Pile pile2 = new Pile(pile.getList().subList(0, 3));
////		pile.getList().subList(0, 3).clear();
//		
//		pile.getCardsAt(3, 2).toggleFaceUp();
//		
//		System.out.println(pile);
//		System.out.println(pile2);
	}

}
