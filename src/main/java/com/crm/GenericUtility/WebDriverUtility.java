package com.crm.GenericUtility;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtility {
 
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	public void waitforPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void waitUntillElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(String Text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(Text);
	}
	
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	public void rightClick(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
		
	}
	 
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	 
	//public  void enterKeyPress(WebDriver driver)
//	{
//		Actions act=new Actions(driver);
//		act.sendKeys(Keys.ENTER);
//	}
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
		
	}
	
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
		
	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void canacelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWnidow(WebDriver driver,String partialTitle)
	{
		//step1:use getWindowHandles to capture all window Id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2:iterate through windows
		Iterator<String> it = windows.iterator();
		
		//step3:check whether there is next window
		while(it.hasNext()) 
		{
			//step4:capture current window id
			String winId = it.next();
			
			//step5:switch to current window to capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6:check whether window is expected
			if(currentWinTitle.contains(partialTitle))
			{
		       break;
			}		
	     }
	}	
	
	public static String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenShotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
         return path;            	
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("Window.scrollBy(0,800)","");
	}
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
		
		
}
