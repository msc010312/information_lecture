package ch35.Building;

import ch35.Unit.Medic;
import ch35.Unit.Unit;

public class MedicGenerator implements UnitGenerator {

	@Override
	public Unit gen() {
		return new Medic();
	}

}