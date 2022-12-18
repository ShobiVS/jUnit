package org.samplejunit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Ssnew extends BaseClass {
	public static void main(String[] args) {
		browser();
		launchUrl("https://en-gb.facebook.com/");
		windowMaximize();
		fLoginPojo f=new fLoginPojo();
	    
	    passtext("Shobi", f.getEmail());
	    
		
	}
	

}
