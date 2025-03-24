package ch35.Unit;

public abstract class Unit {
	public int hp;
	public int amor;
	public String type;
	
	public abstract void move();
	public abstract void UnderAttack(int damage);
}
