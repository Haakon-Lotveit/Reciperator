package no.haakon.begynnelse;

import java.util.Collection;
import java.util.Comparator;

import lombok.Value;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparing;

@Value
public class IngredientGroup implements Comparable<IngredientGroup> {
	private final static Comparator<IngredientGroup> comparator = comparingInt(IngredientGroup::getRank).thenComparing(comparing(IngredientGroup::getName));
	
	private final String name;
	private final int rank;
	private final Collection<Ingredient> ingredients;
	
	@Override
	public int compareTo(IngredientGroup other) {
		return comparator.compare(this, other);
	}
	
	public IngredientGroup(int rank, String name, Collection<Ingredient> ingredients) {
		this.rank = rank;
		this.name = name;
		this.ingredients = new ListUtils<Ingredient>().toUnmodifiableList(ingredients);
	}
	
}
