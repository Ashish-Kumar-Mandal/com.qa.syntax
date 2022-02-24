package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPage {
	WebDriver driver;
	
	// Category of items.	
	@FindBy(id="searchDropdownBox")
	WebElement category;
	
	public boolean isCategorySelected() {
		return category.isSelected();
	}
	
	public void setCategory(String categoryName) {
		Select selectCategory = new Select(category);
		selectCategory.selectByVisibleText(categoryName);
	}

	// Search TextBox.	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextField;
	
	public boolean isDisplayedSearchTextField() {
		return searchTextField.isDisplayed();
	}
	
	public void setSearchTextField(String itemName) {
		searchTextField.clear();
		searchTextField.sendKeys(itemName);
	}
			
	/*
	 * Absolute-xpath = "/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"
	 * Relative-xpath = "//*[@id=\"nav-search-submit-button\"]"
	 */
	
	// Search Button.
	@FindBy(xpath="//*[@id=\"nav-search-submit-button\"]")
	WebElement searchButton;
		
	public boolean isEnabledSearchButton() {
		return searchButton.isEnabled();
	}

	public void clickSearchButton() {
		searchButton.click();
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> itemsName;
	
	public List<WebElement> getItemsName(){
		return itemsName;
	}
	
	public int noOfItems() {
		return itemsName.size();
	}
	
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> footerLinks;
	
	public List<WebElement> getFooterLinks(){
		return footerLinks;
	}
	
	@FindBy(id="nav-link-accountList")
	WebElement accountAndLists;
	
	public WebElement getAccountAndLists() {
		return accountAndLists;
	}
	
	@FindBy(linkText="Start here.")
	WebElement startHHereLink;
	
	public void clickStartHereLink() {
		startHHereLink.click();
	}
	
	// Constructor.
	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
