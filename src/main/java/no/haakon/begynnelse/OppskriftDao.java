package no.haakon.begynnelse;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OppskriftDao {
	private static final Oppskrift retVal = new OppskriftDTO(
			"Biff og Fløtegratinerte Poteter", 
			"Middels", 
			"90 minutter", 
			"4",
			asList(
					new InstructionGroup(1, "Fløtegratinerte Poteter", asList(
							new Instruction(1, "Sett ovenen på 150 grader"),
							new Instruction(2, "Skrell og skiv potetene i tynne jevne skiver, ca 2mm."),
							new Instruction(3, "kok opp melk, fløte og hvitløk."),
							new Instruction(4, "Riv litt muskattnøtt oppi blandingen."),
							new Instruction(5, "kok potetskivene i melkeblandingen i noen minutter. De skal fortsatt være faste."),
							new Instruction(6, "Smak til med salt og evt. pepper."),
							new Instruction(7, "Fordel kaldt smør over toppen, og stek i ovn på 150 grader i ca. en time."),
							new Instruction(8, "Ta ut når overflaten er gyllenbrun. Om resten av maten ikke er klar, kle med folie."))),

					new InstructionGroup(2, "Biff", asList(
							new Instruction(10, "Husk at biffen må romtempereres før steking for best resultat, så ta den ut en time før du begynner å lage mat."),
							new Instruction(11, "Legg en ildfast form i ovnen før du begynner å steke."),
							new Instruction(12, "Skjær løken i ringer."),
							new Instruction(13, "Dryss pepper på biffen."),
							new Instruction(14, "Varm smøret til det blir nøttebrunt og er ferdig med å skumme."),
							new Instruction(15, "Ta ut formen, og kle den med aluminiumsfolie."),
							new Instruction(16, "Stek en og en biff, Snu når kjøttsaften pipler opp, og stek ca. like lenge på begge sider. Sjekk med fingeren (Du er ute etter en spenstig biff)."),
							new Instruction(17, "Legg ferdigstekt biff i form, dekk til med folie. De skal ligge sammen."),
							new Instruction(18, "Når alle biffene er stekt, legg til mer smør om nødvendig og la løken kose seg i ti minutter."),
							new Instruction(19, "Server potetene, biffen, og løken, og kos dere!")))),
			asList(
					new IngredientGroup(2, "Biff", asList(
							new Ingredient(0, "800g biff (200g per stykke)"),
							new Ingredient(1, "Ekte meierismør laget av melk"),
							new Ingredient(2, "1 løk"),
							new Ingredient(3, "Salt og pepper"))),
					
					new IngredientGroup(1, "Fløtegratinerte poteter", asList(
							new Ingredient(4, "3 dl kremfløte"),
							new Ingredient(5, "2 dl helmelk"),
							new Ingredient(6, "1 fedd hvitløk"),
							new Ingredient(7, "Muskatnøtt"),
							new Ingredient(8, "1 knivspiss kajennepepper"),
							new Ingredient(9, "1kg nypoteter"),
							new Ingredient(10," 80g kaldt smør"),
							new Ingredient(11," salt og pepper")))));

			public Optional<Oppskrift> loadWithUuid(String uuid) {
		try {
			UUID id = UUID.fromString(uuid);
			return loadWithUuid(id);
		}
		catch(IllegalArgumentException iae) {
			return Optional.empty();
		}
	}

	public Optional<Oppskrift> loadWithUuid(UUID uuid) {
		return Optional.of(retVal);
	}

	public static class OppskriftDTO implements Oppskrift {
		private final static ListUtils<InstructionGroup> listUtilInstructions = new ListUtils<>();
		private final static ListUtils<IngredientGroup> listUtilIngredients= new ListUtils<>();

		private final String recipeName, difficulty, time, portions;
		private final List<InstructionGroup> instructionGroups;
		private final List<IngredientGroup> ingredientGroups;

		public OppskriftDTO(String recipeName, String difficulty, String time, String portions, Collection<InstructionGroup> instructionGroups, Collection<IngredientGroup> ingredientGroups) {
			this.recipeName = recipeName;
			this.difficulty = difficulty;
			this.time = time;
			this.portions = portions;

			this.instructionGroups = listUtilInstructions.toUnmodifiableList(instructionGroups);
			this.ingredientGroups = listUtilIngredients.toUnmodifiableList(ingredientGroups);

		}

		@Override
		public String getName() {
			return recipeName;
		}

		@Override
		public String getDifficulty() {
			return difficulty;
		}

		@Override
		public String getTime() {
			return time;
		}

		@Override
		public String getPortions() {
			return portions;
		}

		@Override
		public List<InstructionGroup> getInstructionGroups() {
			return instructionGroups;
		}

		@Override
		public List<IngredientGroup> getIngredientGroups() {
			return ingredientGroups;
		}

	}
}
