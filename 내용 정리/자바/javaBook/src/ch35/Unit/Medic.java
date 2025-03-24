package ch35.Unit;

public class Medic extends Unit {
	private int HealingPoint;
	
	public Medic() {
		hp = 100;
		amor = 100;
		HealingPoint = 30;
	}
	
	void setType(String type) {
		this.type = type;
	}
	
	public void Healing(Unit unit) {
		unit.hp+=HealingPoint;
		System.out.print("");
	}
	
	@Override
	public void move() {
	}

	@Override
	public void UnderAttack(int damage) {
	}

}
