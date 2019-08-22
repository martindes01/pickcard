package io.github.martindes01.pickcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// TODO simplify index checking, see https://stackoverflow.com/questions/12099721/how-to-use-sublist

// TODO javadoc
public class Pile {
	
	// Fields
	
	/**
	 * The {@link ArrayList} of {@link Card} objects wrapped by this pile.
	 * This is a reference to a mutable object.
	 */
	private ArrayList<Card> cards;
	
	
	// Constructors
	
	/**
	 * Constructs a new pile containing an empty {@link ArrayList}.
	 */
	public Pile() {
		cards = new ArrayList<>();
	}
	
	/**
	 * Constructs a new pile containing the specified {@link Collection} of {@link Card} objects.
	 * The specified collection is stored as an {@link ArrayList} in this pile.
	 * 
	 * @param collection - the collection of cards to be wrapped by this pile
	 * @see Card
	 */
	public Pile(Collection<Card> collection) {
		cards = new ArrayList<>(collection);
	}
	
	
	// Helper functions
	
	/**
	 * Returns the most relevant index within the bounds of this pile, inclusive.
	 * Returns {@code 0} if the size of this pile is {@code 0}.
	 * <p>
	 * An index already within the bounds of this pile is left unchanged.
	 * An index greater than or equal to the size of this pile returns the upper bound.
	 * An index less than or equal to the negative of the size of this pile returns {@code 0}.
	 * Any other negative index returns the sum of the size of this pile and itself.
	 * 
	 * @param index - the index to be placed within the bounds of this pile
	 * @param useSize - whether to use the size of this pile as its upper bound
	 * @return the most relevant index within the bounds of this pile, inclusive 
	 */
	private int wrapIndex(int index, boolean useSize) {
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		if (size == 0) {
			// Return 0 if size is 0
			return 0;
		} else {
			if (index >= 0) {
				if (index < size) {
					// Return index if already within bounds (index >= 0 && index < size)
					return index;
				} else {
					// Return most relevant upper bound if (index >= size)
					return size + (useSize ? 0 : -1);
				}
			} else {
				if (index > -size) {
					// Return wrapped index if (index > -size && index < 0)
					return size + index;
				} else {
					// Return 0 if (index <= -size)
					return 0;
				}
			}
		}
	}
	
	
	// Card addition
	
	/** 
	 * Places the specified card on top of this pile.
	 * 
	 * @param card - card to be added
	 * @return the new size of this pile 
	 */
	public int addCard(Card card) {
		cards.add(card);
		return cards.size();		
	}
	
	/**
	 * Inserts the specified card at the specified position in this pile.
	 * Pushes the card currently at that position (if any) and any cards above it towards the top of this pile (adds {@code 1} to their indices).
	 * <p>
	 * An index greater than or equal to the size of this pile causes the card to be placed on top.
	 * An index less than or equal to the negative of the size of this pile causes the card to be placed on the bottom.
	 * Any other negative index specifies the position from the top of this pile. 
	 * 
	 * @param index - index at which the specified card is to be inserted
	 * @param card - card to be inserted
	 * @return the new size of this pile 
	 * @see #wrapIndex(int, boolean)
	 */
	public int addCardAt(int index, Card card) {
		// Prevent IndexOutOfBoundsException (index may be equal to size)
		cards.add(wrapIndex(index, true), card);
		return cards.size();
	}
	
	/**
	 * Places the cards in the specified collection on top of this pile.
	 * 
	 * @param collection - collection containing cards to be added to this pile
	 * @return the new size of this pile
	 */
	public int addCards(Collection<Card> collection) {
		// Prevent NullPointerException (thrown if collection null)
		if (collection != null) { 
			cards.addAll(collection); 
		} 
		return cards.size();
	}
	
	/**
	 * Inserts the cards in the specified collection at the specified position in this pile.
	 * Pushes the cards currently at that position (if any) and any cards above them towards the top of this pile (increases their indices).
	 * <p>
	 * An index greater than or equal to the size of this pile causes the cards to be placed on top.
	 * An index less than or equal to the negative of the size of this pile causes the cards to be placed on the bottom.
	 * Any other negative index specifies the position from the top of this pile. 
	 * 
	 * @param index - index at which the first card from the specified collection is to be inserted
	 * @param collection - collection containing cards to be inserted
	 * @return the new size of this pile
	 * @see #wrapIndex(int, boolean)
	 */
	public int addCardsAt(int index, Collection<Card> collection) {
		// Prevent NullPointerException (thrown if collection null)
		if (collection != null) { 
			// Prevent IndexOutOfBoundsException (index may be equal to size)
			cards.addAll(wrapIndex(index, true), collection);
		} 
		return cards.size();
	}
	
	
	// Card inclusion
	
	/**
	 * Returns {@code true} if this pile contains the specified card.
	 * 
	 * @param card - card whose presence in this pile is to be tested
	 * @return {@code true} if this pile contains the specified card
	 */
	public boolean containsCard(Card card) {
		return cards.contains(card);
	}
	
	/**
	 * Returns {@code true} if this pile contains at least one of each of the cards in the specified collection.
	 * Returns {@code false} if the specified collection is {@code null}.
	 * 
	 * @param collection - collection whose cards are to be checked for containment in this pile
	 * @return {@code true} if this pile contains at least one of each of the cards in the specified collection
	 */
	public boolean containsCards(Collection<Card> collection) {
		// Prevent NullPointerException (thrown if collection null)
		if (collection != null) {
			return cards.containsAll(collection);
		} else {
			// Return false if collection null
			return false;			
		}
	}
	
	
	// Card deletion
	
	/**
	 * Deletes all occurrences of the specified card from this pile, if present.
	 * If this pile does not contain the card, it is unchanged.
	 * Returns {@code true} if this pile changed as a result of the call. 
	 * 
	 * @param card - card to be deleted from this pile, if present
	 * @return {@code true} if this pile changed as a result of the call
	 */
	public boolean deleteAllOfType(Card card) {
		return cards.removeAll(Collections.singleton(card));
	}
	
	/**
	 * Deletes from this pile all of its cards that appear at least once in the specified collection.
	 * If this pile does not contain any of the cards, it is unchanged.
	 * Returns {@code true} if this pile changed as a result of the call. 
	 * 
	 * @param collection - collection containing cards to be deleted from this pile, if present
	 * @return {@code true} if this pile changed as a result of the call
	 */
	public boolean deleteAllOfTypes(Collection<Card> collection) {
		// Prevent NullPointerException (thrown if collection null)
		if (collection != null) {
			return cards.removeAll(collection);
		} else {			
			// Return false if collection null
			return false;
		}
	}
	
	/**
	 * Deletes the uppermost occurrence of the specified card from this pile, if present.
	 * If this pile does not contain the card, it is unchanged.
	 * Returns {@code true} if this pile changed as a result of the call.
	 * 
	 * @param card - card to be deleted from this pile, if present
	 * @return {@code true} if this pile changed as a result of the call
	 */
	public boolean deleteHighestOfType(Card card) {
		int lastIndex = cards.lastIndexOf(card);
		// Prevent IndexOutOfBoundsException
		if (lastIndex != -1) {
			cards.remove(lastIndex);
			return true;
		} else {
			// Return false if card not present
			return false;
		}
	}
	
	/**
	 * Deletes the lowermost occurrence of the specified card from this pile, if present.
	 * If this pile does not contain the card, it is unchanged.
	 * Returns {@code true} if this pile changed as a result of the call.
	 * 
	 * @param card - card to be deleted from this pile, if present
	 * @return {@code true} if this pile changed as a result of the call
	 */
	public boolean deleteLowestOfType(Card card) {
		return cards.remove(card);
	}
	
	
	// Card identification
	
	/**
	 * Returns a reference to the card at the top of this pile.
	 * Changes to the returned card are reflected in this pile, and vice-versa.
	 * <p>
	 * A deep copy of the returned card can be obtained by calling {@link Card#copy()} on the returned card.
	 * 
	 * @return a reference to the card at the top of this pile
	 * @throws IndexOutOfBoundsException if this pile is empty {@code (size() == 0)}
	 */
	public Card getCard() {
		return cards.get(cards.size() - 1);
	}
	
	/**
	 * Returns a reference to the card at the specified position in this pile.
	 * Changes to the returned card are reflected in this pile, and vice-versa.
	 * <p>
	 * An index greater than or equal to the size of this pile returns the top card.
	 * An index less than or equal to the negative of the size of this pile returns the bottom card.
	 * Any other negative index specifies the position from the top of this pile.
	 * <p>
	 * A deep copy of the returned card can be obtained by calling {@link Card#copy()} on the returned card.
	 * 
	 * @param index - index of the card to return
	 * @return a reference to the card at the specified position in this pile
	 * @throws IndexOutOfBoundsException if this pile is empty {@code (size() == 0)}
	 * @see #wrapIndex(int, boolean)
	 */
	public Card getCardAt(int index) {
		// Prevent IndexOutOfBoundsException
		return cards.get(wrapIndex(index, false));
	}
		
	/**
	 * Returns a pile containing references to the specified quantity of cards from the top of this pile.
	 * Non-structural changes in the returned pile are reflected in this pile, and vice-versa.
	 * If the specified quantity is greater than or equal to the size of this pile, a copy of this pile is returned.
	 * <p>
	 * A deep copy of the returned pile can be obtained by calling {@link #copy()} on the returned pile.
	 * 
	 * @param quantity - number of cards to return
	 * @return a pile containing references to the specified quantity of cards from the top of this pile
	 * @throws IllegalArgumentException if {@code quantity} is negative {@code (quantity < 0)}
	 */
	public Pile getCards(int quantity) {
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		if (quantity < size) {
			return new Pile(cards.subList(size - quantity, size));
		} else {
			// Return copy if quantity greater than or equal to size
			return this;
		}
	}
	
	/**
	 * Returns a pile containing references to the specified quantity of cards from the specified position in this pile.
	 * This pile is unchanged.
	 * Non-structural changes in the returned pile are reflected in this pile, and vice-versa.
	 * If the sum of the specified index and quantity is greater than or equal to the size of this pile, the card at the specified index and all cards above it are returned.
	 * <p>
	 * An index greater than or equal to the size of this pile returns the top card.
	 * An index less than or equal to the negative of the size of this pile returns the specified quantity of cards from the bottom of this pile.
	 * Any other negative index specifies the position from the top of this pile.
	 * <p>
	 * A deep copy of the returned pile can be obtained by calling {@link #copy()} on the returned pile.
	 * 
	 * @param index - index of the first card to be returned
	 * @param quantity - number of cards to return
	 * @return a pile containing references to the specified quantity of cards from the specified position in this pile
	 * @throws IllegalArgumentException if {@code quantity} is negative {@code (quantity < 0)}
	 * @see #wrapIndex(int, boolean)
	 */
	public Pile getCardsAt(int index, int quantity) {
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		// Prevent IndexOutOfBoundsException
		index = wrapIndex(index, false);
		if (index + quantity > size) {
			quantity = size - index;
		}
		return new Pile(cards.subList(index, index + quantity));
	}
	
	
	// Card location
	
	/**
	 * Returns the index of the uppermost occurrence of the specified card in this pile, or {@code -1} if this pile does not contain the card.
	 * 
	 * @param card - card for which to search
	 * @return the index of the uppermost occurrence of the specified card in this pile, or {@code -1} if this pile does not contain the card
	 */
	public int highestIndexOf(Card card) {
		return cards.lastIndexOf(card);
	}
	
	/**
	 * Returns the index of the uppermost occurrence of the specified card in this pile, searching downwards from fromIndex, exclusive; or {@code -1} if this pile does not contain the card. 
	 * <p>
	 * A fromIndex greater than or equal to the size of this pile causes the search to be performed over the entire pile.
	 * A fromIndex less than or equal to the negative of the size of this pile causes the search to be performed over an empty pile and returns {@code -1}.
	 * Any other negative fromIndex specifies the position from the top of this pile.
	 * 
	 * @param card - card for which to search
	 * @param fromIndex - index before which to start the search
	 * @return the index of the uppermost occurrence of the specified card in this pile, searching downwards from fromIndex, exclusive; or {@code -1} if this pile does not contain the card
	 * @see #wrapIndex(int, boolean)
	 */
	public int highestIndexOf(Card card, int fromIndex) {
		// Prevent IndexOutOfBoundsException (index may be equal to size)
		return cards.subList(0, wrapIndex(fromIndex, true)).lastIndexOf(card);
	}
	
	/**
	 * Returns the index of the lowermost occurrence of the specified card in this pile, or {@code -1} if this pile does not contain the card.
	 * 
	 * @param card - card for which to search
	 * @return the index of the lowermost occurrence of the specified card in this pile, or {@code -1} if this pile does not contain the card
	 */
	public int lowestIndexOf(Card card) {
		return cards.indexOf(card);
	}
	
	/**
	 * Returns the index of the lowermost occurrence of the specified card in this pile, searching upwards from fromIndex, inclusive; or {@code -1} if this pile does not contain the card.
	 * <p>
	 * A fromIndex greater than or equal to the size of this pile causes the search to be performed over an empty pile and returns {@code -1}.
	 * A fromIndex less than or equal to the negative of the size of this pile causes the search to be performed over the entire pile.
	 * Any other negative fromIndex specifies the position from the top of this pile.
	 * 
	 * @param card - card for which to search
	 * @param fromIndex - index at which to start the search
	 * @return the index of the lowermost occurrence of the specified card in this pile, searching upwards from fromIndex, inclusive; or {@code -1} if this pile does not contain the card
	 * @see #wrapIndex(int, boolean)
	 */
	public int lowestIndexOf(Card card, int fromIndex) { 
		// Prevent IndexOutOfBoundsException (index may be equal to size)
		return cards.subList(wrapIndex(fromIndex, true), cards.size()).indexOf(card);
	}
	
	
	// Card removal
	
	/**
	 * Make it so!
	 * <p>
	 * Removes a card from the top of this pile.  
	 *  
	 * @return the card that was removed from this pile
	 * @throws IndexOutOfBoundsException if this pile is empty {@code (size() == 0)}
	 */
	public Card pickCard() {
		return cards.remove(cards.size() - 1);
	}
	
	/**
	 * Removes a card from the specified position in this pile.
	 * Lowers any cards above it (subtracts one from their indices).
	 * <p>
	 * An index greater than or equal to the size of this pile causes the top card to be removed from this pile.
	 * An index less than or equal to the negative of the size of this pile causes the bottom card to be removed from this pile. 
	 * Any other negative index specifies the position from the top of this pile.
	 * 
	 * @param index - index of the card to be removed
	 * @return the card that was removed from this pile
	 * @throws IndexOutOfBoundsException if this pile is empty {@code (size() == 0)}
	 * @see #wrapIndex(int, boolean)
	 */
	public Card pickCardAt(int index) {
		// Prevent IndexOutOfBoundsException
		return cards.remove(wrapIndex(index, false));
	}
	
	/**
	 * Make them so!
	 * <p>
	 * Removes the specified quantity of cards from the top of this pile.
	 * If the specified quantity is greater than or equal to the size of this pile, a copy of this pile is returned and the original is emptied.
	 * 
	 * @param quantity - number of cards to remove
	 * @return a pile containing the cards that were removed from this pile
	 * @throws IllegalArgumentException if {@code quantity} is negative {@code (quantity < 0)}
	 */
	public Pile pickCards(int quantity) {
		Pile pile;
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		// Prevent IndexOutOfBoundsException (index may be equal to size)
		if (quantity < size) {
			// Store cards.subList() as local variable to avoid multiple method calls
			List<Card> subList = cards.subList(size - quantity, size);
			pile = new Pile(subList);
			subList.clear();
		} else {
			// Return copy and empty original if quantity greater than or equal to size
			pile = new Pile(cards);
			cards.clear();
		}
		return pile;
	}
	
	/**
	 * Removes the specified quantity of cards from the specified position in this pile.
	 * Lowers any cards above them (decreases their indices).
	 * If the sum of the specified index and quantity is greater than or equal to the size of this pile, the card at the specified index and all cards above it are removed.
	 * <p>
	 * An index greater than or equal to the size of this pile causes the top card to be removed from this pile.
	 * An index less than or equal to the negative of the size of this pile causes the specified quantity of cards to be removed from the bottom of this pile.
	 * Any other negative index specifies the position from the top of this pile.
	 * 
	 * @param index - index of the first card to be removed
	 * @param quantity - number of cards to remove
	 * @return a pile containing the cards that were removed from this pile
	 * @throws IllegalArgumentException if {@code quantity} is negative {@code (quantity < 0)}
	 * @see #wrapIndex(int, boolean)
	 */
	public Pile pickCardsAt(int index, int quantity) {
		Pile pile;
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		// Prevent IndexOutOfBoundsException
		index = wrapIndex(index, false);
		if (index + quantity > size) {
			quantity = size - index;
		}
		// Store cards.subList() as local variable to avoid multiple method calls
		List<Card> subList = cards.subList(index, index + quantity);
		pile = new Pile(subList);
		subList.clear();
		return pile;
	}
	
	
	// Pile copying
		
	/**
	 * Returns a deep copy of this pile.
	 * Null cards in this pile will be copied to the returned pile.
	 * <p>
	 * A pile contains an {@link ArrayList} of mutable {@link Card} objects.
	 * Each card in this pile is copied and added to a new list.
	 * A new pile is constructed from this list and returned.
	 * Since a shallow copy of a card functions the same as a deep copy, the returned pile is a deep copy of this pile.
	 * Changes to the returned pile will not be reflected in this pile, nor will changes to this pile be reflected in the returned pile.
	 * 
	 * @return a deep copy of this instance of the {@code Pile} class
	 * @see Card
	 * @see Card#copy()
	 */
	public Pile copy() {
		ArrayList<Card> copiedCards = new ArrayList<>(cards.size());
		for (Card card : cards) {
			// Prevent NullPointerException (thrown if card null)
			if (card != null) {
				copiedCards.add(card.copy());
			} else {
				copiedCards.add(null);
			}
		}
		return new Pile(copiedCards);
	}
	
	
	// Pile manipulation
	
	/**
	 * Reverses the order of the cards in this pile.
	 * 
	 * @see Collections#reverse(java.util.List)
	 */
	public void reverse() {
		Collections.reverse(cards);
	}

	/**
	 * Sets the face visibility of the cards in this pile to the specified state. 
	 * 
	 * @param faceUp - whether the faces of the cards in this pile should be visible  
	 */
	public void setFaceUp(boolean faceUp) {
		for (Card card : cards) {
			// Prevent NullPointerException (thrown if card null)
			if (card != null) {
				card.setFaceUp(faceUp);
			}
		}
	}
	
	/**
	 * Shuffles this pile.
	 * Randomly permutes this pile using a default source of randomness.
	 * All permutations occur with approximately equal likelihood.
	 * 
	 * @see Collections#shuffle(java.util.List)
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Returns the number of cards in this pile.
	 * 
	 * @return the number of cards in this pile
	 */
	public int size() {
		return cards.size();
	}
	
	/**
	 * Sorts this pile according to the order induced by the specified comparator.
	 * This sort is guaranteed to be stable: equal cards will not be reordered as a result of the sort. 
	 * 
	 * @param comparator - the comparator to determine the order of the pile
	 * @see Collections#sort(java.util.List, java.util.Comparator) 
	 * @see CardComparator
	 */
	public void sort(CardComparator comparator) {
		Collections.sort(cards, comparator.getComparator());
	}
	
	/**
	 * Toggles the face visibility of the cards in this pile.
	 * Cards that are face up will be turned face down, and cards that are face down will be turned face up. 
	 */
	public void toggleFaceUp() {
		for (Card card : cards) {
			// Prevent NullPointerException (thrown if card null)
			if (card != null) {
				card.setFaceUp(!card.isFaceUp());
			}
		}
	}
	
	
	// Overrides 
	
	/**
	 * Returns a string representation of this pile.
	 * This is a formatted string containing the number of cards in this pile and the string representation of each card.
	 * Each card appears on a new line with its index.
	 * Cards are appended in reverse order so that cards at the top of a pile appear at the top of the list.
	 * 
	 * @return a string representation of this pile.
	 * @see Card#toString()
	 */
	@Override
	public String toString() {
		String str = "Pile of " + cards.size() + " card";
		// Store cards.size() as local variable to avoid multiple method calls
		int size = cards.size();
		// Handle empty, singular and plural cases
		switch (size) {
		case 0:
			str += "s";
			break;
		case 1:
			str += ":";
			break;
		default:
			str += "s:";
		}
		// Print cards in reverse order
		for (int i = size - 1; i >= 0; i-- ) {
			if (cards.get(i) != null) {
				str += String.format("\n  %7d   :\t%s", i, cards.get(i).toString());
			} else {
				str += String.format("\n  %7d   : %s", i, "( NULL )");
			}
		}
		return str;
	}
	
	
	// Getters
	
	/**
	 * Exposes the {@link ArrayList} of {@link Card} objects wrapped by this instance of the {@link Pile} class.
	 * 
	 * @return the {@code ArrayList} of {@code Card} objects wrapped by this instance of the {@code Pile} class 
	 */
	public ArrayList<Card> getList() {
		return cards;
	}
	
}
