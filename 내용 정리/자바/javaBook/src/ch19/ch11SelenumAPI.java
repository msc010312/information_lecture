package ch19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ch11SelenumAPI {
	private static final String WEB_DRIVER_ID="webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH="src/drivers/chromedriver.exe";
	
	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
//		op.addArguments("--headless"); // 백그라운드 실행
//		op.addArguments("--no-sandbox"); // 리눅스환경 sendbox 사용여부
		
		WebDriver dv = new ChromeDriver(op);
		dv.get("http://www.naver.com");
		
		WebElement searchEl = dv.findElement(By.id("query"));
		
		searchEl.sendKeys("노트북");
		
		searchEl.sendKeys(Keys.RETURN);
		
		WebElement shoppingBtn = dv.findElement(By.cssSelector(".api_pcpg_wrap .tab:nth-child(1)"));
		
		JavascriptExecutor js = (JavascriptExecutor)dv;
		js.executeScript("arguments[0].removeAttribute('target')", shoppingBtn);
		
		shoppingBtn.click();
	}

}
