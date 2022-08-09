package com.assignment.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.managers.Utilities;

public class AlleCloudwisersPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//div/h1")
	WebElement header;
	
	@FindBy(xpath="//div[@class='flip-box-back']//a")
	List<WebElement> department_links;
	
	@FindBy(xpath="//div[@class='flip-box-front'][contains(@style,'image')]//h3")
	List<WebElement> names;
	
	@FindBy(xpath="//span[text()=' » ']//a[text()='Alle Cloudwisers']")
	WebElement alleCloudWisers_navLink;
	
	
	final String deptlink = "(//div[@class='flip-box-back']//a)";
	
	public AlleCloudwisersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHeaderText()
	{
		Utilities.waitForElementToLoad(driver, header);
		return header.getText();
	}
	
	public Map<String,Integer> getNameCounts()
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int index=getDeptCount();
		for(int i=1;i<=index;i++)
		{
			WebElement dept = Utilities.returnIndexedElement(driver,deptlink , i);
			Utilities.hoverOnElement(driver, dept);
			try
			{
				dept.click();
			}
			catch(Exception e)
			{
				Utilities.jsScrollDown(driver, 200);
				dept.click();
			}
			for(WebElement name:names)
			{
				String val = name.getText();
				if(map.containsKey(val))
					map.put(val, map.get(val)+1);
				else
					map.put(val, 1);
			}
			alleCloudWisers_navLink.click();		
			
		}
		return map;
	}
	
	public int getDeptCount()
	{
		return department_links.size();
	}
	
}
