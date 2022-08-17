package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adacitinJunit.BaseJ;
import com.junitadactin.Baseclass;

public class SelectHotelPage extends Baseclass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="radiobutton_0")
	private WebElement slctHotelbtn;
	
	@FindBy(id="continue")
	private WebElement slctcontinuebtn;

	public WebElement getSlctHotelbtn() {
		return slctHotelbtn;
	}

	public WebElement getSlctcontinuebtn() {
		return slctcontinuebtn;
	}
	
   public void selectHotel() {
	   elementclick(getSlctHotelbtn());
	   elementclick(getSlctcontinuebtn());
}
}
