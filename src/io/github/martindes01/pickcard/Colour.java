package io.github.martindes01.pickcard;

/**
 * Colour is the public enumeration of suit colours.
 * <p>
 * Each enum constant encapsulates one field.<br>
 * The {@code String} {@link #name} is returned using {@link #toString()}. 
 * <p>
 * The available enum constants are:
 * <ul>
 * <li>{@link #BLACK}
 * <li>{@link #BLUE}
 * <li>{@link #GREEN}
 * <li>{@link #RED}
 * <li>{@link #YELLOW} 
 * </ul>
 * 
 * @author Martin de Spirlet
 * @version 1.0
 * @see Card
 * @since 1.0
 */
public enum Colour {
	
	/**
	 * {@link Colour}{@code .values()[0]}
	 * <p>
	 * {@code name : "Black"}
	 */
	BLACK("Black"),
	
	/**
	 * {@link Colour}{@code .values()[1]}
	 * <p>
	 * {@code name : "Blue"}
	 */
	BLUE("Blue"),
	
	/**
	 * {@link Colour}{@code .values()[2]}
	 * <p>
	 * {@code name : "Green"}
	 */
	GREEN("Green"),
	
	/**
	 * {@link Colour}{@code .values()[3]}
	 * <p>
	 * {@code name : "Red"}
	 */
	RED("Red"),
	
	/**
	 * {@link Colour}{@code .values()[4]}
	 * <p>
	 * {@code name : "Yellow"}
	 */
	YELLOW("Yellow");
	
	
	// Fields
	
	/**
	 * The name of this colour.
	 * This is a primitive field.
	 */
	private final String name;
	
	
	// Constructors
	
	/**
	 * Constructs a new colour with the specified name.
	 * 
	 * @param name - the name of this colour
	 */
	Colour(String name) {
		this.name = name;
	}
	
	
	// Overrides
	
	/**
	 * Returns a string representation of this colour.
	 * This is the formatted name of this colour.
	 * 
	 * @return a string representation of this colour
	 */
	@Override
	public String toString() {
		return name;
	}
	
}
