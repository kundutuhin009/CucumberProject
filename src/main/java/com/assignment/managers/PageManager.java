package com.assignment.managers;

import org.openqa.selenium.WebDriver;

import com.assignment.pages.AlleCloudwisersPage;
import com.assignment.pages.HomePage;

public class PageManager {
	
	WebDriver driver;
	HomePage homePage;
	AlleCloudwisersPage alleCloudwisersPage;

	public PageManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	
	public AlleCloudwisersPage getAlleCloudWisersPage(){

		return (alleCloudwisersPage == null) ? alleCloudwisersPage = new AlleCloudwisersPage(driver) : alleCloudwisersPage;

	}
}
