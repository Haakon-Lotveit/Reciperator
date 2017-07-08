package no.haakon.begynnelse;

import java.util.Comparator;

import lombok.Value;

@Value
public final class Instruction implements Comparable<Instruction>{
	private final static Comparator<Instruction> comparator = Comparator.comparingInt(Instruction::getRank).thenComparing(Comparator.comparing(Instruction::getInstruction));
	private final String instruction;
	private final int rank;
	
	public Instruction(int rank, String instruction) {
		this.rank = rank;
		this.instruction = instruction;
	}

	@Override
	public int compareTo(Instruction other) {
		return comparator.compare(this, other);
	}
	
}
