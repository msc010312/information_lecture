package ch35.Gun;

import ch35.Unit.Unit;

public class Rifle extends Gun {
	public Rifle(){
		this.curBullitCnt = 0;
		this.maxBullitCnt = 50;
		this.power = 30;
	}
	@Override
	public void fire(Unit unit) {
		if(curBullitCnt == 0) {
			System.out.println("재장전 필요");
			return;
		} else {
			unit.UnderAttack(this.power);
			curBullitCnt--;
		}
	}

	@Override
	public void reload(int bullit) {
		if(this.maxBullitCnt>this.curBullitCnt+bullit) {
			this.curBullitCnt+=bullit;
		} else {
			this.curBullitCnt = maxBullitCnt;
		}
	}

}
