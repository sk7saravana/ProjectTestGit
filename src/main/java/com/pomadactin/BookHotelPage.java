package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adacitinJunit.BaseJ;
import com.junitadactin.Baseclass;

public class BookHotelPage extends Baseclass {
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstname;
	
	@FindBy(id="last_name")
	private WebElement txtlastname;
	
	@FindBy(id="address")
	private WebElement txtaddress;
	
	@FindBy(id="cc_num")
	private WebElement txtcc_num;
	
	@FindBy(id="cc_type")
	private WebElement dDncctype;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnExpmonth;
	
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement dDnExpyear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtcvv;
	
	@FindBy(id="book_now")
	private WebElement btnbook;

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcc_num() {
		return txtcc_num;
	}

	public WebElement getdDncctype() {
		return dDncctype;
	}

	public WebElement getdDnExpmonth() {
		return dDnExpmonth;
	}

	public WebElement getdDnExpyear() {
		return dDnExpyear;
	}

	public WebElement getTxtcvv() {
		return txtcvv;
	}

	public WebElement getBtnbook() {
		return btnbook;
	}
	
	public void bookHotelpage(String firstname,String lastname,String address,String ccnum,String cctype,String expmonth,String expyear,String cvv) {
		elementSendKeys(getTxtFirstname(),firstname);
		elementSendKeys(getTxtlastname(),lastname);
		elementSendKeys(getTxtaddress(),address);
		elementSendKeys(getTxtcc_num(),ccnum);
		ddSelectByVisibleText(getdDncctype(),cctype);
		ddSelectByVisibleText(getdDnExpmonth(),expmonth);
		ddSelectByVisibleText(getdDnExpyear() ,expyear);
		elementSendKeys(getTxtcvv(),cvv);
		elementclick(getBtnbook());
		
		
	}

}
