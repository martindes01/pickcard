package io.github.martindes01.pickcard;

/**
 * Suit is the public enumeration of card suits.
 * <p>
 * Each enum constant encapsulates two fields.<br>
 * The {@code String} {@link #name} is returned using {@link #toString()}.<br>
 * The {@link Colour} {@link #colour} is returned using {@link #getColour()}. 
 * <p>
 * The available enum constants are:
 * <ul>
 * <li>{@link #CLUBS}
 * <li>{@link #DIAMONDS}
 * <li>{@link #HEARTS}
 * <li>{@link #SPADES}
 * </ul>
 * 
 * @author Martin de Spirlet
 * @version 1.0
 * @see Card
 * @since 1.0
 */
public enum Suit {
	
	/**
	 * {@link Suit}{@code .values()[0]}
	 * <p>
	 * {@code name : "Clubs"}<br>
	 * {@code colour : }{@link Colour#BLACK}
	 */
	CLUBS("Clubs", Colour.BLACK),
	
	/**
	 * {@link Suit}{@code .values()[1]}
	 * <p>
	 * {@code name : "Diamonds"}<br>
	 * {@code colour : }{@link Colour#RED}
	 */
	DIAMONDS("Diamonds", Colour.RED),
	
	/**
	 * {@link Suit}{@code .values()[2]}
	 * <p>
	 * {@code name : "Hearts"}<br>
	 * {@code colour : }{@link Colour#RED}
	 */
	HEARTS("Hearts", Colour.RED),
	
	/**
	 * {@link Suit}{@code .values()[3]}
	 * <p>
	 * {@code name : "Spades"}<br>
	 * {@code colour : }{@link Colour#BLACK}
	 */
	SPADES("Spades", Colour.BLACK);
	
	
	// Fields
	
	/**
	 * The name of this suit.
	 * This is a primitive field.
	 */
	private final String name;
	
	/**
	 * The colour of this suit.
	 * This is a reference to an immutable object.
	 */
	private final Colour colour;
	
	
	// Constructors
	
	/**
	 * Constructs a new suit with the specified name and colour.
	 * 
	 * @param name - the name of this suit
	 * @param colour - the colour of this suit
	 */
	Suit(String name, Colour colour) {
		this.name = name;
		this.colour = colour;
	}
	
	
	// Overrides
	
	/**
	 * Returns a string representation of this suit.
	 * This is the formatted name of this suit.
	 * 
	 * @return a string representation of this suit
	 */
	@Override
	public String toString() {
		return name;
	}
	
	
	// Getters
	
	/**
	 * Returns the colour of this suit.
	 * 
	 * @return the colour of this suit
	 */
	public Colour getColour() {
		return colour;
	}
	
}
