package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.assignment.managers.Utilities;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//li[@id='menu-item-6352']/a[text()='Dit is Cloudwise']")
	WebElement disItCloudwise_link;
	
	@FindBy(xpath="//a[text()='Allow all cookies ']")
	WebElement acceptBtn;
	
	@FindBy(xpath="//h3[text()='Alle Cloudwisers']/following-sibling::a")
	WebElement alleCloudwise_link;
	
	@FindBy(xpath="//h1[text()='Alle Cloudwisers']")
	WebElement alleClouwise_header;
	
	@FindBy(xpath="//a//span[text()='Devices voor jouw school']")
	WebElement devices_link;
	
	@FindBy(xpath="//div[@class='row-bg-wrap instance-2']")
	WebElement clients_link;
	
	@FindBy(xpath="//h2[text()='Ontdek Cloudwise']")
	WebElement ontekCloudWise_text;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigatetoURL(String url)
	{
		driver.get(url);
		acceptBtn.click();
	}
	
	public void navigateToDitIsCloudWise()
	{
		Utilities.waitForElementToLoad(driver, devices_link);
		disItCloudwise_link.click();
	}
	public void navigateToAlleCloudWisers() {

		Utilities.hoverOnElement(driver, clients_link);
		Utilities.waitForElementToLoad(driver, alleCloudwise_link);
		Utilities.hoverOnElement(driver, alleCloudwise_link);
		alleCloudwise_link.click();
		
	}

}
