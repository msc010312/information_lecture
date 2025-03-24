package ch35.Building;

import ch35.Unit.Marine;
import ch35.Unit.Unit;

public class MarineGenerator implements UnitGenerator {

	@Override
	public Unit gen() {
		return new Marine();
	}

}
