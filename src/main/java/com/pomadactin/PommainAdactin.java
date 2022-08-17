package com.pomadactin;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.junitadactin.Baseclass;

public class PommainAdactin extends Baseclass{

	
	@BeforeClass
	public static void LaunchBrowser() {
		gettingDriver();
		maximizewindow();
		enterUrl("http://adactinhotelapp.com/");
	}
	
	
	
	@Test
	public void test1() throws IOException {
		String usrname = getDataFromExcel("Sheet1",1,0);
		String passname = getDataFromExcel("Sheet1",1,1);
		LoginPage l = new LoginPage();
		l.login(usrname, passname);
		WebElement elewelcomemsg = elementById("username_show");
		String actualmsg = elementgetAttributeValue(elewelcomemsg);
		Assert.assertEquals("Verify Welcome Msg after LOgin", "Hello Sravana1996!", actualmsg);
		System.out.println("Login Page Test Succesfull");
	}
	
	@Test
	public void test2() throws IOException {
		String locname = getDataFromExcel("Sheet1", 1, 2);
		String hotelname = getDataFromExcel("Sheet1", 1, 3);
		String  rmtype = getDataFromExcel("Sheet1", 1, 4);
		String  rmno = getDataFromExcel("Sheet1", 1, 5);
		String  datein = getDataFromExcel("Sheet1", 1, 6);
		String  dateout = getDataFromExcel("Sheet1", 1, 7);
		String  adult = getDataFromExcel("Sheet1", 1, 8);
		String  childrm = getDataFromExcel("Sheet1", 1, 9);
		
		SearchHotelPage s = new SearchHotelPage();
		s.searchHotel(locname, hotelname, rmtype, rmno, datein, dateout, adult, childrm);
		
		WebElement eleselecthotel = elementByClassName("login_title");
		String actualms2 = elementGetText(eleselecthotel);
		Assert.assertEquals("Verify Select Hotel", "Select Hotel" , actualms2);
		System.out.println("Search hotel Page Test Succesfull");
	}
	
	@Test
	public void test3() {
		SelectHotelPage select = new SelectHotelPage();
		select.selectHotel();
		
		WebElement elebookhotel = elementByxpath("(//td[@class='login_title'])[2]");
		String actualms3 = elementGetText(elebookhotel);
		Assert.assertEquals("Verify Book Hotel", "Book A Hotel" , actualms3);
		System.out.println("Select Hotel Page Test Succesfull");
	}
	
	@Test
	public void test4() throws IOException, InterruptedException {
		String  firstnam = getDataFromExcel("Sheet1", 1, 10);
		String  last = getDataFromExcel("Sheet1", 1, 11);
		String  address = getDataFromExcel("Sheet1", 1, 12);
		String  ccnum = getDataFromExcel("Sheet1", 1, 13);
		String  cctype = getDataFromExcel("Sheet1", 1, 14);
		String  expmn = getDataFromExcel("Sheet1", 1, 15);
		String  expyy = getDataFromExcel("Sheet1", 1, 16);
		String  cvv = getDataFromExcel("Sheet1", 1, 17); 
		
		BookHotelPage book = new BookHotelPage();
		book.bookHotelpage(firstnam, last, address, ccnum, cctype, expmn, expyy, cvv);
		
		Thread.sleep(6000);
		WebElement eleodid = elementById("order_no");
		String attribute = eleodid.getAttribute("value");
		writeDataExcel("Sheet1", 1, 18, attribute);
		WebElement elebookconfirm = elementByxpath("//td[@class='login_title']");
		String actualms4 = elementGetText(elebookconfirm);
		Assert.assertEquals("Verify Book confirmation", "Booking Confirmation" , actualms4);
		System.out.println("Book Hotel Page Test Succesfull");
	}
	
	@Test
	public void test5() throws IOException, InterruptedException {
		CancelBooking cancel = new CancelBooking();
		String orderidExcel = getDataFromExcel("Sheet1", 1, 18);
		cancel.cancelbooked(orderidExcel);
		System.out.println("Cancel Hotel Page Test Succesfull");
	}
	
	
	
}
