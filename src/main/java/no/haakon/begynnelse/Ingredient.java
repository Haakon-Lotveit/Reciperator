package no.haakon.begynnelse;

import java.util.Comparator;

import lombok.Value;

import static java.util.Comparator.comparingInt;

@Value
public class Ingredient implements Comparable<Ingredient> {
	private final static Comparator<Ingredient> comparator = comparingInt(Ingredient::getRank).thenComparing(Ingredient::getIngredient);
	
	private final String ingredient;
	private final int rank;
	
	@Override
	public int compareTo(Ingredient other) {
		return comparator.compare(this, other);
	}

	public Ingredient(String ingredient, int rank) {
		this.ingredient = ingredient;
		this.rank = rank;
	}
	
	public Ingredient(int rank, String ingredient) {
		this(ingredient, rank);
	}
}
