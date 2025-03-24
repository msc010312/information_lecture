package ch35.Building;

import java.util.HashMap;
import java.util.Map;

import ch35.Unit.Marine;
import ch35.Unit.Medic;

public class Barrack extends Building {

	// 집합관계
//	UnitGenerator marine;
//	UnitGenerator medic;
//	
//	public Barrack() {
//		marine = new MarineGenerator();
//		medic = new MedicGenerator();
//	}

	// 집약관계
	Map<String, UnitGenerator> generator = new HashMap();

	void setGenerator(UnitGenerator gen, String type) {
		generator.put(type, gen);
	}

	public Marine getMarine() {
		if (!isDestroyed) {
			UnitGenerator gene = generator.get("marine");
			return (Marine) gene.gen();
		} else {
			System.out.println("건물이 파괴되었거나 건설 중입니다");
			return null;
		}
	}

	public Medic getMedic() {
		if (!isDestroyed) {
			UnitGenerator gene = generator.get("Medic");
			return (Medic) gene.gen();
		} else {
			System.out.println("건물이 파괴되었거나 건설 중입니다");
			return null;
		}
	}

	@Override
	public void BuildStructure() {
		System.out.println("건설시작");
		while (amor < 100 || hp == 100 || sheld == 100) {
			try {
				Thread.sleep(100);
				if (amor != 100)
					amor++;
				if (hp != 100)
					hp++;
				if (sheld != 100)
					sheld++;
				System.out.printf("건설 중 / hp = %d amor = %d sheld = %d\n", hp, amor, sheld);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		setGenerator(new MarineGenerator(), "marine");
		setGenerator(new MedicGenerator(), "medic");
		System.out.println("건설완료");
	}

}
