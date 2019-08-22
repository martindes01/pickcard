package io.github.martindes01.pickcard;

// TODO javadoc
public class Card {
	
	// Fields
	
	/**
	 * The {@link Suit} of this card.
	 * This is a reference to an immutable object.
	 */
	private Suit suit;
	
	/**
	 * The {@link Rank} of this card.
	 * This is a reference to an immutable object.
	 */
	private Rank rank;
	
	// TODO Consider enum ViewableBy
	/**
	 * The face visibility of this card.
	 * This is a primitive field.
	 */
	private boolean faceUp;
	
	
	// Constructors
	
	/**
	 * Constructs a new card with the specified suit, rank and face visibility.
	 * 
	 * @param suit - suit to set as the suit of this card
	 * @param rank - rank to set as the rank of this card
	 * @param faceUp - whether the face of this card should be visible
	 */
	public Card(Suit suit, Rank rank, boolean faceUp) {
		this.suit = suit;
		this.rank = rank;
		this.faceUp = faceUp;
	}
	
	
	// Card copying
	
	/**
	 * Returns a copy of this card.
	 * <p>
	 * A card contains only primitive fields and references to immutable objects.
	 * Hence, a shallow copy of this card functions the same as a deep copy.
	 * Changes to the returned card will not be reflected in this card, nor will changes to this card be reflected in the returned card.
	 * 
	 * @return a copy of this instance of the {@code Card} class
	 */
	public Card copy() {
		return new Card(suit, rank, faceUp);
	}
	
	
	// Card manipulation
	
	/**
	 * Toggles the face visibility of this card.
	 */
	public void toggleFaceUp() {
		faceUp = !faceUp;
	}
	
	// Overrides
	
	/**
	 * Returns a string representation of this card.
	 * This is a formatted string containing the rank, suit and face visibility of this card.
	 * 
	 * @return a string representation of this card 
	 */
	@Override
	public String toString() {
		return String.format("%-8s   of   %-8s ( face %-4s )", rank.name(), suit.name(), faceUp ? "up" : "down");		
	}

	
	// Getters

	/**
	 * Returns the face visibility of this card.
	 * 
	 * @return true if the face of this card is visible
	 */
	public boolean isFaceUp() {
		return faceUp;
	}
	
	/**
	 * Returns the rank of this card.
	 * 
	 * @return the rank of this card
	 * @see Rank
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Returns the suit of this card.
	 * 
	 * @return the suit of this card
	 * @see Suit
	 */
	public Suit getSuit() {
		return suit;
	}
	
	
	// Setters
	
	/**
	 * Sets the face visibility of this card.
	 * 
	 * @param faceUp - whether the face of this card should be visible
	 */
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	/**
	 * Sets the rank of this card to the specified rank.
	 * 
	 * @param rank - rank to set as the rank of this card
	 * @see Rank
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/**
	 * Sets the suit of this card to the specified suit.
	 * 
	 * @param suit - suit to set as the suit of this card 
	 * @see Suit
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
