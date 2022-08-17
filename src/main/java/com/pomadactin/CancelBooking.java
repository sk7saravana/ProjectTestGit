package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.junitadactin.Baseclass;

public class CancelBooking extends Baseclass {
	
	public CancelBooking(){
    PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement txtlinkbookeditenary;
	
	@FindBy(id="order_id_text")
	private WebElement txtorderidbox;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnsearch;
	
	@FindBy(xpath="//input[@name='ids[]']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@name='cancelall']")
	private WebElement btncancel;

	public WebElement getTxtlinkbookeditenary() {
		return txtlinkbookeditenary;
	}

	public WebElement getTxtorderidbox() {
		return txtorderidbox;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getBtncancel() {
		return btncancel;
	}
	

	public void cancelbooked(String orderidExcel) throws InterruptedException {
		elementclick(getTxtlinkbookeditenary());
		Thread.sleep(2000);
		elementSendKeys(getTxtorderidbox(),orderidExcel);
		elementclick(getBtnsearch());
		elementclick(getCheckbox());
		elementclick(getBtncancel());
		alertAccept();
	}


}
