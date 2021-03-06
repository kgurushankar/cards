package com.kgurushankar.cards;

import java.util.Arrays;
import java.util.Collections;

public class Deck {
	Card[] cards;

	public Deck() {
		this(1);
	}

	/**
	 * size is the number of (52 card) decks that make up this deck (size 2
	 * would be 104 cards, 3 would be 156, etc.)
	 */
	public Deck(int size) {
		cards = new Card[52 * size];
		String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
		for (int decks = 1; decks <= size; decks++) {
			for (int suit = 1; suit <= 4; suit++) {
				for (int number = 1; number <= 13; number++) {
					cards[(suit - 1) * 13 + (number - 1)] = new Card(number, suits[suit - 1]);
				}
			}
		}
	}
	/**Allows for custom decks*/
	public Deck(Card[] cards){
		this.cards = cards; 
	}

	public void ShuffleDeck() {
		Collections.shuffle(Arrays.asList(cards));
	}

	/** Returns the first card from the deck and removes it from the deck */
	public Card draw() {
		for (int i = 0; true; i++) {
			if (cards[i] != null) {
				Card temp = cards[i];
				cards[i] = null;
				return temp;
			}
		}
	}

	/** Returns a random card from the deck and removes it from the deck */
	public Card randomDraw() {
		while (true) {
			int i = (int) (Math.random() * cards.length);
			if (cards[i] != null) {
				Card temp = cards[i];
				cards[i] = null;
				return temp;
			}
		}
	}

	/**
	 * Returns a random card from the deck without removing it from the deck
	 */
	public Card selectRandom() {
		while (true) {
			int i = (int) (Math.random() * cards.length);
			if (cards[i] != null) {
				return cards[i];
			}
		}
	}

	/**
	 * Returns the first card from the deck without removing it from the deck
	 */
	public Card select() {
		for (int i = 0; true; i++) {
			if (cards[i] != null) {
				return cards[i];
			}
		}
	}
}
