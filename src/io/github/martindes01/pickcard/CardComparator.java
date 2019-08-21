package io.github.martindes01.pickcard;

import java.util.Comparator;

/**
 * CardComparator is the public enumeration of card comparators.
 * <p>
 * Each enum constant encapsulates one field.<br>
 * The {@link Comparator} {@link #comparator} is returned using {@link #getComparator()}
 * <p>
 * The available enum constants are:
 * <ul>
 * <li>{@link #BY_RANK_THEN_SUIT}
 * <li>{@link #BY_RANK_THEN_SUIT_REVERSED}
 * <li>{@link #BY_RANK_REVERSED_THEN_SUIT}
 * <li>{@link #BY_RANK_REVERSED_THEN_SUIT_REVERSED}
 * <li>{@link #BY_SUIT_THEN_RANK}
 * <li>{@link #BY_SUIT_THEN_RANK_REVERSED}
 * <li>{@link #BY_SUIT_REVERSED_THEN_RANK}
 * <li>{@link #BY_SUIT_REVERSED_THEN_RANK_REVERSED}
 * </ul>
 * Each card comparator returns a null-friendly comparator that considers {@code null} to be less than non-null.
 * When two cards are {@code null}, they are considered equal.
 * If both are non-null, the specified {@code Comparator} is used to determine the order.
 * <p>
 * The natural ascending order of ranks and suits are determined by the order of their declaration in {@link Rank} and {@link Suit}.
 * The base card comparators {@code BY_RANK_THEN_SUIT} and {@code BY_SUIT_THEN_RANK} are used to sort a pile from bottom to top in ascending order.
 * The other card comparators reverse the order of one or both of the fields {@code rank} and {@code suit}.
 * 
 * @author Martin de Spirlet
 * @version 1.0
 * @see Card
 * @see Pile
 * @since 1.0
 */
public enum CardComparator {
	
	/**
	 * Compares cards by rank, then suit.
	 */
	BY_RANK_THEN_SUIT(Comparator.nullsFirst(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit))),
	
	/**
	 * Compares cards by rank, then suit reversed.
	 */
	BY_RANK_THEN_SUIT_REVERSED(Comparator.nullsFirst(Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit).reversed()))),
	
	/**
	 * Compares cards by rank reversed, then suit.
	 */
	BY_RANK_REVERSED_THEN_SUIT(Comparator.nullsFirst(Comparator.comparing(Card::getRank).reversed().thenComparing(Card::getSuit))),
	
	/**
	 * Compares cards by rank reversed, then suit reversed.
	 */
	BY_RANK_REVERSED_THEN_SUIT_REVERSED(Comparator.nullsFirst(Comparator.comparing(Card::getRank).thenComparing(Card::getSuit).reversed())),
	
	/**
	 * Compares cards by suit, then rank.
	 */
	BY_SUIT_THEN_RANK(Comparator.nullsFirst(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank))),
	
	/**
	 * Compares cards by suit, then rank reversed.
	 */
	BY_SUIT_THEN_RANK_REVERSED(Comparator.nullsFirst(Comparator.comparing(Card::getSuit).thenComparing(Comparator.comparing(Card::getRank).reversed()))),
	
	/**
	 * Compares cards by suit reversed, then rank.
	 */
	BY_SUIT_REVERSED_THEN_RANK(Comparator.nullsFirst(Comparator.comparing(Card::getSuit).reversed().thenComparing(Card::getRank))),
	
	/**
	 * Compares cards by suit reversed, then rank reversed.
	 */
	BY_SUIT_REVERSED_THEN_RANK_REVERSED(Comparator.nullsFirst(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank).reversed()));
	
	
	// Fields
	
	/**
	 * The comparator associated with this {@code CardComparator}.
	 * This is a reference to an immutable object.
	 */
	private final Comparator<Card> comparator;
	
	
	// Constuctors
	
	/**
	 * Constructs a new card comparator with the specified comparator.
	 * 
	 * @param comparator - the comparator associated with this {@code CardComparator}
	 */
	CardComparator(Comparator<Card> comparator) {
		this.comparator = comparator;
	}
	
	
	// Getters
	
	/**
	 * Returns the comparator associated with this {@code CardComparator}.
	 * 
	 * @return the comparator associated with this {@code CardComparator}
	 */
	public Comparator<Card> getComparator() {
		return comparator;
	}
	
}
