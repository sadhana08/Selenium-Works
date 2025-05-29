package Practice.SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FramesPractice {

	@Test
	public void main() throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		//chromeOptions.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		//Goto the website
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//1st Frame
		driver.switchTo().frame(0);
		driver.findElement(By.name("mytext1")).sendKeys("Frame1");
		driver.switchTo().defaultContent();
		
		//2nd Frame
		driver.switchTo().frame(1);
		driver.findElement(By.name("mytext2")).sendKeys("Frame2");
		driver.switchTo().defaultContent();
		
		//3rd Frame
		driver.switchTo().frame(2);
		
		//Accessing iframe within the frame
		WebElement formFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(formFrame);
		driver.findElement(By.xpath("//span[text()='Other:']")).click();
		driver.findElement(By.xpath("//span[text()='Choose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@role='option'])[2]")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.name("mytext3")).sendKeys("Frame3");
		driver.switchTo().defaultContent();
		
		//4th Frame
		driver.switchTo().frame(3);
		driver.findElement(By.name("mytext4")).sendKeys("Frame4");
		driver.switchTo().defaultContent();
		
		//5th Frame
		driver.switchTo().frame(4);
		driver.findElement(By.linkText("https://a9t9.com")).click();
			
	}

}
