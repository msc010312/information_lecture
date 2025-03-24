package ch35.Building;

import ch35.Unit.Unit;

public abstract class Building {
	public int hp;
	public int sheld;
	public int amor;
	public boolean isDestroyed;
	
	abstract void BuildStructure();

	void UnderAttack(int damage) {
		// amor-- 0 -> hp--> dead
		if (sheld - damage > 0) {
			this.sheld -= damage;
		} else if (amor - (damage - sheld) > 0) {
			amor = amor - (damage - sheld);
			sheld = 0;
		} else if (hp - (damage - amor) > 0) {
			hp = hp - (damage - amor);
			amor = 0;
		} else {
			hp = 0;
			amor = 0;
			sheld = 0;
			isDestroyed = false;
			System.out.println("파괴되었습니다...");
		}
	}
}
