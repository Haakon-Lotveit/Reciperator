package no.haakon.begynnelse;

import java.util.List;

public interface Oppskrift {
	public String getName();
	public String getDifficulty();
	public String getTime();
	public String getPortions();
	public List<InstructionGroup> getInstructionGroups();
	public List<IngredientGroup> getIngredientGroups();
	
}
