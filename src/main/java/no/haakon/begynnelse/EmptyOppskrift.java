package no.haakon.begynnelse;

import java.util.LinkedList;
import java.util.List;

public enum EmptyOppskrift implements Oppskrift {
	empty;

	@Override
	public String getName() {
		return "[Oppskriftsnavn]";
	}

	@Override
	public String getDifficulty() {
		return "[Vanskelighetsgrad]";
	}

	@Override
	public String getTime() {
		return "[Tid å lage]";
	}

	@Override
	public String getPortions() {
		return "[Antall porsjoner]";
	}

	@Override
	public List<InstructionGroup> getInstructionGroups() {
		return new LinkedList<>();
	}

	@Override
	public List<IngredientGroup> getIngredientGroups() {
			return new LinkedList<>();
	}

}






