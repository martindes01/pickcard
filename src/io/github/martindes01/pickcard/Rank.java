package io.github.martindes01.pickcard;

/**
 * Rank is the public enumeration of card ranks.
 * <p>
 * Each enum constant encapsulates two fields.<br>
 * The {@code String} {@link #name} is returned using {@link #toString()}.<br>
 * The {@code int} {@link #value} is returned using {@link #getValue()}. 
 * <p>
 * The available enum constants are:
 * <ul>
 * <li>{@link #TWO}
 * <li>{@link #THREE}
 * <li>{@link #FOUR}
 * <li>{@link #FIVE}
 * <li>{@link #SIX}
 * <li>{@link #SEVEN}
 * <li>{@link #EIGHT}
 * <li>{@link #NINE}
 * <li>{@link #TEN}
 * <li>{@link #ELEVEN}
 * <li>{@link #TEN}
 * <li>{@link #JACK}
 * <li>{@link #QUEEN}
 * <li>{@link #KING}
 * <li>{@link #ACE}
 * </ul>
 * 
 * @author Martin de Spirlet
 * @version 1.0
 * @see Card
 * @since 1.0
 */
public enum Rank {
	
	/**
	 * {@link Rank}{@code .values()[0]}
	 * <p>
	 * {@code name : "Two"}<br>
	 * {@code value : 2}
	 */
	TWO("Two", 2),
	
	/**
	 * {@link Rank}{@code .values()[1]}
	 * <p>
	 * {@code name : "Three"}<br>
	 * {@code value : 3}
	 */
	THREE("Three", 3),
	
	/**
	 * {@link Rank}{@code .values()[2]}
	 * <p>
	 * {@code name : "Four"}<br>
	 * {@code value : 4}
	 */
	FOUR("Four", 4),
	
	/**
	 * {@link Rank}{@code .values()[3]}
	 * <p>
	 * {@code name : "Five"}<br>
	 * {@code value : 5}
	 */
	FIVE("Five", 5),
	
	/**
	 * {@link Rank}{@code .values()[4]}
	 * <p>
	 * {@code name : "Six"}<br>
	 * {@code value : 6}
	 */
	SIX("Six", 6),
	
	/**
	 * {@link Rank}{@code .values()[5]}
	 * <p>
	 * {@code name : "Seven"}<br>
	 * {@code value : 7}
	 */
	SEVEN("Seven", 7),
	
	/**
	 * {@link Rank}{@code .values()[6]}
	 * <p>
	 * {@code name : "Eight"}<br>
	 * {@code value : 8}
	 */
	EIGHT("Eight", 8),
	
	/**
	 * {@link Rank}{@code .values()[7]}
	 * <p>
	 * {@code name : "Nine"}<br>
	 * {@code value : 9}
	 */
	NINE("Nine", 9),
	
	/**
	 * {@link Rank}{@code .values()[8]}
	 * <p>
	 * {@code name : "Ten"}<br>
	 * {@code value : 10}
	 */
	TEN("Ten", 10),
	
	/**
	 * {@link Rank}{@code .values()[9]}
	 * <p>
	 * {@code name : "Jack"}<br>
	 * {@code value : 11}
	 */
	JACK("Jack", 11),
	
	/**
	 * {@link Rank}{@code .values()[10]}
	 * <p>
	 * {@code name : "Queen"}<br>
	 * {@code value : 12}
	 */
	QUEEN("Queen", 12),
	
	/**
	 * {@link Rank}{@code .values()[11]}
	 * <p>
	 * {@code name : "King"}<br>
	 * {@code value : 13}
	 */
	KING("King", 13),
	
	/**
	 * {@link Rank}{@code .values()[12]}
	 * <p>
	 * {@code name : "Ace"}<br>
	 * {@code value : 1}
	 */
	ACE("Ace", 1);
	
	
	// Fields
	
	/**
	 * The name of this rank.
	 * This is a primitive field.
	 */
	private final String name;
	
	/**
	 * The value of this rank.
	 * This is a primitive field.
	 */
	private final int value;
	
	
	// Constructors
	
	/**
	 * Constructs a new rank with the specified name and value.
	 * 
	 * @param name - name of this rank
	 * @param value - value of this rank
	 */
	Rank(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	
	// Overrides
	
	/**
	 * Returns a string representation of this rank.
	 * This is the formatted name of this rank.
	 * 
	 * @return a string representation of this rank
	 */
	@Override
	public String toString() {
		return name;
	}
	
	
	// Getters
	
	/**
	 * Returns the value of this rank.
	 * 
	 * @return the value of this rank
	 */
	public int getValue() {
		return value;
	}
	
}
