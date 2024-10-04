package org.stepDef;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseInvoke{
	
	WebDriver driver;
	
	
	public void launch(String browse,String site) {
		
		if(browse.equals("chrome")){
			driver= new ChromeDriver();
		}else if(browse.equals("firefox")) {
			driver = new FirefoxDriver();	
		}
		driver.get(site);
	}
	
	public WebElement valueXpath(String xpath) {
		WebElement xpathinput = driver.findElement(By.xpath(xpath));
		return xpathinput;
	}
	
	public WebElement ValueId(String id) {
		WebElement idinput = driver.findElement(By.id(id));
		return idinput;

	}
	
	public WebElement valueName(String name) {
		WebElement nameinput = driver.findElement(By.name(name));
		return nameinput;
	}
	
	public void sendValues(WebElement element,String data) {
		element.sendKeys(data);
	}
	
	public void moveToelement(String xpath) {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(xpath));
		action.moveToElement(element).perform();
		
	}
	
	public WebElement dynamicStop(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));
		return until;	

	}
	
	public WebElement switchToFrames(int framenumber,String xpath) {
		WebDriver frame = driver.switchTo().frame(framenumber);
		WebElement element = frame.findElement(By.xpath(xpath));
		return element;

	}
	
	 void screenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);

	}
	
	
	
}
