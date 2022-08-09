package com.assignment.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class Utilities {
	
	public static void waitForElementToLoad(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
	}
	
	public static void waitForElementToBeClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void hoverOnElement(WebDriver driver,WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
	}
	
	public static byte[] takeScreenshot(WebDriver driver,Scenario scenario)
	{
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
	}
	
	public static void clickOnElementAction(WebDriver driver,WebElement ele)
	{
		Actions ac = new Actions(driver);
		ac.click(ele).build().perform();
	}
	
	public static void presenceOfEle(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
	}
	
	public static List<String> getDuplicates(Map<String,Integer> map)
	{
		List<String> duplicates = new ArrayList<String>();
		
		for(Map.Entry<String, Integer> m:map.entrySet())
		{
			if(m.getValue()>1)
				duplicates.add(m.getKey());
		}
		
		return duplicates;
	}
	
	public static WebElement returnIndexedElement(WebDriver driver,String xpath,Integer index)
	{
		WebElement ele = driver.findElement(By.xpath(xpath+"["+index+"]"));
		return ele;
	}
	
	public static void jsScrollDown(WebDriver driver,int value)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+value+")", "");
	}
	
	public static void jsClick(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
}
