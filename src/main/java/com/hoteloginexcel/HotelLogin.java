package com.hoteloginexcel;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class HotelLogin {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Base log = new Base();
		log.gettingDriver();
		log.enterUrl("http://adactinhotelapp.com/");
		log.maximizewindow();
		
		WebElement idelement = log.elementById("username");
		String usrname = log.getDataFromExcel("Sheet1", 1, 0);
		log.elementSendKeys(idelement, usrname);
		
		String passname = log.getDataFromExcel("Sheet1", 1, 1);
		WebElement pswrd = log.elementById("password");
		log.elementSendKeys(pswrd, passname);
		
		
		WebElement clkelement = log.elementById("login");
		log.elementclick(clkelement);
		
		WebElement locelement = log.elementById("location");
		String locname = log.getDataFromExcel("Sheet1", 1, 2);
		log.ddSelectByVisibleText(locelement, locname);
		
		WebElement elehotel = log.elementById("hotels");
		String hotelname = log.getDataFromExcel("Sheet1", 1, 3);
		log.ddSelectByVisibleText(elehotel, hotelname);
		
		WebElement elermtype = log.elementById("room_type");
		String  rmtype = log.getDataFromExcel("Sheet1", 1, 4);
		log.ddSelectByVisibleText(elermtype, rmtype);
		
		WebElement eleroomno = log.elementById("room_nos");
		String  rmno = log.getDataFromExcel("Sheet1", 1, 5);
		log.ddSelectByVisibleText(eleroomno, rmno);
		
		WebElement eledatein = log.elementById("datepick_in");
		log.cleartext(eledatein);
		String  datein = log.getDataFromExcel("Sheet1", 1, 6);
		log.elementSendKeys(eledatein, datein);
		
		WebElement eledateout = log.elementById("datepick_out");
		log.cleartext(eledateout);
		String  dateout = log.getDataFromExcel("Sheet1", 1, 7);
		log.elementSendKeys(eledateout, dateout);
		
		WebElement eleadult = log.elementById("adult_room");
		String  adult = log.getDataFromExcel("Sheet1", 1, 8);
		log.ddSelectByVisibleText(eleadult, adult);
		
		WebElement elechildrm = log.elementById("child_room");
		String  childrm = log.getDataFromExcel("Sheet1", 1, 9);
		log.ddSelectByVisibleText(elechildrm, childrm);
		
		WebElement elesubmit = log.elementById("Submit");
		log.elementclick(elesubmit);
		
		WebElement eleradio = log.elementById("radiobutton_0");
		log.elementclick(eleradio);
		
		WebElement elecnt = log.elementById("continue");
		log.elementclick(elecnt);
		
		Thread.sleep(3000);
		WebElement elefirstnm = log.elementById("first_name");
		String  firstnam = log.getDataFromExcel("Sheet1", 1, 10);
		log.elementSendKeys(elefirstnm, firstnam);
		
		WebElement elelastnm = log.elementById("last_name");
		String  last = log.getDataFromExcel("Sheet1", 1, 11);
		log.elementSendKeys(elelastnm, last);
		
		WebElement eleaddres = log.elementById("address");
		String  address = log.getDataFromExcel("Sheet1", 1, 12);
		log.elementSendKeys(eleaddres, address);
		
		WebElement elecc = log.elementById("cc_num");
		String  ccnum = log.getDataFromExcel("Sheet1", 1, 13);
		log.elementSendKeys(elecc, ccnum);
		
		WebElement elecctype = log.elementById("cc_type");
		String  cctype = log.getDataFromExcel("Sheet1", 1, 14);
		log.ddSelectByVisibleText(elecctype, cctype);
		
		WebElement eleexpm = log.elementById("cc_exp_month");
		String  expmn = log.getDataFromExcel("Sheet1", 1, 15);
		log.ddSelectByVisibleText(eleexpm, expmn);
		
		WebElement eleexpy = log.elementByxpath("//select[@name='cc_exp_year']");
		String  expyy = log.getDataFromExcel("Sheet1", 1, 16);
		log.ddSelectByValue(eleexpy, expyy);
		
		WebElement elecvv = log.elementById("cc_cvv");
		String  cvv = log.getDataFromExcel("Sheet1", 1, 17);
		log.elementSendKeys(elecvv, cvv);
		
		
		WebElement eleclk = log.elementById("book_now");
		log.elementclick(eleclk);
		
		Thread.sleep(5000);
		

		WebElement eleodid = log.elementById("order_no");
		String attribute = eleodid.getAttribute("value");
		
		log.writeDataExcel("Sheet1", 1, 18, attribute);
		
		
		
		

	}

}
