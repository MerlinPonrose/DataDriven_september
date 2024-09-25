package com.datadriven.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import afu.org.checkerframework.checker.formatter.FormatUtil.ExcessiveOrMissingFormatArgumentException;

public class Common extends BaseClass{
	
	public void clickelement(By locator,String element) throws IOException
	{
		try
		{
			WebElement ele = driver.findElement(locator);
			ele.click();
			test.log(Status.PASS, element+"clicked successfully");
		}
		catch(Exception e)
		{
			System.out.println("Element not clicked");
			test.log(Status.FAIL, element+"not clicked");
			
			
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File f = new File("C:\\neworkspace\\July7AM_Selenium\\screenshot\\image.png");
			
			FileUtils.copyFile(src, f);
			
			test.addScreenCaptureFromPath("C:\\neworkspace\\July7AM_Selenium\\screenshot\\image.png");
			
		}
	}
	
	public void enterValue(By loc,String value)
	{
		WebElement ele = driver.findElement(loc);
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

}
