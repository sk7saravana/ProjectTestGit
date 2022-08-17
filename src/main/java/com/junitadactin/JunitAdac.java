package com.junitadactin;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.adacitinJunit.BaseJ;

public class JunitAdac extends BaseJ {
	
	@BeforeClass
	public static void beforeclass() {
		gettingDriver();
		enterUrl("http://adactinhotelapp.com/");
		maximizewindow();
	}
	 
	@Test
	public void login() throws IOException, InterruptedException {
		WebElement eleusrname = elementById("username");
		String usrname = getDataFromExcel("Sheet1",1,0);
		elementSendKeys(eleusrname,usrname);
		
		WebElement elepassname = elementById("password");
		String passname = getDataFromExcel("Sheet1",1,1);
		elementSendKeys(elepassname,passname);
		
		WebElement btnLogin = elementById("login");
		btnLogin.click();
		Thread.sleep(1000);
		WebElement elewelcomemsg = elementById("username_show");
		String actualmsg = elementgetAttributeValue(elewelcomemsg);
		Assert.assertEquals("Verify Welcome Msg after LOgin", "Hello Sravana1996!", actualmsg);
		
		//HOTEL SEARCH
		
		WebElement locelement = elementById("location");
		String locname = getDataFromExcel("Sheet1", 1, 2);
		ddSelectByVisibleText(locelement, locname);
		
		WebElement elehotel = elementById("hotels");
		String hotelname = getDataFromExcel("Sheet1", 1, 3);
		ddSelectByVisibleText(elehotel, hotelname);
		
		WebElement elermtype = elementById("room_type");
		String  rmtype = getDataFromExcel("Sheet1", 1, 4);
		ddSelectByVisibleText(elermtype, rmtype);
		
		WebElement eleroomno = elementById("room_nos");
		String  rmno = getDataFromExcel("Sheet1", 1, 5);
		ddSelectByVisibleText(eleroomno, rmno);
		
		WebElement eledatein = elementById("datepick_in");
		cleartext(eledatein);
		String  datein = getDataFromExcel("Sheet1", 1, 6);
		elementSendKeys(eledatein, datein);
		
		WebElement eledateout = elementById("datepick_out");
		cleartext(eledateout);
		String  dateout = getDataFromExcel("Sheet1", 1, 7);
		elementSendKeys(eledateout, dateout);
		
		WebElement eleadult = elementById("adult_room");
		String  adult = getDataFromExcel("Sheet1", 1, 8);
		ddSelectByVisibleText(eleadult, adult);
		
		WebElement elechildrm = elementById("child_room");
		String  childrm = getDataFromExcel("Sheet1", 1, 9);
		ddSelectByVisibleText(elechildrm, childrm);
		
		WebElement elesubmit = elementById("Submit");
		elementclick(elesubmit);
		
		Thread.sleep(2000);
		WebElement eleselecthotel = elementByClassName("login_title");
		String actualms2 = elementGetText(eleselecthotel);
		Assert.assertEquals("Verify Select Hotel", "Select Hotel" , actualms2);
		
		//Search Hotel Verification
		
		WebElement eleradio = elementById("radiobutton_0");
		elementclick(eleradio);
		
		WebElement elecnt = elementById("continue");
		elementclick(elecnt);
		
		Thread.sleep(3000);
		WebElement elebookhotel = elementByxpath("(//td[@class='login_title'])[2]");
		String actualms3 = elementGetText(elebookhotel);
		Assert.assertEquals("Verify Book Hotel", "Book A Hotel" , actualms3);
		
		//Booking Confirmation
		WebElement elefirstnm = elementById("first_name");
		String  firstnam = getDataFromExcel("Sheet1", 1, 10);
		elementSendKeys(elefirstnm, firstnam);
		
		WebElement elelastnm = elementById("last_name");
		String  last = getDataFromExcel("Sheet1", 1, 11);
		elementSendKeys(elelastnm, last);
		
		WebElement eleaddres = elementById("address");
		String  address = getDataFromExcel("Sheet1", 1, 12);
		elementSendKeys(eleaddres, address);
		
		WebElement elecc = elementById("cc_num");
		String  ccnum = getDataFromExcel("Sheet1", 1, 13);
		elementSendKeys(elecc, ccnum);
		
		WebElement elecctype = elementById("cc_type");
		String  cctype = getDataFromExcel("Sheet1", 1, 14);
		ddSelectByVisibleText(elecctype, cctype);
		
		WebElement eleexpm = elementById("cc_exp_month");
		String  expmn = getDataFromExcel("Sheet1", 1, 15);
		ddSelectByVisibleText(eleexpm, expmn);
		
		WebElement eleexpy = elementByxpath("//select[@name='cc_exp_year']");
		String  expyy = getDataFromExcel("Sheet1", 1, 16);
		ddSelectByValue(eleexpy, expyy);
		
		WebElement elecvv = elementById("cc_cvv");
		String  cvv = getDataFromExcel("Sheet1", 1, 17);
		elementSendKeys(elecvv, cvv);
		
		
		WebElement eleclk = elementById("book_now");
		elementclick(eleclk);
		
		Thread.sleep(5000);
		

		WebElement eleodid = elementById("order_no");
		String attribute = eleodid.getAttribute("value");
		writeDataExcel("Sheet1", 1, 18, attribute);
		
		WebElement elebookconfirm = elementByxpath("//td[@class='login_title']");
		String actualms4 = elementGetText(elebookconfirm);
		Assert.assertEquals("Verify Book confirmation", "Booking Confirmation" , actualms4);
		
		
	}

}
