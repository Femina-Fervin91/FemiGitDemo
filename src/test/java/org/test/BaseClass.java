package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	
	public void browserLaunch(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.get(url);
	}
	public void locatorInput(String locatorType,String locator,String keysToSend)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locator)).sendKeys(keysToSend);
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locator)).sendKeys(keysToSend);
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			driver.findElement(By.className(locator)).sendKeys(keysToSend);
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locator)).sendKeys(keysToSend);
		}
	}
	public void locatorClick(String locatorType,String locator)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locator)).click();		
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locator)).click();	
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			driver.findElement(By.className(locator)).click();	
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locator)).click();	
		}
	}
	public String excelRead(String path,String sht,int rownum, int cellnum) throws IOException
	{
		File f=new File(path);
		FileInputStream stream=new FileInputStream(f);
		Workbook wk= new XSSFWorkbook(stream);
		Sheet s = wk.getSheet(sht);
		Row row = s.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}
	public void getorderValue(String locatorType,String locator)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			String val = driver.findElement(By.id(locator)).getAttribute("value");
			System.out.println(val);
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			String val = driver.findElement(By.name(locator)).getAttribute("value");
			System.out.println(val);
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			String val = driver.findElement(By.className(locator)).getAttribute("value");
			System.out.println(val);
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			String val = driver.findElement(By.xpath(locator)).getAttribute("value");
			System.out.println(val);
		}
	}
	public String getText(String locator)
	{
		WebElement element = driver.findElement(By.xpath(locator));
		String text = element.getText();
		return text;
	}
	public String getAttrib(String locator)
	{
		WebElement element = driver.findElement(By.xpath(locator));
		String text = element.getAttribute("value");
		return text;
	}
	public void browserclose()
	{
		driver.close();
	}
		
}

















