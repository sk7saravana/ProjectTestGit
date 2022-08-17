package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adacitinJunit.BaseJ;
import com.junitadactin.Baseclass;

public class BookingConfirmationPage extends Baseclass {
	

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderno;

	public WebElement getTxtOrderno() {
		return txtOrderno;
	}
	
	public void orderId(String value) {
		elementgetAttributevalue(getTxtOrderno(),value);
	}

}
