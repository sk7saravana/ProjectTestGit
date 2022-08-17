package com.pomadactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adacitinJunit.BaseJ;
import com.junitadactin.Baseclass;

public class SearchHotelPage extends Baseclass{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement dDnlocation;
	
	@FindBy(id="hotels")
	private WebElement dDnhotels;
	
	@FindBy(id="room_type")
	private WebElement dDnroomtype;
	
	@FindBy(id="room_nos")
	private WebElement dDnroom_nos;
	
	@FindBy(id="datepick_in")
	private WebElement dDndatepick_in;
	
	@FindBy(id="datepick_out")
	private WebElement dDndatepick_out;
	
	@FindBy(id="adult_room")
	private WebElement dDnadult_room;
	
	@FindBy(id="child_room")
	private WebElement dDnchild_room;
	
	@FindBy(id="Submit")
	private WebElement btnsubmit;

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getdDnhotels() {
		return dDnhotels;
	}

	public WebElement getdDnroomtype() {
		return dDnroomtype;
	}

	public WebElement getdDnroom_nos() {
		return dDnroom_nos;
	}

	public WebElement getdDndatepick_in() {
		return dDndatepick_in;
	}

	public WebElement getdDndatepick_out() {
		return dDndatepick_out;
	}

	public WebElement getdDnadult_room() {
		return dDnadult_room;
	}

	public WebElement getdDnchild_room() {
		return dDnchild_room;
	}

	public WebElement getBtnsubmit() {
		return btnsubmit;
	}
	
	public void searchHotel(String location, String hotel , String roomtype, String roomno,String datein, String dateout,String adultperroom,String childperroom) {
	
		ddSelectByVisibleText(getdDnlocation(),location);
		ddSelectByVisibleText(getdDnhotels(),hotel);
		ddSelectByVisibleText( getdDnroomtype(),roomtype);
		ddSelectByVisibleText(getdDnroom_nos(),roomno);	
		cleartext(getdDndatepick_in());
		elementSendKeys(getdDndatepick_in(),datein);
		cleartext(getdDndatepick_out());
		elementSendKeys(getdDndatepick_out(),dateout);
		ddSelectByVisibleText(getdDnadult_room(),adultperroom);
		ddSelectByVisibleText(getdDnchild_room(),childperroom);
		elementclick(getBtnsubmit());
		

}
}
