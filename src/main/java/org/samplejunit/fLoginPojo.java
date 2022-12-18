package org.samplejunit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fLoginPojo extends BaseClass{
	public fLoginPojo() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="//input[@aria-label='Email or phone']")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pwd;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement btn;

	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getBtn() {
		return btn;
	}
	
	
}
	
	