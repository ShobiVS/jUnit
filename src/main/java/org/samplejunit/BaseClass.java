package org.samplejunit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	
	public static void browser() {
		 WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title=driver.getTitle();
		return title;
		
	}
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
		}
	
	public static void passtext(String txt, WebElement element) {
		element.sendKeys(txt);
		
		
	}
	public static void clk(String txt,WebElement element) {
		element.click();
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	
	public static void clickBtn(WebElement element) {
		element.click();
	}
	
	public static void screenshot(String imgname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File image=ts.getScreenshotAs(OutputType.FILE);
		File f=new File("location + imgName.png");
		FileUtils.copyFile(image, f);
	}
	
	
	
	public static void moveTheCursor(WebElement targetwebelement) {
	
		Actions a=new Actions(driver);
		a.moveToElement(targetwebelement).perform();
		
	}
	
	public static void dragAndDrop(WebElement dragwebelement, WebElement dropElement) {
		Actions a=new Actions(driver); 
		a.dragAndDrop(dragwebelement, dropElement);
		
	}
	
	public static void ScrollThePage(WebElement targetWebEle) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", targetWebEle);
	}
	
	public static void Scroll(WebElement targetWebEle) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", targetWebEle);
	}
	
	public static <cell> void excelRead(String SheetName, int rowNum,int cellNum) throws IOException {
		File f=new File("excellocation.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet mysheet=wb.getSheet("Data");
		Row r= mysheet.getRow(rowNum);
	    org.apache.poi.ss.usermodel.Cell c=r.getCell(cellNum);
	    int cellType=c.getCellType();
	    String value=" ";
	    if(cellType==1) {
	    	String value2=c.getStringCellValue();
	    	System.out.println(value2);
	    }
	     
	    else if (DateUtil.isCellDateFormatted(c)) {
	    	Date dd=c.getDateCellValue();
	    	SimpleDateFormat s=new SimpleDateFormat();
	    	String value1=s.format(dd);
			
		}
	    
	    else {
	    	double d=c.getNumericCellValue();
	    	long l=(long)d;
	    	String valueOf=String.valueOf(l);
	    }
	}
	    
	    public static void CreateNewExcelFile(int rowNum, int cellNum,String WriteData) throws IOException {
	    	File fi=new File("location.xlsx");
	        Workbook wbk=new XSSFWorkbook();
	    	Sheet createSheet = wbk.createSheet("Data");
	    	Row row = createSheet.createRow(rowNum);
	    	Cell cell = row.createCell(cellNum);
	    	cell.setCellValue("writeData");
	    	FileOutputStream fos= new FileOutputStream(fi);
	    	wbk.write(fos);
	    	
	    	
	    }
	    public static void CreateCell(int rowNum,int CellNum, String Data) throws IOException {
	    	File f=new File("location.xlsx");
	    	Workbook wb=new XSSFWorkbook();
	    	Sheet createSheet = wb.createSheet("Data");
	    	Row r = createSheet.createRow(rowNum);
	    	Cell c = r.createCell(CellNum);
	    	c.setCellValue("Data");
	    	FileOutputStream fos=new FileOutputStream(f);
	    	wb.write(fos);
	    }
	    
	    public static void UpdataDataToParticularCell(int rowNum,int CellNum,String existingData,String NewData) throws IOException {
	    	File f=new File("Excel Location.xlsx");
	    	FileInputStream fis=new FileInputStream(f);
	    	Workbook wb=new XSSFWorkbook();
	    	Sheet createSheet = wb.createSheet("Data");
	    	Row r = createSheet.getRow(rowNum);
	    	Cell c = r.getCell(CellNum);
	        String str=c.getStringCellValue();
	        if (str.equals(existingData)) {
	        	c.setCellValue(NewData);
				
			}
	    	FileOutputStream fos=new FileOutputStream(f);
	    	wb.write(fos);
	    }
	    
	    public static void CreateRow(int rowNum,int CellNum, String Data) throws IOException {
	    	File f=new File("location.xlsx");
	    	FileInputStream fis=new FileInputStream(f);
	    	Workbook wb=new XSSFWorkbook();
	    	Sheet createSheet = wb.createSheet("Data");
	    	Row r = createSheet.createRow(rowNum);
	    	Cell c = r.createCell(CellNum);
	    	c.setCellValue("Data");
	    	FileOutputStream fos=new FileOutputStream(f);
	    	wb.write(fos);
	    }
	    
	    
	   
	    
	    
		
	

}

