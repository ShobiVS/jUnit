package org.samplejunit;




import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



public class SampleProject extends BaseClass{
	@Test
	public void tc1() {
		System.out.println("Test Case-1");
		launchUrl("https://gmail.com");
		String url = pageUrl();
		String title = pageTitle();
	    fLoginPojo f=new fLoginPojo();
	    passtext("shobivs@gmail.com",f.getEmail());
	    Assert.assertEquals("Check your gmail", url, url.contains("id"));
	    
	    
	
	   
	
	}
	
	@Ignore
	@Test
	public void tc3() {
		System.out.println("Test Case-3");
		launchUrl("https://inmakes.com/");
		}
    
	@Before
	public void startDate() {
		Date d=new Date();
		System.out.println(d);
		}
	
	@After
	public void endDate() {
		Date d=new Date();
	}
	@Ignore
	@Test
	public void tc2() {
		System.out.println("Test Case-2");
		launchUrl("https://en-gb.facebook.com/");
	}
	@Ignore
	@Test
	public void tc4() {
		System.out.println("Test Case-4");
		launchUrl("https://www.youtube.com/");

	}
	@Ignore
	@Test
	public void tc5() {
		System.out.println("Test Case-5");

	}
	@BeforeClass
	public static void launchBrowser() {
		browser();
		windowMaximize();
		
		System.out.println("Browser Launch");
		}
	@AfterClass
	public static void closeTheBrowser() {
		
	}
	
}
