package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adacitinJunit.BaseJ;
import com.junitadactin.Baseclass;

public class LoginPage extends Baseclass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtpassword;
	
	@FindBy(id="login")
	private WebElement btnLogin;
	
	public WebElement gettxtUsername() {
		return txtUsername;
	}

	public WebElement gettxtpassword() {
		return txtpassword;
	}
	public WebElement getbtnLogin() {
		return btnLogin;
	}
	
	public void login(String userName,String pasword) {
		elementSendKeys(gettxtUsername(),userName);
		elementSendKeys(gettxtpassword(),pasword);
		elementclick(getbtnLogin());
		
	}

	
}
