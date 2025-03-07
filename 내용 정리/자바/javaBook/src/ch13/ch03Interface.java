package ch13;

import java.util.Scanner;

interface Remote {
	Scanner sc = new Scanner(System.in);
	int MAX_VOL=100; //public static final
	int MIN_VOL=1;
	void setVolumn(int vol);
	void PowerOn(); //abstract
	void PowerOff();
}

interface Browser {
	void SearchURL(String url);
}

class TV implements Remote {
	@Override
	public void PowerOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void PowerOff() {
		System.out.println("TV를 끕니다");
	}
	
	@Override
	public void setVolumn(int vol) {
		if(vol>MAX_VOL) {
			vol = MAX_VOL;
			System.out.printf("티비볼륨을 %d으로 설정합니다",vol);
		} else if(vol<MIN_VOL) {
			vol = MIN_VOL;
			System.out.printf("티비볼륨을 %d으로 설정합니다",vol);
		} else {
			System.out.printf("티비의 현재 볼륨은 %d입니다",vol);
		}
	}

}

class SmartTv extends TV implements Browser {

	@Override
	public void SearchURL(String url) {
		System.out.println(url + "로 이동합니다");
	}
	
}

class Radio implements Remote {

	@Override
	public void PowerOn() {
		System.out.println("라디오를 켭니다");
	}

	@Override
	public void PowerOff() {
		System.out.println("라디오를 끕니다");
	}
	
	@Override
	public void setVolumn(int vol) {
		if(vol>MAX_VOL) {
			vol = MAX_VOL;
			System.out.printf("라디오볼륨을 %d으로 설정합니다",MAX_VOL);
		} else if(vol<MIN_VOL) {
			vol = MIN_VOL;
			System.out.printf("라디오볼륨을 %d으로 설정합니다",MIN_VOL);
		} else {
			System.out.printf("라디오의 현재 볼륨은 %d입니다",vol);
		}
	}

}

public class ch03Interface {

	public static void TurnOn(Remote controller) {
		controller.PowerOn();
	}
	
	public static void TurnOff(Remote controller) {
		controller.PowerOff();
	}
	
	public static void SetVolum(Remote controller) {
		System.out.println("볼륨을 설정하세요");
		int vol = Remote.sc.nextInt();
		controller.setVolumn(vol);
	}
	
	public static void Internet(Browser browser, String url) {
		browser.SearchURL(url);
	}
	
	public static void main(String[] args) {
		TV tv = new TV();
		SmartTv st = new SmartTv();
		Radio radio = new Radio();
		
		TurnOn(tv);
		TurnOn(st);
		TurnOn(radio);
		
		Internet(st,"www.naver.com");
		
		TurnOff(tv);
		TurnOff(radio);
		
		SetVolum(tv);
		SetVolum(radio);
	}

}
