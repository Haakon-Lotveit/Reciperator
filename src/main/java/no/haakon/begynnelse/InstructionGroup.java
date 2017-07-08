package no.haakon.begynnelse;

import java.util.Collection;
import java.util.Comparator;

import lombok.Value;

@Value
public final class InstructionGroup implements Comparable<InstructionGroup> {
	private final Comparator<InstructionGroup> comparator = Comparator.comparingInt(InstructionGroup::getRank).thenComparing(InstructionGroup::getName);
	
	private final String name;	
	private final int rank;
	private final Collection<Instruction> instructions;
	
	public InstructionGroup(int rank, String name, Collection<Instruction> instructions) {
		this.rank = rank;
		this.name = name;
		this.instructions = new ListUtils<Instruction>().toUnmodifiableList(instructions);
	}

	@Override
	public int compareTo(InstructionGroup other) {
		return comparator.compare(this, other);
	}
	
	
}
