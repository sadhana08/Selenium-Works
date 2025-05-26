package Practice.SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsPractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeopt = new ChromeOptions();
		chromeopt.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver(chromeopt);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Alert
		driver.findElement(By.xpath("//button[contains(text(), 'Alert')]")).click();
		Alert alertpopup = driver.switchTo().alert();
		alertpopup.accept();
		String expectedAlertString = "You successfully clicked an alert";
		String resultAlertString = driver.findElement(By.id("result")).getText();
		
		if(resultAlertString.contains(expectedAlertString)) {
			System.out.println("Alert successful");
		}
		else {
			System.out.println("Alert failed");
		}
		
		//JS Confirm - Click Cancel
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		alertpopup.dismiss();
		
		String expectedConfirmString = "You clicked: Cancel";
		String resultConfirmString = driver.findElement(By.id("result")).getText();
		
		if(resultConfirmString.contains(expectedConfirmString)) {
			System.out.println("Confirm successful");
		}
		else {
			System.out.println("Confirm failed");
		}
		
		//JS Prompt
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(), 'Prompt')]")).click();
		alertpopup.sendKeys("Prompt");
		alertpopup.accept();
		
		String expectedPromptString = "You entered: Prompt";
		String resultPromptString = driver.findElement(By.id("result")).getText();
		
		if(resultPromptString.contains(expectedPromptString)) {
			System.out.println("Prompt successful");
		}
		else {
			System.out.println("Prompt failed");
		}
		
		driver.close();
	}

}
