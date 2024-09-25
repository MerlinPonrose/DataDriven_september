package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.datadriven.pages.CartPage;
import com.datadriven.pages.HomePage;
import com.datadriven.pages.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static HomePage hmpg = new HomePage();
	public static ProductPage prdpg = new ProductPage();
	
	public static CartPage cartpg = new CartPage();
	
	public static Common com = new Common();
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	public static DataFormatter format = new DataFormatter();
	
	public static ExcelRead excel = new ExcelRead();
	
	public static ExcelRead_Array excell = new ExcelRead_Array();
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	@BeforeMethod
	public void launchbrowser() throws IOException
	{
		File f = new File("C:\\neworkspace\\DataDrivenn_Sep\\src\\test\\java\\com\\datadriven\\config\\environmentdetails.properties");
		
		FileInputStream fis = new FileInputStream(f);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("URL");
		String browser = prop.getProperty("Browser");
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();			
		}
		
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
	}
	
	@BeforeTest
	public void generatereport()
	{
		extent = new ExtentReports();
		
		spark = new ExtentSparkReporter("target/extentReport.html");
		extent.attachReporter(spark);
	}
	
	@AfterTest
	public void endreport()
	{
		extent.flush();
	}

}
