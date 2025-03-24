package ch35.Gun;

import ch35.Unit.Unit;

public abstract class Gun {
	int maxBullitCnt;
	int curBullitCnt;
	int power;
	
	public abstract void fire(Unit unit);
	public abstract void reload(int bullit);
}
